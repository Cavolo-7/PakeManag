package com.auc.mapper;

import com.auc.pojo.Vip;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TimingMapper {

    public List<Vip> JudgeVip(); //得到结束时间

    public void RemoveVip(String vipAccount);   //移除会员

}
