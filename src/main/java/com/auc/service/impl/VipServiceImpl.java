package com.auc.service.impl;



import com.auc.mapper.VipMapper;
import com.auc.pojo.*;
import com.auc.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class VipServiceImpl implements VipService {

    @Autowired
    public VipMapper vipMapper;

    //查询vip用户列表表格数据
    @Override
    public LayuiData<Vip> selectVipList(Map<String, String> condition, Integer curPage, Integer pageSize) {
        LayuiData<Vip> layuiData = new LayuiData();
        Integer record = vipMapper.selectVipCount(condition);
        List<Vip> vipList = vipMapper.selectVip(condition, curPage, pageSize, record);
        layuiData.setData(vipList);
        layuiData.setMsg("");
        layuiData.setCode(0);
        layuiData.setCount(record);
        layuiData.setCurrPage(curPage);
        return layuiData;
    }

    //重置vip密码
    @Override
    public boolean updateVipPassword(String vipAccount) {
        boolean flag=false;
        int n=vipMapper.updateVipPassword(vipAccount);
        if (n>0){
            flag=true;
        }
        return flag;
    }

    //添加vip用户
    @Override
    public boolean addVip(Vip vip) {

        boolean flag=false;
        int n=vipMapper.addVip(vip);
        if (n>0){
            flag=true;
        }
        return flag;
    }

    //查询vip参数
    @Override
    public Integer selectVipParam(String sexName) {
        int n=vipMapper.selectVipParam(sexName);
        return n;
    }

    //查询产品id
    @Override
    public Produce selectProduceId(String produceName) {
        Produce produce=vipMapper.selectProduceId(produceName);
        return produce;
    }

    //查询vip账号是否存在
    @Override
    public Vip selectVipAccount(String vipAccount) {
        Vip vip=vipMapper.selectVipAccount(vipAccount);
        return vip;
    }

    //查询vip电话号码是否存在
    @Override
    public Vip selectVipPhone(String vipPhone) {
        Vip vip=vipMapper.selectVipPhone(vipPhone);
        return vip;
    }

    //查询vip车牌号是否存在
    @Override
    public Vip selectVipCarNumber(String vipCarNumber) {
        Vip vip=vipMapper.selectVipCarNumber(vipCarNumber);
        return vip;
    }

    //vip套餐续费
    @Override
    public boolean updateVipProduce(Vip vip) {

        boolean flag=false;
        int n=vipMapper.updateVipProduce(vip);
        if (n>0){
            flag=true;
        }
        return flag;
    }

    //添加明细
    @Override
    public boolean addDetail(Detail detail) {
        boolean flag=false;
        int n=vipMapper.addDetail(detail);
        if (n>0){
            flag=true;
        }
        return flag;
    }

    @Override
    public Date selectEndTime(Vip vip) {
        Date date=vipMapper.selectEndTime(vip);

        return date;
    }

    @Override
    public List<Produce> selectProduceNameList() {
        List<Produce> list=new ArrayList<Produce>();

        list=vipMapper.selectProduceNameList();
        return list;
    }

    @Override
    public List<Produce> selectProduceStateName() {
        List<Produce> list=new ArrayList<Produce>();

        list=vipMapper.selectProduceStateName();
        return list;
    }

    @Override
    public boolean updateVipRecharge(Integer vipRecharge) {
        boolean flag=false;
        int n=vipMapper.updateVipRecharge(vipRecharge);
        if (n>0){
            flag=true;
        }
        return flag;
    }
}
