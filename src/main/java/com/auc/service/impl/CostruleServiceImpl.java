package com.auc.service.impl;



import com.auc.mapper.CostrulesMapper;
import com.auc.pojo.Costrules;
import com.auc.pojo.Param;
import com.auc.service.CostruleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 计费规则实现类
 */
@Service
public class CostruleServiceImpl implements CostruleService {

    @Autowired
    CostrulesMapper costrulesMapper;

    @Override
    public HashMap queryCostrule(HashMap hashMap) {
        List<Costrules> list = new ArrayList<Costrules>();
        HashMap hashMaps = new HashMap();
        int page = (int) hashMap.get("page");
        int pageSize = (int) hashMap.get("pageSize");
        int num = 0;
        list=costrulesMapper.queryCostrules(page,pageSize);
        num=costrulesMapper.queryCostrulesCount();
        System.out.println(list);
        hashMaps.put("list", list);
        hashMaps.put("num", num);
        return hashMaps;
    }

    @Override
    public boolean delCostrule(Integer costrulesId) {
        boolean fal=false;
        int num=0;
        num=costrulesMapper.delCostrules(costrulesId);
        if (num>0){
            fal=true;
        }
        return fal;
    }

    @Override
    public boolean UpdStatic(String produceId, String produceStatic) {
        boolean fal=false;
        int num=0;
        if (produceStatic.equals("启用")){
            produceStatic="启用";
        }else{
            produceStatic="禁用";
        }
        Param param=costrulesMapper.queryCostrulesStatic(produceStatic);
        num=costrulesMapper.UpdStatic(Integer.parseInt(produceId),param.getParamValue());
        if (num>0){
            fal=true;
        }
        return fal;
    }

    @Override
    public boolean updCostrule(Integer costrulesId,Integer costrulesMoney) {
        boolean fal=false;
        int num=0;
        num=costrulesMapper.updCostrules(costrulesId,costrulesMoney);
        if (num>0){
            fal=true;
        }
        return fal;
    }

    @Override
    public boolean addCostrule(String costrulesTime, Integer costrulesMoney) {
        Param param=costrulesMapper.queryCostrulesStatic("启用");
        boolean fal=false;
        int num=0;
        Costrules costrules=new Costrules(costrulesTime,costrulesMoney,param.getParamValue());
        num=costrulesMapper.addCostrules(costrules);
        if (num>0){
            fal=true;
        }
        return fal;
    }
}
