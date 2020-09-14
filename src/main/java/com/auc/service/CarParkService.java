package com.auc.service;

import com.auc.pojo.CarPort;
import com.auc.pojo.LayuiData;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface CarParkService {
    //查询总停车位数据信息
    public HashMap selectAllParkList(HashMap hashMap);

    //查询分区停车位数据信息
    public HashMap selectSubareaParkList(HashMap hashMap);
}
