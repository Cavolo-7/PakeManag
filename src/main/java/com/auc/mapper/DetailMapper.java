package com.auc.mapper;

import com.auc.pojo.Detail;
import com.auc.pojo.Produce;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DetailMapper {

    public Integer queryFirst(); //月缴用户

    public Integer queryFirsts(); //月缴退费

    public Integer queryFirstss(); //临时缴费

    public List<Detail> querySecond(); //月缴用户不同产品包

    public List<Detail> querySeconds(); //月缴用户不同产品包退费

    public List<Detail> queryThird(); //自助缴费

    public Integer queryFourth(); //总收入规则

    public Integer queryFourths(); //总收入规则

    public Integer queryCar(); //总停车次数规则
}
