package com.auc.mapper;

import com.auc.pojo.Detail;
import com.auc.pojo.Person;

import com.auc.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface TimingMapper {

    public List<Person> JudgeVip(); //得到会员名单

    public List<Record> QueryVip(Integer personId, Date date); //判断时间区间

    public void UpdateVip(Integer personId);   //移除会员

    public void RemoveVip(Integer personId);   //移除记录

    public List<Detail> Sttlement(String starTime, String endTime); //判断时间区间

}
