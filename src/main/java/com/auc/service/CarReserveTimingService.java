package com.auc.service;

import com.auc.pojo.Reserve;

import java.util.HashMap;
import java.util.List;

public interface CarReserveTimingService {

    /**
     * @Author: TheBigBlue
     * @Description:  判断预约停车是否超时
     * @Date: 2020/9/21
     * @return: java.util.List<com.auc.pojo.Reserve>
     **/
    public void JudgeReserve();

}
