package com.auc.service;


import com.auc.pojo.Admin;
import com.auc.pojo.LayuiData;
import com.auc.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *  用户管理
 */
public interface UserService {

    //查询所有用户
    public List<Role> selectRole(Integer page, Integer limit , String roleName,String urisdiction);

    //查询总页数
    public Integer queryRoleCount();

    //查询关系表中的参数值值
//    public Integer inquireUser(String paramName);

//    //增加管理员账号
    public boolean addRole(String paramName,String roleName);
}
