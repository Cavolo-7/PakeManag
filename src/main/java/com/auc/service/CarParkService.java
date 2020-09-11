package com.auc.service;

import com.auc.pojo.CarPort;
import com.auc.pojo.LayuiData;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface CarParkService {
    //查询管理员相关数据信息
    public HashMap selectAllParkList(HashMap hashMap);
}
