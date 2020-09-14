package com.auc.service.impl;

import com.auc.mapper.ESMapMapper;
import com.auc.pojo.CarPort;
import com.auc.service.ESMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class ESMapServiceImpl implements ESMapService {

    @Autowired
    ESMapMapper esMapMapper;

    @Override
    public HashMap<String, List<CarPort>> QueryESMap() {
        HashMap<String, List<CarPort>> hashMap=new HashMap();
        List<CarPort> list=esMapMapper.QueryESMap();
        hashMap.put("put",list);

        return hashMap;
    }
}
