package com.auc.service;

import com.auc.pojo.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PersonService {

    //查询普通用户列表表格数据/普通用户
    public LayuiData<Person> selectOrdinaryList(Map<String, String> condition, Integer curPage, Integer pageSize);

    //查询普通用户列表表格数据/vip
    public LayuiData<Person> selectVipList(Map<String, String> condition, Integer curPage, Integer pageSize);

    //查询计算好的时间
    public Date selectEndTime(Record record);

    //查询产品
    public Produce selectProduceId(String produceName);

    //修改普通用户类型/添加会员
    public boolean addVip(Person person);

    //添加明细
    public boolean addDetail(Detail detail);

    //根据id查询用户信息
    public Person selectPersonId(Integer personId);

    //添加免检
    public boolean addExemptionPerson(Exemption exemption);

    //添加用户记录
    public boolean addPersonRecord(Record record);

    //查询月缴产品名字集合
    public List<Produce> selectProduceNameList();

    //查询月缴产品名字集合状态
    public List<Produce> selectProduceStateName();

    //修改用户总消费
    public boolean updateRecharge(Person person);

    //添加用户记录加开始时间
    public boolean addPersonRecords(Record record);

    //查询当前使用的产品记录
    public Record selectNowProduce(Record record);

    //查询未使用过的产品记录
    public List<Record> selectNoUseProduce(Record record);

    //根据产品id查询产品金额
    public Produce selectProduceMoney(Integer produceId);

    //查询计算产品使用天数
    public boolean selectDateTime(Record record);

    //删除用户记录表
    public boolean deletePersonRecord(Integer produceId);

    //删除年检表用户
    public boolean deleteExemptionPerson(String exemptionCarnumber);

    //退费
    public boolean updateVipIdentity(Person person);
}
