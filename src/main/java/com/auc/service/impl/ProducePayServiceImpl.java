package com.auc.service.impl;

import com.auc.mapper.PersonManageMapper;
import com.auc.mapper.ProducePayMapper;
import com.auc.pojo.Alipay;
import com.auc.service.ProducePayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducePayServiceImpl implements ProducePayService {

    @Autowired
    ProducePayMapper producePayMapper;

    @com.auc.util.Log()
    @Override
    public boolean addProducePay(Alipay alipay) {
        boolean flag=false;
        int n=producePayMapper.addProducePay(alipay);
        if (n>0){
            flag=true;
        }
        return flag;
    }

    @com.auc.util.Log()
    @Override
    public Alipay selectProducePay(String alipayNumber) {

        Alipay alipay=producePayMapper.selectProducePay(alipayNumber);


        return alipay;
    }
}
