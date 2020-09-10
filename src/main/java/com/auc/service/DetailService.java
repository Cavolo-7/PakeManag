package com.auc.service;

import java.util.HashMap;

public interface DetailService {

    public HashMap queryFirst(HashMap hashMap);   //临时用户和月缴用户
    public HashMap querySecond(HashMap hashMap);  //月缴用户不同产品包
    public HashMap queryThird(HashMap hashMap);   //自助缴费
    public HashMap queryFourth(HashMap hashMap);  //修改计费规则
}
