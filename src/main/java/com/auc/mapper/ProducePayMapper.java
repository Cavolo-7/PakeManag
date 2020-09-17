package com.auc.mapper;

import com.auc.pojo.Alipay;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 月缴产品网上支付
 */
@Mapper
@Repository
public interface ProducePayMapper {

    //插入订单信息
    public Integer addProducePay(Alipay alipay);

    //根据订单账号查询相关信息
    public Alipay selectProducePay(String alipayNumber);
}
