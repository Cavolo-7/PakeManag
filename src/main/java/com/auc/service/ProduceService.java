package com.auc.service;


/**
 * 产品管理接口
 */
import java.util.HashMap;

public interface ProduceService {

    public HashMap queryProduce(HashMap hashMap);  //月缴产品查询
    public boolean delProduce(String produceId,String produceStatic);  //月缴产品禁用-启用
    public boolean updProduce(String produceId,String produceName,String produceMoney);  //月缴产品修改
    public boolean addProduce(String produceName, String produceDescribe,String produceMoney);  //月缴产品增加
}
