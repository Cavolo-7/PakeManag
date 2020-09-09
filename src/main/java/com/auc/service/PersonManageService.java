package com.auc.service;

import com.auc.pojo.White;

import java.util.HashMap;

public interface PersonManageService {

    public HashMap queryWhite(HashMap hashMap);  //白名单查询
    public boolean delWhite(String whiteAccount);  //白名单删除
    public boolean updWhite(String whiteAccount,String whiteName,String whiteCarnumber, String whitePhone);  //白名单修改
    public boolean addWhite(White white);  //白名单增加
}
