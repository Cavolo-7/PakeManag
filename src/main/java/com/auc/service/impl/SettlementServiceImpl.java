package com.auc.service.impl;

import com.auc.mapper.PersonMapper;
import com.auc.mapper.SettlementMapper;
import com.auc.pojo.Detail;
import com.auc.pojo.LayuiData;
import com.auc.pojo.Person;
import com.auc.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SettlementServiceImpl implements SettlementService {
    @Autowired
    public SettlementMapper settlementMapper;

    @com.auc.util.Log()
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
    //月份总收入统计
    @Override
    public List<Detail> selectMonth() {
        List<Detail> list=new ArrayList<Detail>();
        list=settlementMapper.selectMonth();
        Detail detail=new Detail();
        for (int i=0;i<list.size();i++){
            for (int j=1;i<=12;j++){
                if (j!=list.get(i).getCountMonth()){
                    detail.setDetailMoney(0);
                    list.add(detail);
                }else {
                   detail.setDetailMoney(list.get(i).getDetailMoney());
                }
            }
        }
        return list;
    }
}
