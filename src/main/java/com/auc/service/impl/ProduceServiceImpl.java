package com.auc.service.impl;

import com.auc.mapper.ProduceMapper;
import com.auc.pojo.Param;
import com.auc.pojo.Produce;
import com.auc.pojo.White;
import com.auc.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ProduceServiceImpl implements ProduceService {

    @Autowired
    ProduceMapper produceMapper;

    @Override
    public HashMap queryProduce(HashMap hashMap) {
        List<Produce> list = new ArrayList<Produce>();
        HashMap hashMaps = new HashMap();
        int page = (int) hashMap.get("page");
        int pageSize = (int) hashMap.get("pageSize");
        String produceStatic = (String) hashMap.get("produceStatic");
        String produceName = (String) hashMap.get("produceName");
        int num = 0;
        list=produceMapper.queryProduce(page,pageSize,produceName,produceStatic);
        num=produceMapper.queryProduceCount(produceName,produceStatic);
        System.out.println(list);
        hashMaps.put("list", list);
        hashMaps.put("num", num);
        return hashMaps;
    }

    @Override
    public boolean delProduce(String produceId,String produceStatic) {
        boolean fal=false;
        int num=0;
        if (produceStatic.equals("启用")){
            produceStatic="禁用";
        }else{
            produceStatic="启用";
        }
        Param param=produceMapper.queryProduceStatic(produceStatic);
        num=produceMapper.delProduce(produceId,param.getParamValue());
        if (num>0){
            fal=true;
        }
        return fal;
    }

    @Override
    public boolean updProduce(String produceId,String produceName,String produceMoney) {
        boolean fal=false;
        int num=0;
        num=produceMapper.updProduce(produceId,produceName,produceMoney);
        if (num>0){
            fal=true;
        }
        return fal;
    }

    @Override
    public boolean addProduce(String produceName, String produceDescribe,String produceMoney) {
        boolean fal=false;
        int num=0;
        Param param=produceMapper.queryProduceStatic("启用");
        Produce produce=new Produce(produceName,produceDescribe,Integer.parseInt(produceMoney),param.getParamValue());
        num=produceMapper.addProduce(produce);
        if (num>0){
            fal=true;
        }
        return fal;
    }
}