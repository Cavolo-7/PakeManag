package com.auc.mapper;

import com.auc.pojo.Produce;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DetailMapper {

    public List<Produce> queryFirst(Integer page, Integer limit); //临时用户和月缴用户

    public List<Produce> querySecond(Integer page, Integer limit); //月缴用户不同产品包
    public Integer querySecondCount(); //月缴用户不同产品包总页码

    public List<Produce> queryThird(Integer page, Integer limit); //自助缴费

    public List<Produce> queryFourth(Integer page, Integer limit); //总收入规则
}
