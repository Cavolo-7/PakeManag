package com.auc.mapper;

/**
  * @Author: TheBigBlue
  * @Description: 车辆入场
  * @Date: 2020/9/8
  * @Param null:
  * @return: null
  **/
public interface CarInMapper {

    public void findWhite(String carNumber);//根据车牌号查询白名单用户表

    public void findVip(String carNumber);//根据车牌号查询月缴用户表

    public Integer insertExemption();//添加至免检用户表

    public void findCarPort(String carNumber);//查询停车场车位表可停车车位

    public Integer insertCarPort();//车信息插入停车车位表

    public Integer insertHistoryss();//插入历史汇总表


}
