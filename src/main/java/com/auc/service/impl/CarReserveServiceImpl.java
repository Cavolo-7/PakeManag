package com.auc.service.impl;

import com.auc.mapper.AdvertiseMapper;
import com.auc.mapper.CarReserveMapper;
import com.auc.pojo.CarPort;
import com.auc.pojo.Reserve;
import com.auc.service.CarReserveService;
import com.auc.util.CountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @基本功能:
 * @program:ParkManage
 * @author:acsk
 * @create:2020-09-21 09:30:56
 **/
@Service
public class CarReserveServiceImpl implements CarReserveService {

    @Autowired
    private CarReserveMapper carReserveMapper;

    /**
     * @Author: TheBigBlue
     * @Description: 判断停车位是否可预约
     * @Date: 2020/9/21
     * @return: void
     **/
    @Override
    public Reserve judge(String carNumber) {
        Reserve reserve = new Reserve();
        //1.查询停车位车位表，判断停车场车位占用情况
        List<CarPort> carPortList = carReserveMapper.findCarPortList();
        List<CarPort> useList = new ArrayList<>();//已占用车位
        for (int i = 0; i < carPortList.size(); i++) {
            if ((carPortList.get(i).getCarportCarnumber() != null) && (!carPortList.get(i).getCarportCarnumber().equals(""))) {
                useList.add(carPortList.get(i));
            }
        }
        int noNum = carPortList.size() - useList.size();//空车位
        if (noNum <= 0) {
            reserve.setFlag(0);
            System.out.println("车位已满，不能预约");
        } else if (noNum > 0 && carNumber != null) {
            //根据车牌查询停车车位表,判断该车牌当前时间是否已停车和是否已预约
            CarPort carPort = carReserveMapper.findCarPort(carNumber);
            if (carPort != null) {
                if (carPort.getCarportReserveid() == null) {
                    System.out.println("当前时间该车已经停车");
                    reserve.setFlag(3);
                } else if (carPort.getCarportReserveid() != null) {
                    System.out.println("当前时间该车已经预约");
                    reserve.setFlag(2);
                }
            } else {
                System.out.println("进行预约");
                CarPort userCarPort = CountUtil.getCarParkPosition(carPortList);//分配车位
                reserve.setFlag(1);
                reserve.setCarPort("负" + userCarPort.getCarportFnum() + "楼" + userCarPort.getCarportArea() + "区" + userCarPort.getCarportNumber() + "号");
                reserve.setReserveCarNumber(carNumber);
                reserve.setReserveTime(CountUtil.getOneHourAgo(new Date()));
                reserve.setCarportId(userCarPort.getCarportId());
            }
        }
        return reserve;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 进行预约
     * @Date: 2020/9/21
     * @Param carNumber:
     * @return: void
     **/
    @Transactional
    @Override
    public boolean isReserve(String carNumber,Integer carportId) {
        boolean flag = false;
        //1.添加信息至预约表
        Reserve reserve = new Reserve();
        reserve.setReserveCarNumber(carNumber);
        reserve.setReserveTime(CountUtil.getOneHourAgo(new Date()));
        int insertReserveNum = carReserveMapper.insertReserve(reserve);
        //2.根据车牌号修改车位表，添加reserve_id
        CarPort carPort = new CarPort();
        carPort.setCarportReserveid(reserve.getReserveId());
        carPort.setCarportCarnumber(carNumber);
        carPort.setCarportId(carportId);
        int updateCarportNum = carReserveMapper.updateCarport(carPort);
        if (insertReserveNum > 0 && updateCarportNum > 0) {
            flag = true;
        }
        return flag;
    }
}