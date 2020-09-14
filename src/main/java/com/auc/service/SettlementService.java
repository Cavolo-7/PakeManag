package com.auc.service;

import com.auc.pojo.Detail;
import com.auc.pojo.LayuiData;
import com.auc.pojo.Person;

import java.util.Map;

public interface SettlementService {

    //查询收支明细列表表格数据/
    public LayuiData<Detail> selectDetailList(Map<String, String> condition, Integer curPage, Integer pageSize);
}


