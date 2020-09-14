package com.auc.mapper;

import com.auc.pojo.CarPort;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ESMapMapper {

    public List<CarPort> QueryESMap();  //查询车位情况

}
