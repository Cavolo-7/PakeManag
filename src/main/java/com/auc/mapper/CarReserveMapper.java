package com.auc.mapper;

import com.auc.pojo.Advertise;
import com.auc.pojo.CarPort;
import com.auc.pojo.Costrules;
import com.auc.pojo.Reserve;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CarReserveMapper {

    public List<Costrules> findCostrules();//查询计费规则

    public List<CarPort> findCarPortList();//查询停车场全部车位

    public CarPort findCarPort(String carNumber);//根据车牌查询停车车位表

    public Integer insertReserve(Reserve reserve);//添加预约信息

    public Integer updateCarport(CarPort carPort);//修改车库表

    public Reserve findReserveById(Integer id);//根据预约id查询预约表

}
