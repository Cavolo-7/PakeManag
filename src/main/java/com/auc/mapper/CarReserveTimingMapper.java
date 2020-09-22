package com.auc.mapper;

import com.auc.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface CarReserveTimingMapper {

    public List<CarPort> findReserveCarPortList();//查询车库表已预约车位

    public Reserve findReserve(String carNumber);//根据车牌查询预约名单最新一条记录

    public Integer updateCarPort(CarPort carPort);//预约过期时，根据车牌修改预约车位状态为未预约

}
