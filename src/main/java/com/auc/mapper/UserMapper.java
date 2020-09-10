package com.auc.mapper;


import com.auc.pojo.*;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper   //这个注解代表是mybatis中的一个mapper类
@Repository  //将这个类注入spring容器
public interface UserMapper {
    //查询所有用户
    public  List<Role> selectRole(Integer page,Integer limit, String roleName,String urisdiction);

    //查询页码
    public Integer queryRoleCount();

    //查询关系表中的参数值值
     public Param inquireUser(String paramName);

    //增加管理员账号
    public Integer addRole(Integer urisdictionId,String roleName);
}
