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
        List<Integer> list = new ArrayList<Integer>();
        HashMap hashMaps = new HashMap();
        int num=detailMapper.queryFirst();
        int num2=detailMapper.queryFirsts();
        int num3=detailMapper.queryFirstss();
        int num5=num-num2;
        list.add(num3);
        list.add(num5);
        hashMaps.put("list", list);
        return hashMaps;
    }

    @Log()
    @Override
    public HashMap querySecond(HashMap hashMap) {
        List<Detail> list = new ArrayList<Detail>();
        List<Detail> list1 = new ArrayList<Detail>();
        List<Integer> mapValue = new ArrayList<Integer>();
        List<String> mapName = new ArrayList<String>();
        HashMap hashMaps = new HashMap();
        int num = 0;
        list=detailMapper.querySecond();
        list1=detailMapper.querySeconds();
        for (int i=0;i<list1.size();i++){
            for (int j=0;j<list.size();j++){
                if (list1.get(i).getDetailEvent().equals(list.get(j).getDetailEvent())){
                    list.get(j).setDetailMoney(list.get(j).getDetailMoney()-list1.get(i).getDetailMoney());
                }
            }
        }
        for (int i=0;i<list.size();i++){
            mapName.add(list.get(i).getDetailEvent());
            mapValue.add(list.get(i).getDetailMoney());
        }
        hashMaps.put("mapName", mapName);
        hashMaps.put("mapValue", mapValue);
        return hashMaps;
    }

    @Log()
    @Override
    public HashMap queryThird(HashMap hashMap) {
        List<Detail> list = new ArrayList<Detail>();
        List<Integer> lists = new ArrayList<Integer>();
        HashMap hashMaps = new HashMap();
        list=detailMapper.queryThird();
        if (list.size()>0){
            lists.add(list.get(0).getDetailMoney());
        }else {
            lists.add(0);
        }
        hashMaps.put("list", lists);
        return hashMaps;
    }

    @Log()
    @Override
    public HashMap queryFourth(HashMap hashMap) {
        List<Integer> list = new ArrayList<Integer>();
        HashMap hashMaps = new HashMap();
        int num=detailMapper.queryFourth();
        int num2=detailMapper.queryFourths();
        int car=detailMapper.queryCar();
        list.add(num-num2);
        list.add(car);
        hashMaps.put("list", list);
        return hashMaps;
    }
}
