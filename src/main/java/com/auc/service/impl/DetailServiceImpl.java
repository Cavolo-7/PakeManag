package com.auc.service.impl;

import com.auc.mapper.DetailMapper;
import com.auc.pojo.Detail;

import com.auc.service.DetailService;
import com.auc.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    DetailMapper detailMapper;

    @Log()
    @Override
    public HashMap queryFirst(HashMap hashMap) {
        List<Detail> list = new ArrayList<Detail>();
        HashMap hashMaps = new HashMap();
        int page = (int) hashMap.get("page");
        int pageSize = (int) hashMap.get("pageSize");
        int num=detailMapper.queryFirst(page,pageSize);
        int num2=detailMapper.queryFirsts(page,pageSize);
        int num3=detailMapper.queryFirstss(page,pageSize);
        int num5=num-num2;
        Detail detail=new Detail();
        detail.setDetailEvent("月缴用户");
        detail.setDetailMoney(num5);
        list.add(detail);
        Detail detail2=new Detail();
        detail2.setDetailEvent("临时用户");
        detail2.setDetailMoney(num3);
        hashMaps.put("list", list);
        return hashMaps;
    }

    @Log()
    @Override
    public HashMap querySecond(HashMap hashMap) {
        List<Detail> list = new ArrayList<Detail>();
        List<Detail> list1 = new ArrayList<Detail>();
        HashMap hashMaps = new HashMap();
        int page = (int) hashMap.get("page");
        int pageSize = (int) hashMap.get("pageSize");
        int num = 0;
        list=detailMapper.querySecond(page,pageSize);
        list1=detailMapper.querySeconds(page,pageSize);
        for (int i=0;i<list1.size();i++){
            for (int j=0;j<list.size();j++){
                if (list1.get(i).getDetailEvent().equals(list.get(j).getDetailEvent())){
                    list.get(j).setDetailMoney(list.get(j).getDetailMoney()-list1.get(i).getDetailMoney());
                }
            }
        }
        hashMaps.put("list", list);
        hashMaps.put("num", num);
        return hashMaps;
    }

    @Log()
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

    @Log()
    @Override
    public HashMap queryFourth(HashMap hashMap) {
        List<Detail> list = new ArrayList<Detail>();
        HashMap hashMaps = new HashMap();
        int page = (int) hashMap.get("page");
        int pageSize = (int) hashMap.get("pageSize");
        int num=detailMapper.queryFourth(page,pageSize);
        int num2=detailMapper.queryFourths(page,pageSize);
        int car=detailMapper.queryCar(page,pageSize);
        Detail detail=new Detail();
        detail.setDetailMoney(num-num2);
        detail.setDetailEvent(String.valueOf(car));
        list.add(detail);
        hashMaps.put("list", list);
        return hashMaps;
    }
}
