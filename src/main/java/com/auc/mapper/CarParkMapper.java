package com.auc.mapper;

import com.auc.pojo.Admin;
import com.auc.pojo.CarPort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper   //这个注解代表是mybatis中的一个mapper类
@Repository  //将这个类注入spring容器
public interface CarParkMapper {
    //查询总停车位数据信息
    public List<CarPort> selectAllPark(Integer page, Integer limit);

    //查询分区停车位数据信息
    public List<CarPort> selectSubareaPark(Integer page, Integer limit);

    //查询类型个数
    public Integer selectSubareaNumber();

}
