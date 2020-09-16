package com.auc.mapper;

import com.auc.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper   //这个注解代表是mybatis中的一个mapper类
@Repository  //将这个类注入spring容器
public interface PersonMapper {

    //查询普通用户相关数据信息/普通用户
    public List<Person> selectOrdinary(@Param("condition") Map<String, String> condition, @Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize, Integer record);

    //查询普通用户数据条数/普通用户
    public Integer selectOrdinaryCount(@Param("condition") Map<String, String> condition);

    //查询普通用户表格数据/vip
    public List<Person> selectVip(@Param("condition") Map<String, String> condition, @Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize, Integer record);

    //查询普通用户数据条数/vip
    public Integer selectVipCount(@Param("condition") Map<String, String> condition);

    //查询计算好的时间
    public Date selectEndTime(Record record);

    //查询产品
    public Produce selectProduceId(String produceName);

    //修改普通用户类型/添加会员
    public Integer addVip(Person person);

    //添加明细表
    public Integer addDetail(Detail detail);

    //根据id查询用户信息
    public Person selectPersonId(Integer personId);

    //添加免检
    public Integer addExemptionPerson(Exemption exemption);

    //添加用户记录
    public Integer addPersonRecord(Record record);

    //查询月缴产品名字集合
    public List<Produce> selectProduceNameList();

    //查询月缴产品名字集合状态
    public List<Produce> selectProduceStateName();

    //修改用户总消费
    public Integer updateRecharge(Person person);

    //添加用户记录加开始时间/续费
    public Integer addPersonRecords(Record record);

    //查询当前使用的产品记录
    public Record selectNowProduce(Record record);

    //查询未使用过的产品记录
    public List<Record> selectNoUseProduce(Record record);

    //根据产品id查询产品金额
    public Produce selectProduceMoney(Integer produceId);

    //查询计算产品使用天数
    public Integer selectDateTime(Record record);

    //删除用户记录表
    public Integer deletePersonRecord(Integer produceId);

    //删除年检表用户
    public Integer deleteExemptionPerson(String exemptionCarnumber);

    //退费
    public Integer updateVipIdentity(Person person);
}
