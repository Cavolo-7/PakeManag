package com.auc.mapper;

import com.auc.pojo.Admin;
import com.auc.pojo.Produce;
import com.auc.pojo.Vip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper   //这个注解代表是mybatis中的一个mapper类
@Repository  //将这个类注入spring容器
public interface VipMapper {

    //查询vip用户相关数据信息
    public List<Vip> selectVip(@Param("condition") Map<String, String> condition, @Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize, Integer record);

    //查询计算条数
    public Integer selectVipCount(@Param("condition") Map<String, String> condition);

    //重置vip密码
    public Integer updateVipPassword(String vipAccount);

    //添加vip用户
    public Integer addVip(Vip vip);

    //查询vip参数id
    public Integer selectVipParam(String sexName);

    //查询产品id
    public Produce selectProduceId(String produceName);

    //查询vip账号是否存在
    public Vip selectVipAccount(String vipAccount);

    //查询vip电话号码是否存在
    public Vip selectVipPhone(String vipPhone);

    //查询vip车牌号是否存在
    public Vip selectVipCarNumber(String vipCarNumber);

    //vip套餐续费
    public Integer updateVipProduce(Vip vip);

    //添加明细表
//    public Integer addDetail(Detail detail);
}
