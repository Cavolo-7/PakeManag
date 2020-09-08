package com.auc.mapper;

import com.auc.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
  * @Author: TheBigBlue
  * @Description: 车辆入场
  * @Date: 2020/9/8
  * @Param null:
  * @return: null
  **/
@Repository
@Mapper
public interface CarInMapper {

    public White findWhite(String carNumber);//根据车牌号查询白名单用户表

    public Vip findVip(String carNumber);//根据车牌号查询月缴用户表

    public Integer insertExemption(Exemption exemption);//添加至免检用户表

    public List<CarPort> findCarPortList();//查询停车场车位表可停车车位

    public Integer updateCarPort(@Param("carportCarnumber") String carportCarnumber, @Param("carportPhoto")String carportPhoto, @Param("carportId")Integer carportId);//车信息插入停车车位表

    public Integer insertHistory(History history);//插入历史汇总表

    public String findWelcomeMsg();//查询欢迎信息


}
