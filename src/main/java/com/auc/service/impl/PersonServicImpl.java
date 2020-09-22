package com.auc.service.impl;

import com.auc.mapper.AdminMapper;
import com.auc.mapper.PersonMapper;
import com.auc.pojo.*;
import com.auc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PersonServicImpl implements PersonService {

    @Autowired
    public PersonMapper personMapper;
    //查询普通用户列表表格数据/普通用户
    @com.auc.util.Log()
    @Override
    public LayuiData<Person> selectOrdinaryList(Map<String, String> condition, Integer curPage, Integer pageSize) {
        LayuiData<Person> layuiData = new LayuiData();
        Integer record = personMapper.selectOrdinaryCount(condition);
        List<Person> personList = personMapper.selectOrdinary(condition, curPage, pageSize, record);
        layuiData.setData(personList);
        layuiData.setMsg("");
        layuiData.setCode(0);
        layuiData.setCount(record);
        layuiData.setCurrPage(curPage);
        return layuiData;
    }

    //查询普通用户列表表格数据/vip
    @com.auc.util.Log()
    @Override
    public LayuiData<Person> selectVipList(Map<String, String> condition, Integer curPage, Integer pageSize) {
        LayuiData<Person> layuiData = new LayuiData();
        Integer record = personMapper.selectVipCount(condition);
        List<Person> personList = personMapper.selectVip(condition, curPage, pageSize, record);
        layuiData.setData(personList);
        layuiData.setMsg("");
        layuiData.setCode(0);
        layuiData.setCount(record);
        layuiData.setCurrPage(curPage);
        return layuiData;
    }

    //查询计算好的时间
    @com.auc.util.Log()
    @Override
    public Date selectEndTime(Record record) {
        Date date=personMapper.selectEndTime(record);

        return date;
    }

    //查询产品
    @com.auc.util.Log()
    @Override
    public Produce selectProduceId(String produceName) {
        Produce produce=personMapper.selectProduceId(produceName);
        return produce;
    }
    //添加vip
    @com.auc.util.Log()
    @Override
    public boolean addVip(Person person) {
        boolean flag=false;
        int n=personMapper.addVip(person);
        if (n>0){
            flag=true;
        }
        return flag;
    }

    //添加明细表
    @com.auc.util.Log()
    @Override
    public boolean addDetail(Detail detail) {
        boolean flag=false;
        int n=personMapper.addDetail(detail);
        if (n>0){
            flag=true;
        }
        return flag;
    }
    //根据id查询用户信息
    @com.auc.util.Log()
    @Override
    public Person selectPersonId(Integer personId) {
        Person person=personMapper.selectPersonId(personId);
        return person;
    }
    //添加免检
    @com.auc.util.Log()
    @Override
    public boolean addExemptionPerson(Exemption exemption) {
        boolean flag=false;
        int n=personMapper.addExemptionPerson(exemption);
        if (n>0){
            flag=true;
        }
        return flag;
    }

    //添加用户记录
    @com.auc.util.Log()
    @Override
    public boolean addPersonRecord(Record record) {
        boolean flag=false;
        int n=personMapper.addPersonRecord(record);
        if (n>0){
            flag=true;
        }
        return flag;
    }

    //查询月缴产品名字集合
    @com.auc.util.Log()
    @Override
    public List<Produce> selectProduceNameList() {
        List<Produce> list=new ArrayList<Produce>();

        list=personMapper.selectProduceNameList();
        return list;
    }

    //查询月缴产品名字/状态
    @com.auc.util.Log()
    @Override
    public List<Produce> selectProduceStateName() {
        List<Produce> list=new ArrayList<Produce>();

        list=personMapper.selectProduceStateName();
        return list;
    }

    //修改用户总消费
    @com.auc.util.Log()
    @Override
    public boolean updateRecharge(Person person) {
        boolean flag=false;
        int n=personMapper.updateRecharge(person);
        if (n>0){
            flag=true;
        }
        return flag;
    }

    //添加用户记录加开始时间
    @com.auc.util.Log()
    @Override
    public boolean addPersonRecords(Record record) {
        boolean flag=false;
        int n=personMapper.addPersonRecords(record);
        if (n>0){
            flag=true;
        }
        return flag;
    }

    //查询当前使用的产品记录
    @com.auc.util.Log()
    @Override
    public Record selectNowProduce(Record record) {
        Record record2=personMapper.selectNowProduce(record);
        return record2;
    }

    //查询未使用过的产品记录
    @com.auc.util.Log()
    @Override
    public List<Record> selectNoUseProduce(Record record) {
        List<Record> list=new ArrayList<Record>();
        list=personMapper.selectNoUseProduce(record);
        return list;
    }

    //根据产品id查询产品金额
    @com.auc.util.Log()
    @Override
    public Produce selectProduceMoney(Integer produceId) {
        Produce produce=personMapper.selectProduceMoney(produceId);
        return produce;
    }

    //查询计算产品使用天数
    @com.auc.util.Log()
    @Override
    public boolean selectDateTime(Record record) {
        boolean flag=false;
        int n=personMapper.selectDateTime(record);
        if (n>15){
            flag=true;
        }else if (n<=15){
            flag=false;
        }
        return flag;
    }

    //删除用户记录表
    @com.auc.util.Log()
    @Override
    public boolean deletePersonRecord(Integer produceId) {
        boolean flag=false;
        int n=personMapper.deletePersonRecord(produceId);
        if (n>0){
            flag=true;
        }
        return flag;
    }

    //删除年检表用户
    @com.auc.util.Log()
    @Override
    public boolean deleteExemptionPerson(String exemptionCarnumber) {
        boolean flag=false;
        int n=personMapper.deleteExemptionPerson(exemptionCarnumber);
        if (n>0){
            flag=true;
        }
        return flag;
    }

    //退费
    @com.auc.util.Log()
    @Override
    public boolean updateVipIdentity(Person person) {
        boolean flag=false;
        int n=personMapper.updateVipIdentity(person);
        if (n>0){
            flag=true;
        }
        return flag;
    }

}
