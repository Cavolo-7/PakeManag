package com.auc.service.impl;



import com.auc.mapper.CostrulesMapper;
import com.auc.pojo.Costrules;
import com.auc.pojo.Param;
import com.auc.service.CostruleService;
import com.auc.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Log(operationName = "查询计费规则表")
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

    @Log(operationName = "删除计费规则表")
    @Transactional
    @Override
    public boolean delCostrule(String costrulesName) {
        Param param=costrulesMapper.queryCostrulesStatic("禁用");
        int n=costrulesMapper.getCostrulesStatic(costrulesName,param.getParamValue());
        boolean fal=false;
        int num=0;
        num=costrulesMapper.delCostrules(costrulesName);
        if (num>0){
            fal=true;
        }
        return fal;
    }

    @Log(operationName = "启用计费规则表")
    @Transactional
    @Override
    public boolean UpdStatic(String costrulesName, String produceStatic) {
        boolean fal=false;
        int num=0;
        if (produceStatic.equals("启用")){
            produceStatic="启用";
        }else{
            produceStatic="禁用";
        }
        Param param=costrulesMapper.queryCostrulesStatic(produceStatic);
        num=costrulesMapper.UpdStatic(costrulesName,param.getParamValue());
        if (num>0){
            fal=true;
        }
        return fal;
    }

    @Log()
    @Override
    public boolean updCostrule(Integer costrulesId,String costrulesDescribe,Integer costrulesBasemoney,Integer costrulesAddmoney) {
        boolean fal=false;
        int num=0;
        num=costrulesMapper.updCostrules(costrulesId,costrulesDescribe,costrulesBasemoney,costrulesAddmoney);
        if (num>0){
            fal=true;
        }
        return fal;
    }

    @Log(operationName = "新增计费规则表")
    @Transactional
    @Override
    public boolean addCostrule(String costrulesName
            ,String costrulesBasemoney,String costrulesAddmoney,String costrulesDescribe
            ,String costrulesBasemoney1,String costrulesAddmoney1,String costrulesDescribe1
            ,String costrulesBasemoney2,String costrulesAddmoney2,String costrulesDescribe2
            ,String costrulesBasemoney3,String costrulesAddmoney3,String costrulesDescribe3
            ,String costrulesBasemoney4,String costrulesAddmoney4,String costrulesDescribe4) {
        Param param=costrulesMapper.queryCostrulesStatic("启用");
        boolean fal=false;
        int num=0;
        Costrules costrules=new Costrules(costrulesName,0f,0.5f,costrulesDescribe,Integer.parseInt(costrulesBasemoney),Integer.parseInt(costrulesAddmoney),param.getParamValue());
        Costrules costrules1=new Costrules(costrulesName,0.5f,3f,costrulesDescribe1,Integer.parseInt(costrulesBasemoney1),Integer.parseInt(costrulesAddmoney1),param.getParamValue());
        Costrules costrules2=new Costrules(costrulesName,3f,5f,costrulesDescribe2,Integer.parseInt(costrulesBasemoney2),Integer.parseInt(costrulesAddmoney2),param.getParamValue());
        Costrules costrules3=new Costrules(costrulesName,5f,8f,costrulesDescribe3,Integer.parseInt(costrulesBasemoney3),Integer.parseInt(costrulesAddmoney3),param.getParamValue());
        Costrules costrules4=new Costrules(costrulesName,8f,costrulesDescribe4,Integer.parseInt(costrulesBasemoney4),Integer.parseInt(costrulesAddmoney4),param.getParamValue());
        num=costrulesMapper.addCostrules(costrules);
        num=costrulesMapper.addCostrules(costrules1);
        num=costrulesMapper.addCostrules(costrules2);
        num=costrulesMapper.addCostrules(costrules3);
        num=costrulesMapper.addCostrulesdemo(costrules4);
        if (num>0){
            fal=true;
        }
        return fal;
    }
}
