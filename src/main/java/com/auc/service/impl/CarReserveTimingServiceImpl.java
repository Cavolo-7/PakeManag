package com.auc.service.impl;

import com.auc.mapper.CarReserveMapper;
import com.auc.mapper.CarReserveTimingMapper;
import com.auc.mapper.TimingMapper;
import com.auc.pojo.Detail;
import com.auc.pojo.Person;
import com.auc.pojo.Record;
import com.auc.pojo.Reserve;
import com.auc.service.CarReserveTimingService;
import com.auc.service.TimingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 系统定时执行实现类
 */
@Service
public class CarReserveTimingServiceImpl implements CarReserveTimingService {

    @Autowired
    private CarReserveTimingMapper carReserveTimingMapper;

    /**
     * @Author: TheBigBlue
     * @Description: 判断预约停车是否超时
     * @Date: 2020/9/21
     * @return: java.util.List<com.auc.pojo.Reserve>
     **/
    @Override
    public void JudgeReserve() {
        List<Reserve> reserveList = carReserveTimingMapper.findReserveList();//查询预约列表
        System.out.println("reserveList："+reserveList);
    }

}


