package com.auc.service;

import com.auc.pojo.Alipay;

public interface ProducePayService {
    //插入订单信息
    public boolean addProducePay(Alipay alipay);

    //根据订单账号查询相关信息
    public Alipay selectProducePay(String alipayNumber);
}
