package com.auc.mapper;

import com.auc.pojo.Detail;
import com.auc.pojo.Produce;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DetailMapper {

    public Integer queryFirst(Integer page, Integer limit); //月缴用户

    public Integer queryFirsts(Integer page, Integer limit); //月缴退费

    public Integer queryFirstss(Integer page, Integer limit); //临时缴费

    public List<Detail> querySecond(Integer page, Integer limit); //月缴用户不同产品包

    public List<Detail> querySeconds(Integer page, Integer limit); //月缴用户不同产品包退费

    public List<Detail> queryThird(Integer page, Integer limit); //自助缴费

    public Integer queryFourth(Integer page, Integer limit); //总收入规则

    public Integer queryFourths(Integer page, Integer limit); //总收入规则

    public Integer queryCar(Integer page, Integer limit); //总停车次数规则
}
