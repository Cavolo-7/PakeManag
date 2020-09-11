package com.auc.service.impl;

import com.auc.mapper.DetailMapper;
import com.auc.pojo.Detail;

import com.auc.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    DetailMapper detailMapper;

    @Override
    public HashMap queryFirst(HashMap hashMap) {
        List<Detail> list = new ArrayList<Detail>();
        HashMap hashMaps = new HashMap();
        int page = (int) hashMap.get("page");
        int pageSize = (int) hashMap.get("pageSize");
        list=detailMapper.queryFirst(page,pageSize);
        hashMaps.put("list", list);
        return hashMaps;
    }

    @Override
    public HashMap querySecond(HashMap hashMap) {
        List<Detail> list = new ArrayList<Detail>();
        HashMap hashMaps = new HashMap();
        int page = (int) hashMap.get("page");
        int pageSize = (int) hashMap.get("pageSize");
        int num = 0;
        list=detailMapper.querySecond(page,pageSize);
        hashMaps.put("list", list);
        hashMaps.put("num", num);
        return hashMaps;
    }

    @Override
    public HashMap queryThird(HashMap hashMap) {
        List<Detail> list = new ArrayList<Detail>();
        HashMap hashMaps = new HashMap();
        int page = (int) hashMap.get("page");
        int pageSize = (int) hashMap.get("pageSize");
        list=detailMapper.queryThird(page,pageSize);
        hashMaps.put("list", list);
        return hashMaps;
    }

    @Override
    public HashMap queryFourth(HashMap hashMap) {
        List<Detail> list = new ArrayList<Detail>();
        HashMap hashMaps = new HashMap();
        int page = (int) hashMap.get("page");
        int pageSize = (int) hashMap.get("pageSize");
        int num=detailMapper.queryFourth(page,pageSize);
        int car=detailMapper.queryCar(page,pageSize);
        Detail detail=new Detail();
        detail.setDetailMoney(num);
        detail.setDetailEvent(String.valueOf(car));
        list.add(detail);
        hashMaps.put("list", list);
        return hashMaps;
    }
}