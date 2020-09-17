package com.auc.service.impl;

import com.auc.mapper.PersonManageMapper;
import com.auc.pojo.White;
import com.auc.service.PersonManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PersonManageimpl implements PersonManageService {

    @Autowired
    PersonManageMapper personManageMapper;

    @Override
    public HashMap queryWhite(HashMap hashMap) {
        List<White> list = new ArrayList<White>();
        HashMap hashMaps = new HashMap();
        int page = (int) hashMap.get("page");
        int pageSize = (int) hashMap.get("pageSize");
        String username = (String) hashMap.get("username");
        String account = (String) hashMap.get("account");
        String phone = (String) hashMap.get("phone");
        String worker = (String) hashMap.get("worker");
        String carnumber = (String) hashMap.get("carnumber");
        int num = 0;
        list=personManageMapper.queryWhite(page,pageSize,username,account,phone,worker,carnumber);
        num=personManageMapper.queryWhiteCount(username,account,phone,worker,carnumber);
        hashMaps.put("list", list);
        hashMaps.put("num", num);
        return hashMaps;
    }

    @Override
    public boolean delWhite(String whiteAccount) {
        boolean fal=false;
        int num=0;
        num=personManageMapper.delWhite(whiteAccount);
        if (num>0){
            fal=true;
        }
        return fal;
    }

    @Override
    public boolean updWhite(String whiteAccount,String whiteName,String whiteCarnumber, String whitePhone) {
        boolean fal=false;
        int num=0;
        num=personManageMapper.updWhite(whiteAccount,whiteName,whiteCarnumber,whitePhone);
        if (num>0){
            fal=true;
        }
        return fal;
    }

    @Override
    public boolean addWhite(White white) {
        boolean fal=false;
        int num=0;
        num=personManageMapper.addWhite(white);
        if (num>0){
            personManageMapper.addExemption(white.getWhiteName(),white.getWhiteCarnumber());
            fal=true;
        }
        return fal;
    }
}
