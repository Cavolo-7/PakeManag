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
        System.out.println(username);
        int num = 0;
        list=personManageMapper.queryWhite(page,pageSize,username,account,phone,worker,carnumber);
        num=personManageMapper.queryWhiteCount(username,account,phone,worker,carnumber);
        hashMaps.put("list", list);
        hashMaps.put("num", num);
        return hashMaps;
    }
}
