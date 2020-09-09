package com.auc.service;

import java.util.HashMap;

/**
 * 计费规则接口
 */
public interface CostruleService {
    public HashMap queryCostrule(HashMap hashMap);  //计费规则查询
    public boolean delCostrule(Integer costrulesId);  //计费规则删除
    public boolean UpdStatic(String costrulesId,String costrulesState);  //计费规则禁用-启用
    public boolean updCostrule(Integer costrulesId,Integer costrulesMoney);  //计费规则修改
    public boolean addCostrule(String costrulesTime, Integer costrulesMoney);  //计费规则增加

}
