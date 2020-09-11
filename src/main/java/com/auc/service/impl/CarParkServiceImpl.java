package com.auc.service.impl;

import com.auc.mapper.CarParkMapper;
import com.auc.mapper.VipMapper;
import com.auc.pojo.Admin;
import com.auc.pojo.CarPort;
import com.auc.pojo.LayuiData;
import com.auc.pojo.Produce;
import com.auc.service.CarParkService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CarParkServiceImpl implements CarParkService {

    @Autowired
    public CarParkMapper carParkMapper;

    @Override
    public HashMap selectAllParkList(HashMap hashMap) {
        List<CarPort> list = new ArrayList<CarPort>();
        HashMap hashMaps = new HashMap();
        int page = (int) hashMap.get("page");
        int pageSize = (int) hashMap.get("pageSize");
        list=carParkMapper.selectAllPark(page,pageSize);
        hashMaps.put("list", list);
        return hashMaps;
    }
}
