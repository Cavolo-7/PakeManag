package com.auc.mapper;


import com.auc.pojo.Admin;
import com.auc.pojo.LayuiData;
import com.auc.pojo.Produce;
import com.auc.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper   //这个注解代表是mybatis中的一个mapper类
@Repository  //将这个类注入spring容器
public interface UserMapper {
    //查询所有用户
    public  List<Role> selectRole(@Param("page") Integer page,@Param("limit") Integer limit,@Param("roleName") String roleName,@Param("urisdiction") String urisdiction);

    //查询页码
    public Integer queryRoleCount();
}
