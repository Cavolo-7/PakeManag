package com.auc.service;

import com.auc.pojo.Admin;
import com.auc.pojo.LayuiData;
import com.auc.pojo.Produce;
import com.auc.pojo.Vip;

import java.util.Map;

public interface VipService {

    //查询vip用户列表表格数据
    public LayuiData<Vip> selectVipList(Map<String, String> condition, Integer curPage, Integer pageSize);

    //重置vip密码
    public boolean updateVipPassword(String vipAccount);

    //添加vip用户
    public boolean addVip(Vip vip);

    //查询vip参数id
    public Integer selectVipParam(String sexName);

    //查询产品id
    public Produce selectProduceId(String produceName);

    //查询vip账号是否存在
    public Vip selectVipAccount(String vipAccount);

    //查询vip电话号码是否存在
    public Vip selectVipPhone(String vipPhone);

    //查询vip车牌号是否存在
    public Vip selectVipCarNumber(String vipCarNumber);

    //vip套餐续费
    public boolean updateVipProduce(Vip vip);
}
