package com.auc.service.impl;

import com.alibaba.fastjson.JSON;
import com.auc.mapper.CarInMapper;
import com.auc.pojo.*;
import com.auc.service.CarService;
import com.auc.util.Base64Util;
import com.auc.util.FileUtil;
import com.auc.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URLEncoder;
import java.util.ArrayList;
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
    public String carIn(String accessToken, String path) {
        String carNumber = "";
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/license_plate";// 请求url
        try {
            byte[] imgData = FileUtil.readFileByBytes(path);//要识别的图片路径
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam;
            String result = HttpUtil.post(url, accessToken, param);//得到车牌信息
            Result carInfo = JSON.parseObject(result, Result.class);//车牌信息Json字符串转成Result
            System.out.println("返回车牌识别结果：" + carInfo);
            //判断查询结果是否查询成功
            if (carInfo.getError_code() != null && carInfo.getError_msg() != null) {//识别失败
                //a。返回车牌识别失败消息
                System.out.println("车牌识别失败");
                return carNumber;
            } else {//识别成功
                System.out.println("车牌识别成功");
                //a。得到车牌号，车牌颜色
                //b。根据车牌号查询白名单用户表，月缴用户表
                White white = carInMapper.findWhite(carInfo.getWords_result().getNumber());
                Vip vip = carInMapper.findVip(carInfo.getWords_result().getNumber());
                System.out.println("white：" + white);
                System.out.println("vip：" + vip);
                //c。如果存在白名单用户表或月缴用户表中，获取数据，添加至免检用户表（用户名，车牌号，支付时间(临时用户缴费时添加)）
                int insertExemptionNum = 0;
                if (white != null) {
                    Exemption exemption = new Exemption();
                    exemption.setExemptionCarnumber(carInfo.getWords_result().getNumber());//车牌号
                    exemption.setExemptionName(white.getWhiteName());//用户名
                    insertExemptionNum = carInMapper.insertExemption(exemption);//插入免检名单表
                } else if (vip != null) {
                    Exemption exemption = new Exemption();
                    exemption.setExemptionCarnumber(carInfo.getWords_result().getNumber());//车牌号
                    exemption.setExemptionName(vip.getVipName());//用户名
                    insertExemptionNum = carInMapper.insertExemption(exemption);//插入免检名单表
                } else {
                    System.out.println("临时用户");
                }
                //d。如果不存在白名单用户表或月缴用户表中，为临时用户
                //e。查询停车场车位表，将可使用车位随机分配一个车位给该用户
                List<CarPort> carPortList = carInMapper.findCarPortList();
                System.out.println("carPortList：" + carPortList);
                List<CarPort> noUseCarPortList = new ArrayList<>();//未占用车位
                for (int i = 0; i < carPortList.size(); i++) {
                    if (carPortList.get(i).getCarportCarnumber() == null) {
                        noUseCarPortList.add(carPortList.get(i));
                    }
                }
                System.out.println("noUseCarPortList：" + noUseCarPortList);
                int num = (int) (Math.random() * (noUseCarPortList.size()));
                System.out.println("未分配的车位数：" + num);
                CarPort carPort = noUseCarPortList.get(num);//分配的停车位
                System.out.println("分配的停车位：" + carPort);
                //f。将车辆服务器中照片路径，车牌号，停车照片，开始停车时间（当前时间），插入停车车位表，车位id为e步骤中分配的车位id
                int updateCarPortNum = carInMapper.updateCarPort(carInfo.getWords_result().getNumber(), path, carPort.getCarportId());//插入停车车位表
                //g。将车辆服务器中照片路径，车牌号，开始停车时间（当前时间），插入历史汇总表
//                History history = new History();
//                history.setHistoryCarnumber(carInfo.getWords_result().getNumber());
//                history.setHistoryPhoto(path);
//                int insertHistoryNum = carInMapper.insertHistory(history);//插入历史汇总表
                if (updateCarPortNum > 0) {
                    carNumber = carInfo.getWords_result().getNumber();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carNumber;
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
        String welcomeMsg = carInMapper.findWelcomeMsg();//欢迎信息
        //（2）当前停车场车位情况
        List<CarPort> carPortList = carInMapper.findCarPortList();//查询停车场车位表
        List<CarPort> useList = new ArrayList<>();
        for (int i = 0; i < carPortList.size(); i++) {
            if ((carPortList.get(i).getCarportCarnumber() != null)&&(!carPortList.get(i).getCarportCarnumber().equals(""))) {
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
     * @Description: 车辆时入场显示屏信息
     * @Date: 2020/9/8
     * @return: void
     **/
    @Override
    public WelcomeInfo carWelcome(String carNumber) {
        //（1）欢迎信息
        String welcomeMsg = carInMapper.findWelcomeMsg();//欢迎信息
        //（2）当前停车场车位情况
        List<CarPort> carPortList = carInMapper.findCarPortList();//查询停车场车位表
        List<CarPort> useList = new ArrayList<>();
        for (int i = 0; i < carPortList.size(); i++) {
            if ((carPortList.get(i).getCarportCarnumber() != null)&&(!carPortList.get(i).getCarportCarnumber().equals(""))) {
                useList.add(carPortList.get(i));
            }
        }
        int allNum = carPortList.size();//a。共多少车位
        int useNum = useList.size(); //b。已使用多少车位（已停车）
        int noNum = allNum - useNum;//c。剩余多少可使用空车位
        // (3)用户停车位
        CarPort carPort = carInMapper.findCarPort(carNumber);
        White white = carInMapper.findWhite(carNumber);
        Vip vip = carInMapper.findVip(carNumber);
        WelcomeInfo welcomeInfo = new WelcomeInfo();
        welcomeInfo.setWelcomeMsg(welcomeMsg);
        welcomeInfo.setAllNum(allNum);
        welcomeInfo.setUseNum(useNum);
        welcomeInfo.setNoNum(noNum);
        welcomeInfo.setCarNumber(carNumber);
        String Port = carPort.getCarportArea() + "区" + carPort.getCarportNumber() + "号";
        welcomeInfo.setCarPort(Port);
        if (white != null) {
            welcomeInfo.setCarType("白名单用户");
        } else if (vip != null) {
            welcomeInfo.setCarType("月缴停车");
        } else {
            welcomeInfo.setCarType("临时停车");
        }
        return welcomeInfo;
    }
}