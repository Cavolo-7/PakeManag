package com.auc.service.impl;

import com.alibaba.fastjson.JSON;
import com.auc.mapper.CarInMapper;
import com.auc.pojo.*;
import com.auc.service.CarService;
import com.auc.util.*;
import com.auc.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
     * @Description: 车辆入场
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
        List<CarPort> carPortList = carInMapper.findCarPortList(); //e。查询停车场车位表
        CarPort carPort = CountUtil.getCarParkPosition(carPortList);//分配停车位
        carInMapper.updateCarPort(carNumber, path, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), 1, carPort.getCarportId());//插入停车车位表
        //g。将车辆服务器中照片路径，车牌号，开始停车时间（当前时间），插入历史汇总表
        History history = new History();
        history.setHistorCarnumber(carNumber);
        history.setHistorPhoto(path);
        carInMapper.insertHistory(history);//插入历史汇总表
        welcomeInfo.setCarNumber(carNumber);//车牌号
        welcomeInfo.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));//入场时间
        welcomeInfo.setCarPort(carPort.getCarportArea() + "区" + carPort.getCarportNumber() + "号");//车位
        welcomeInfo.setWelcomeMsg(carInMapper.findWelcomeMsg(1001));//欢迎信息
        return welcomeInfo;
    }


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
     * @Description: 车辆出场(扫描识别成功)
     * @Date: 2020/9/10
     * @Param accessToken:
     * @Param path:
     * @return: java.lang.String
     **/
    @Override
    public WelcomeInfo carOut(String carNumber) {
        WelcomeInfo welcomeInfo = new WelcomeInfo();
        //判断该车牌是否停车在车库
        CarPort carPort = carInMapper.findCarPort(carNumber);
        if (carPort != null) {
            Exemption exemption = carInMapper.findExemption(carNumber);//查询免检名单表
            String nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//当前时间
            int minute = carInMapper.findTime(carNumber, nowDate);//查询车库表返回计算后的停车时长(分)
            if (exemption != null) {
                welcomeInfo.setPayState("已缴费");
                //免检名单判断是否为临时用户自助缴费，是-- 出场则要从白名单移除该用户
                if (exemption.getExemptionPaytime() != null && !exemption.getExemptionPaytime().equals("")) {
                    welcomeInfo.setCarType("临时停车");
                    carInMapper.deleteExemption(carNumber);
                } else {
                    Person person = carInMapper.findPerson(carNumber);
                    if (person != null && person.getPersonIdentity() == 1) {
                        welcomeInfo.setCarType("月缴停车");
                    } else {
                        welcomeInfo.setCarType("白名单用户");
                    }
                }
            } else {
                welcomeInfo.setCarType("临时停车");
                welcomeInfo.setPayState("未缴费");
                float hour = CountUtil.getHour(minute);//停车小时整
                List<Costrules> rulesList = carInMapper.findCostRules();//查询收费规则
                int money = CountUtil.getMoney(rulesList, hour);//计算费用
                welcomeInfo.setMoney(money);
            }
            welcomeInfo.setCarNumber(carNumber);
            welcomeInfo.setWelcomeMsg(carInMapper.findWelcomeMsg(1002));
            welcomeInfo.setCarPort(carPort.getCarportArea() + "区" + carPort.getCarportNumber() + "号");
            welcomeInfo.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(carPort.getCarportStarttime()));
            welcomeInfo.setEndTime(nowDate);
            welcomeInfo.setLongTime(minute + "");
            welcomeInfo.setCarportId(carPort.getCarportId());
        }
        return welcomeInfo;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 车辆出场现金支付
     * @Date: 2020/9/11
     * @Param accessToken:
     * @Param path:
     * @return: boolean
     **/
    @Override
    public boolean insertDetail(Integer money, String carNumber, Integer carportId) {
        int updateCarPortNum = carInMapper.updateCarPort(null, null, null, 2, carportId);//插入停车车位表
        Detail detail = new Detail();
        detail.setDetailCarnumber(carNumber);
        detail.setDetailMoney(money);
        detail.setDetailEvent("临时缴费");
        detail.setProduceId(new Integer(0));
        detail.setDetailType("现金");
        boolean flag = false;
        int num = carInMapper.insertDetail(detail);//插入消费明细表
        if (num > 0 && updateCarPortNum > 0) {
            flag = true;
        }
        return flag;
    }


}