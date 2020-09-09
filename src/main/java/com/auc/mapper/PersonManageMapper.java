package com.auc.mapper;
/**
 * 人员管理类
 */
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

    public Integer delWhite(String whiteAccount);  //白名单删除

    public Integer updWhite(String whiteAccount,String whiteName,String whiteCarnumber, String whitePhone);  //白名单修改

    public Integer addWhite(White white);  //白名单增加
}
