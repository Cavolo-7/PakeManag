package com.auc.service.impl;

import com.alibaba.fastjson.JSON;
import com.auc.pojo.Result;
import com.auc.service.CarService;
import com.auc.util.Base64Util;
import com.auc.util.FileUtil;
import com.auc.util.HttpUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URLEncoder;

/**
 * @基本功能:
 * @program:ParkManage
 * @author:acsk
 * @create:2020-09-08 09:07:02
 **/
@Service
public class CarServiceImpl implements CarService {


    /**
      * @Author: TheBigBlue
      * @Description:  车辆入场
      * @Date: 2020/9/8
      * @Param accessToken:
      * @return: void
      **/
    @Transactional
    @Override
    public void carIn(String accessToken) {
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/license_plate";// 请求url
        try {
            String filePath = "C:/Users/acsk/Desktop/car1.png";//要识别的图片路径
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam;
            String result = HttpUtil.post(url, accessToken, param);//得到车牌信息
            Result carInfo = JSON.parseObject(result, Result.class);//车牌信息Json字符串转成Result
            System.out.println("返回车牌识别结果："+carInfo);
            //判断查询结果是否查询成功
            if (carInfo.getError_code()==null&&carInfo.getError_msg()==null){//识别失败
                //a。返回车牌识别失败消息
                //b。调用手动输入车牌号码输入框
                //（1）验证输入框车牌格式，不为空才提交
                //（2）得到车牌号，车牌颜色
                //（3）根据车牌号查询白名单用户表，月缴用户表
                //（4）如果存在白名单用户表或月缴用户表中，获取数据，添加至免检用户表（用户名，车牌号，支付时间？？？）
                //（5）如果不存在白名单用户表或月缴用户表中，为临时用户
                //（6）查询停车场车位表，将可使用车位随机分配一个车位给该用户
                //（7）将车辆服务器中照片路径，车牌号，停车照片，开始停车时间（当前时间），插入停车车位表，车位id为e步骤中分配的车位id
                //（8）将车辆服务器中照片路径，车牌号，开始停车时间（当前时间），插入历史汇总表
            }else {//识别成功
                //a。得到车牌号，车牌颜色
                //b。根据车牌号查询白名单用户表，月缴用户表
                //c。如果存在白名单用户表或月缴用户表中，获取数据，添加至免检用户表（用户名，车牌号，支付时间？？？）
                //d。如果不存在白名单用户表或月缴用户表中，为临时用户
                //e。查询停车场车位表，将可使用车位随机分配一个车位给该用户
                //f。将车辆服务器中照片路径，车牌号，停车照片，开始停车时间（当前时间），插入停车车位表，车位id为e步骤中分配的车位id
                //g。将车辆服务器中照片路径，车牌号，开始停车时间（当前时间），插入历史汇总表
            }
            //返回消息，入口显示屏显示信息
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}