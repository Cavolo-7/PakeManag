package com.auc.mapper;

import com.auc.pojo.Detail;
import com.auc.pojo.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper   //这个注解代表是mybatis中的一个mapper类
@Repository  //将这个类注入spring容器
public interface SettlementMapper {

    //查询当天收支明细相关数据信息
    public List<Detail> selectDetail(@Param("condition") Map<String, String> condition, @Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize, Integer record);

    //查询当天收支明细数据条数
    public Integer selectDetailCount(@Param("condition") Map<String, String> condition);

    //查询月份总收入
    public List<Detail> selectMonth();
}
