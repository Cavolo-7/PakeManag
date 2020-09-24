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
    @com.auc.util.Log()
    @Override
    public List<Integer> selectMonth() {
        List<Detail> list=new ArrayList<Detail>();
        List<Integer> lists=new ArrayList<Integer>();
        list=settlementMapper.selectMonth();
        System.out.println("大小"+list.size());
//        for (int i=0;i<list.size();i++)
        for (int j=1;j<=12;j++){
            lists.add(0);
        }
      for (int i=0;i<list.size();i++){
          lists.set(list.get(i).getCountMonth()-1, list.get(i).getDetailMoney());
      }
        return lists;
    }
}
