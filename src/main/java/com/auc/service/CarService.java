package com.auc.service;

import com.auc.pojo.WelcomeInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @基本功能:
 * @program:ParkManage
 * @author:acsk
 * @create:2020-09-08 09:05:43
 **/
public interface CarService {

    public String carIn(String accessToken,String path);//车辆入库

    public WelcomeInfo noCarWelcome();//空闲时入场显示屏信息

    public WelcomeInfo carWelcome(String carNumber);//车辆入场时显示屏信息

}