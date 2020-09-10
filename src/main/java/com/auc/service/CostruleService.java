package com.auc.service;

import java.util.HashMap;

/**
 * 计费规则接口
 */
public interface CostruleService {
    public HashMap queryCostrule(HashMap hashMap);  //计费规则查询
    public boolean delCostrule(String costrulesName);  //计费规则删除
    public boolean UpdStatic(String costrulesName,String costrulesState);  //计费规则禁用-启用
    public boolean updCostrule(Integer costrulesId,String costrulesDescribe,Integer costrulesBasemoney,Integer costrulesAddmoney);  //计费规则修改
    public boolean addCostrule(String costrulesName
            ,String costrulesBasemoney,String costrulesAddmoney,String costrulesDescribe
            ,String costrulesBasemoney1,String costrulesAddmoney1,String costrulesDescribe1
            ,String costrulesBasemoney2,String costrulesAddmoney2,String costrulesDescribe2
            ,String costrulesBasemoney3,String costrulesAddmoney3,String costrulesDescribe3
            ,String costrulesBasemoney4,String costrulesAddmoney4,String costrulesDescribe4);  //计费规则增加

}
