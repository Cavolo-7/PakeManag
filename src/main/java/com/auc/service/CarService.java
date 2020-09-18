package com.auc.service;

import com.auc.pojo.Alipay;
import com.auc.pojo.CarPort;
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

    public Integer findCarPortNum();//查询车库剩余车位

    public WelcomeInfo noCarWelcome();//空闲时入场显示屏信息

    public WelcomeInfo carIn(String carNumber, String path);//车辆入场

    public WelcomeInfo carOut(String carNumber);//车辆出场

    public boolean carOutNoPay(String carNumber, Integer carportId);//车辆出场无需缴费

    public boolean carOutMoney(Integer money, String carNumber, Integer carportId);//车辆出场现金支付

    public String carOutAlipay(String subject, String total_amount, String body);//车辆出场调用支付宝进行支付

    public boolean carOutAlipaySuccess(Integer money, String carNumber, Integer carportId);//车辆出场支付宝支付成功

    public String alipay(String subject, String total_amount, String body);//自助缴费调用支付宝进行支付

    public boolean alipaySuccess(Integer money, String carNumber, Integer carportId);//自助缴费支付宝支付成功

    public Alipay findAlipay(String alipayNumber);//支付宝订单查询数据

    public WelcomeInfo findCarPayInfo(String carNumber);//查询车辆结算信息

    public CarPort findCarPort(String carNumber);//根据车牌查询车位


}