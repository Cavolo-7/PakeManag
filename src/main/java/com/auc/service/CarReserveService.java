package com.auc.service;

import com.auc.pojo.Costrules;
import com.auc.pojo.Reserve;

import java.util.List;

public interface CarReserveService {

    public List<Costrules> findCostrules();//查询计费规则

    public Reserve judge(String carNumber);//判断停车位是否可预约

    public boolean isReserve(String carNumber, Integer carportId);//进行预约

    public String cancelReserve(String carNumber,Integer carportId);//取消预约

}
