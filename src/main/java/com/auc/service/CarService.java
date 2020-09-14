package com.auc.service;

import com.auc.pojo.Result;
import com.auc.pojo.WelcomeInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * @基本功能:
 * @program:ParkManage
 * @author:acsk
 * @create:2020-09-08 09:05:43
 **/
public interface CarService {

    public WelcomeInfo carIn(String carNumber, String path);//车辆入场

    public WelcomeInfo noCarWelcome();//空闲时入场显示屏信息

    public WelcomeInfo carOut(String carNumber);//车辆出场

    public boolean insertDetail(Integer money, String carNumber,Integer carportId);//车辆出场现金支付

}