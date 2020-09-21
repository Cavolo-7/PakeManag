package com.auc.mapper;

import com.auc.pojo.Advertise;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
 * 广告
 */

@Repository
@Mapper
public interface AdvertiseMapper {

    public List<Advertise> findAdvertiseList();//查询广告列表

}
