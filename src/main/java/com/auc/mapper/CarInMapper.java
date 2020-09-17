package com.auc.mapper;

import com.auc.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
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

    public Integer insertExemption(Exemption exemption);//添加至免检用户表

    public List<CarPort> findCarPortList();//查询停车场车位表可停车车位

    public Integer updateCarPort(@Param("carportCarnumber") String carportCarnumber, @Param("carportPhoto") String carportPhoto,
                                 @Param("carportStarttime") String carportStarttime, @Param("carportState") Integer carportState, @Param("carportId") Integer carportId);//车信息插入停车车位表

    public Integer insertHistory(History history);//插入历史汇总表

    public String findWelcomeMsg(Integer paramValue);//查询欢迎信息

    public CarPort findCarPort(String carNumber);//根据车牌查询停车位

    public Exemption findExemption(String carNumber);//根据车牌查询免检名单表

    public Integer findTime(@Param("carNumber") String carNumber, @Param("nowDate") String nowDate);//查询停车时长

    public List<Costrules> findCostRules();//查询收费规则

    public Integer insertDetail(Detail detail);//插入支付明细表

    public Integer deleteExemption(String carNumber);//免检名单删除临时用户

    public Person findPerson(String carNumber);//根据车牌查询用户表

    public Integer insertAlipay(Alipay alipay);//支付宝订单插入数据

    public Alipay findAlipay(String alipayNumber);//支付宝订单查询数据

    public Detail findDetailTime(@Param("carNumber")String carNumber,@Param("nowDate")String newDate);//根据车牌查询支付明细表最新一条记录支付时间与当前时间差


}
