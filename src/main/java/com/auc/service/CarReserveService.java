package com.auc.service;

import com.auc.pojo.Reserve;

public interface CarReserveService {

    public Reserve judge(String carNumber);//判断停车位是否可预约

    public boolean isReserve(String carNumber);//进行预约

}
