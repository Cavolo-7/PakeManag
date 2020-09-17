package com.auc.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.auc.mapper.CarInMapper;
import com.auc.pojo.*;
import com.auc.service.CarService;
import com.auc.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @基本功能:
 * @program:ParkManage
 * @author:acsk
 * @create:2020-09-08 09:07:02
 **/
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarInMapper carInMapper;

    /**
     * @Author: TheBigBlue
     * @Description: 空闲时入场显示屏信息
     * @Date: 2020/9/8
     * @return: void
     **/
    @Override
    public WelcomeInfo noCarWelcome() {
        //（1）欢迎信息
        String welcomeMsg = carInMapper.findWelcomeMsg(1001);//欢迎信息
        //（2）当前停车场车位情况
        List<CarPort> carPortList = carInMapper.findCarPortList();//查询停车场车位表
        List<CarPort> useList = new ArrayList<>();
        for (int i = 0; i < carPortList.size(); i++) {
            if ((carPortList.get(i).getCarportCarnumber() != null) && (!carPortList.get(i).getCarportCarnumber().equals(""))) {
                useList.add(carPortList.get(i));
            }
        }
        int allNum = carPortList.size();//a。共多少车位
        int useNum = useList.size(); //b。已使用多少车位（已停车）
        int noNum = allNum - useNum;//c。剩余多少可使用空车位
        WelcomeInfo welcomeInfo = new WelcomeInfo();
        welcomeInfo.setWelcomeMsg(welcomeMsg);
        welcomeInfo.setAllNum(allNum);
        welcomeInfo.setUseNum(useNum);
        welcomeInfo.setNoNum(noNum);
        return welcomeInfo;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 车辆入场业务
     * @Date: 2020/9/8
     * @Param accessToken:
     * @return: void
     **/
    @Transactional
    @Override
    public WelcomeInfo carIn(String carNumber, String path) {
        WelcomeInfo welcomeInfo = new WelcomeInfo();
        White white = carInMapper.findWhite(carNumber);//根据车牌号查询白名单用户表
        Person person = carInMapper.findPerson(carNumber);//根据车牌号查询用户表
        if (white != null) {
            welcomeInfo.setCarType("白名单用户");
        } else if (person != null && person.getPersonIdentity() == 1) {
            welcomeInfo.setCarType("月缴停车");
        } else {
            welcomeInfo.setCarType("临时停车");
        }
        List<CarPort> carPortList = carInMapper.findCarPortList(); //查询停车场车位表
        CarPort carPort = CountUtil.getCarParkPosition(carPortList);//随机分配一个停车位
        carInMapper.updateCarPort(carNumber, path, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), 1, carPort.getCarportId());//将车辆信息插入停车车位表
        //g。将车辆服务器中照片路径，车牌号，开始停车时间（当前时间），插入历史汇总表
        History history = new History();
        history.setHistorCarnumber(carNumber);
        history.setHistorPhoto(path);
        carInMapper.insertHistory(history);//插入历史汇总表
        welcomeInfo.setCarNumber(carNumber);//车牌号
        welcomeInfo.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));//入场时间
        welcomeInfo.setCarPort("负" + carPort.getCarportFnum() + "楼" + carPort.getCarportArea() + "区" + carPort.getCarportNumber() + "号");//车位
        welcomeInfo.setWelcomeMsg(carInMapper.findWelcomeMsg(1001));//欢迎信息
        return welcomeInfo;//返回车辆入场信息
    }


    /**
     * @Author: TheBigBlue
     * @Description: 车辆出场业务
     * @Date: 2020/9/10
     * @Param accessToken:
     * @Param path:
     * @return: java.lang.String
     **/
    @Override
    public WelcomeInfo carOut(String carNumber) {
        WelcomeInfo welcomeInfo = new WelcomeInfo();
        CarPort carPort = carInMapper.findCarPort(carNumber);//判断该车牌是否停车在车库
        Exemption exemption = carInMapper.findExemption(carNumber);//查询免检名单表
        String nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//当前时间
        int minute = carInMapper.findTime(carNumber, nowDate);//查询车库表返回计算后的停车时长(分)
        if (exemption != null) {//在免检名单中
            //免检名单判断是否为临时用户自助缴费，
            if (exemption.getExemptionPaytime() != null && !exemption.getExemptionPaytime().equals("")) {//自助缴费用户
                welcomeInfo.setCarType("临时停车");
                Detail detail = carInMapper.findDetailTime(carNumber, nowDate);//根据车牌查询支付明细表最新一条记录支付时间与当前时间差
                if (detail.getWorkerId() <= 10) {//出场时间与自助缴费时间小于10分钟
                    welcomeInfo.setPayState("已缴费");
                } else {////出场时间与自助缴费时间大于10分钟，需要重新结算费用
                    float hour = CountUtil.getHour(minute);//停车小时整
                    List<Costrules> rulesList = carInMapper.findCostRules();//查询收费规则
                    int money = CountUtil.getMoney(rulesList, hour);//计算费用
                    int remainMoney = money - detail.getDetailMoney();//补交费用
                    welcomeInfo.setMoney(remainMoney);
                    welcomeInfo.setPayState("出场超时,补交超时费用");
                }
            } else {
                welcomeInfo.setPayState("已缴费");
                Person person = carInMapper.findPerson(carNumber);
                if (person != null && person.getPersonIdentity() == 1) {//月缴停车
                    welcomeInfo.setCarType("月缴停车");
                } else {//白名单用户
                    welcomeInfo.setCarType("白名单用户");
                }
            }
        } else {//不在免检名单中
            welcomeInfo.setCarType("临时停车");
            welcomeInfo.setPayState("未缴费");
            float hour = CountUtil.getHour(minute);//停车小时整
            List<Costrules> rulesList = carInMapper.findCostRules();//查询收费规则
            int money = CountUtil.getMoney(rulesList, hour);//计算费用
            welcomeInfo.setMoney(money);
        }
        welcomeInfo.setCarNumber(carNumber);
        welcomeInfo.setWelcomeMsg(carInMapper.findWelcomeMsg(1002));
        welcomeInfo.setCarPort("负" + carPort.getCarportFnum() + "楼" + carPort.getCarportArea() + "区" + carPort.getCarportNumber() + "号");
        welcomeInfo.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(carPort.getCarportStarttime()));
        welcomeInfo.setEndTime(nowDate);
        welcomeInfo.setLongTime(minute + "");
        welcomeInfo.setCarportId(carPort.getCarportId());
        return welcomeInfo;//返回出场信息
    }


    /**
     * @Author: TheBigBlue
     * @Description:车辆出场无需缴费
     * @Date: 2020/9/17
     * @return: boolean
     **/
    @Transactional
    @Override
    public boolean carOutNoPay(String carNumber, Integer carportId) {
        boolean flag = false;
        //修改停车车位表
        int updateCarPortNum = carInMapper.updateCarPort(null, null, null, 2, carportId);
        //如果为自助缴费用户，从免检名单表中进行移除
        Exemption exemption = carInMapper.findExemption(carNumber);
        if (exemption != null) {
            carInMapper.deleteExemption(carNumber);//临时用户出场则要从免检名单中移除该用户
        }
        if (updateCarPortNum > 0) {
            flag = true;
        }
        return flag;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 车辆出场现金支付
     * @Date: 2020/9/11
     * @Param accessToken:
     * @Param path:
     * @return: boolean
     **/
    @Transactional
    @Override
    public boolean carOutMoney(Integer money, String carNumber, Integer carportId) {
        int updateCarPortNum = carInMapper.updateCarPort(null, null, null, 2, carportId);//修改停车车位表
        Detail detail = new Detail();
        detail.setDetailCarnumber(carNumber);
        detail.setDetailMoney(money);
        detail.setDetailEvent("临时缴费");
        detail.setProduceId(new Integer(0));
        detail.setDetailType("现金");
        boolean flag = false;
        int num = carInMapper.insertDetail(detail);//插入消费明细表
        //如果为自助缴费用户，从免检名单表中进行移除
        Exemption exemption = carInMapper.findExemption(carNumber);
        if (exemption != null) {
            carInMapper.deleteExemption(carNumber);//临时用户出场则要从免检名单中移除该用户
        }
        if (num > 0 && updateCarPortNum > 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * @Author: TheBigBlue
     * @Description: 车辆出场调用支付宝进行支付
     * @Date: 2020/9/15
     * @Param money:
     * @Param carNumber:
     * @Param carportId:
     * @return: boolean
     **/
    @Override
    public String carOutAlipay(String subject, String total_amount, String body) {
        String form = "";
        try {
            String uuid = UUID.randomUUID().toString();//商户订单号
            form = AlipayUtil.getAlipay(uuid, subject, total_amount, body, "http://acsk.free.idcfengye.com/car/carOutAlipayNotify", "http://acsk.free.idcfengye.com/car/carOutAlipayReturnUrl");
            Alipay alipay = new Alipay();
            alipay.setAlipayNumber(uuid);
            alipay.setAlipayCarnumber(subject);
            carInMapper.insertAlipay(alipay);//支付宝订单查询数据
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 车辆出场支付宝支付成功
     * @Date: 2020/9/15
     * @Param money:
     * @Param carNumber:
     * @Param carportId:
     * @return: boolean
     **/
    @Transactional
    @Override
    public boolean carOutAlipaySuccess(Integer money, String carNumber, Integer carportId) {
        int updateCarPortNum = carInMapper.updateCarPort(null, null, null, 2, carportId);//修改停车车位表
        Detail detail = new Detail();
        detail.setDetailCarnumber(carNumber);
        detail.setDetailMoney(money);
        detail.setDetailEvent("临时缴费");
        detail.setProduceId(new Integer(0));
        detail.setDetailType("支付宝");
        boolean flag = false;
        int num = carInMapper.insertDetail(detail);//插入消费明细表
        //如果为自助缴费用户，从免检名单表中进行移除
        Exemption exemption = carInMapper.findExemption(carNumber);
        if (exemption != null) {
            carInMapper.deleteExemption(carNumber);//临时用户出场则要从免检名单中移除该用户
        }
        if (num > 0 && updateCarPortNum > 0) {
            flag = true;
        }
        return flag;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 自助缴费调用支付宝进行支付
     * @Date: 2020/9/15
     * @Param subject:        订单标题
     * @Param total_amount:   订单金额
     * @Param body:           商品描述信息
     * @return: java.lang.String
     **/
    @Override
    public String alipay(String subject, String total_amount, String body) {
        String form = "";
        try {
            String uuid = UUID.randomUUID().toString();//商户订单号
            form = AlipayUtil.getAlipay(uuid, subject, total_amount, body, AlipayConfig.notify_url, AlipayConfig.notify_url);
            Alipay alipay = new Alipay();
            alipay.setAlipayNumber(uuid);
            alipay.setAlipayCarnumber(subject);
            carInMapper.insertAlipay(alipay);//支付宝订单查询数据
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 自助缴费支付宝支付成功
     * @Date: 2020/9/15
     * @Param money:
     * @Param carNumber:
     * @Param carportId:
     * @return: boolean
     **/
    @Transactional
    @Override
    public boolean alipaySuccess(Integer money, String carNumber, Integer carportId) {
        //1.插入明细表
        Detail detail = new Detail();
        detail.setDetailCarnumber(carNumber);//车牌
        detail.setDetailMoney(money);//交易金额
        detail.setDetailEvent("临时缴费");//缴费事件
        detail.setProduceId(new Integer(0));//临时缴费
        detail.setDetailType("支付宝");//支付方式
        Integer insertDetailNum = carInMapper.insertDetail(detail);
        //2.插入免检名单表
        Exemption exemption = new Exemption();
        exemption.setExemptionCarnumber(carNumber);//车牌号
        exemption.setExemptionName("");//用户名
        exemption.setExemptionPaytime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));//支付时间
        Integer insertExemptionNum = carInMapper.insertExemption(exemption);
        boolean flag = false;
        if (insertDetailNum > 0 && insertExemptionNum > 0) {
            flag = true;
        }
        return flag;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 支付宝订单查询数据
     * @Date: 2020/9/15
     * @Param alipayNumber:
     * @return: com.auc.pojo.Alipay
     **/
    @Override
    public Alipay findAlipay(String alipayNumber) {
        Alipay alipay = carInMapper.findAlipay(alipayNumber);
        return alipay;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 查询车辆结算信息
     * @Date: 2020/9/15
     * @Param carNumber:
     * @return: com.auc.pojo.WelcomeInfo
     **/
    @Override
    public WelcomeInfo findCarPayInfo(String carNumber) {
        WelcomeInfo welcomeInfo = new WelcomeInfo();
        //判断该车牌是否停车在车库
        CarPort carPort = carInMapper.findCarPort(carNumber);
        if (carPort != null) {
            Exemption exemption = carInMapper.findExemption(carNumber);//查询免检名单表
            String nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//当前时间
            int minute = carInMapper.findTime(carNumber, nowDate);//查询车库表返回计算后的停车时长(分)
            if (exemption != null) {
                //免检名单判断是否为临时用户自助缴费，
                if (exemption.getExemptionPaytime() != null && !exemption.getExemptionPaytime().equals("")) {
                    welcomeInfo.setCarType("临时停车");
                } else {
                    Person person = carInMapper.findPerson(carNumber);
                    if (person != null && person.getPersonIdentity() == 1) {
                        welcomeInfo.setCarType("月缴停车");
                    } else {
                        welcomeInfo.setCarType("白名单用户");
                    }
                }
                welcomeInfo.setPayState("已缴费");
            } else {
                welcomeInfo.setCarType("临时停车");
                welcomeInfo.setPayState("未缴费");
            }
            float hour = CountUtil.getHour(minute);//停车小时整
            List<Costrules> rulesList = carInMapper.findCostRules();//查询收费规则
            int money = CountUtil.getMoney(rulesList, hour);//计算费用
            welcomeInfo.setMoney(money);
            welcomeInfo.setCarNumber(carNumber);
            welcomeInfo.setWelcomeMsg(carInMapper.findWelcomeMsg(1002));
            welcomeInfo.setCarPort("负" + carPort.getCarportFnum() + "楼" + carPort.getCarportArea() + "区" + carPort.getCarportNumber() + "号");
            welcomeInfo.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(carPort.getCarportStarttime()));
            welcomeInfo.setEndTime(nowDate);
            welcomeInfo.setLongTime(minute + "");
            welcomeInfo.setCarportId(carPort.getCarportId());
        }
        return welcomeInfo;
    }

    @Override
    public CarPort findCarPort(String carNumber) {
        CarPort carPort = carInMapper.findCarPort(carNumber);
        return carPort;
    }


}