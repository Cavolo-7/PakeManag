package com.auc.service.impl;

import com.auc.mapper.PersonMapper;
import com.auc.mapper.SettlementMapper;
import com.auc.pojo.Detail;
import com.auc.pojo.LayuiData;
import com.auc.pojo.Person;
import com.auc.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SettlementServiceImpl implements SettlementService {
    @Autowired
    public SettlementMapper settlementMapper;


    @Override
    public LayuiData<Detail> selectDetailList(Map<String, String> condition, Integer curPage, Integer pageSize) {
        LayuiData<Detail> layuiData = new LayuiData();
        Integer record = settlementMapper.selectDetailCount(condition);
        List<Detail> detailList = settlementMapper.selectDetail(condition, curPage, pageSize, record);
        layuiData.setData(detailList);
        layuiData.setMsg("");
        layuiData.setCode(0);
        layuiData.setCount(record);
        layuiData.setCurrPage(curPage);
        return layuiData;
    }
}
