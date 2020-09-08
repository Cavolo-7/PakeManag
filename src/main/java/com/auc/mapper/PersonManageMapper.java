package com.auc.mapper;

import com.auc.pojo.White;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PersonManageMapper {

    public List<White> queryWhite(@Param(value = "page") Integer page, @Param(value = "limit")Integer limit, @Param(value = "whiteName") String whiteName, @Param(value = "account")String account, @Param(value = "phone")String phone, @Param(value = "worker")String worker, @Param(value = "carnumber")String carnumber);  //查询白名单

    public Integer queryWhiteCount(@Param(value = "whiteName") String whiteName, @Param(value = "account")String account, @Param(value = "phone")String phone, @Param(value = "worker")String worker, @Param(value = "carnumber")String carnumber); //查询白名单总页码
}
