package com.auc.service;

import com.auc.pojo.White;

import java.util.HashMap;

public interface PersonManageService {

    public HashMap queryWhite(HashMap hashMap);  //白名单查询
    public HashMap delWhite(String account);  //白名单查询
    public HashMap updWhite(HashMap hashMap);  //白名单修改
    public HashMap addWhite(White white);  //白名单增加
}
