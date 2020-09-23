package com.auc.service.impl;

import com.alipay.api.domain.Car;
import com.auc.mapper.CarReserveMapper;
import com.auc.mapper.CarReserveTimingMapper;
import com.auc.mapper.TimingMapper;
import com.auc.pojo.*;
import com.auc.service.CarReserveTimingService;
import com.auc.service.TimingService;
import com.auc.util.Log;
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
    @Log()
    @Override
    public void JudgeReserve() {
        //查询车库表已预约车位
        List<CarPort> carPortList = carReserveTimingMapper.findReserveCarPortList();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String curTime = df.format(new Date());//当前时间
        //遍历已预约车位
        if (carPortList != null) {
            for (int i = 0; i < carPortList.size(); i++) {
                //根据车位中车牌查询预约列表最新一条记录
                Reserve reserve = carReserveTimingMapper.findReserve(carPortList.get(i).getCarportCarnumber());
                if (reserve != null) {
                    String reserveTime = reserve.getReserveTime();//预约时间
                    Integer timeout = curTime.compareTo(reserveTime);//比较时间
                    //当前时间>预约时间，预约过期，修改车库表已预约车位为未预约
                    if (timeout > 0) {
                        System.out.println("预约过期");
                        CarPort carPort = new CarPort();
                        carPort.setCarportId(carPortList.get(i).getCarportId());
                        carPort.setCarportCarnumber(null);
                        carPort.setCarportReserveid(null);
                        Integer updateCarPortNum = carReserveTimingMapper.updateCarPort(carPort);
                    } else {
                        System.out.println("预约未过期");
                    }
                }
            }
        }
    }

}


