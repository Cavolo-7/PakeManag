package com.auc.service.impl;

import com.auc.mapper.UserMapper;
import com.auc.pojo.Admin;
import com.auc.pojo.LayuiData;
import com.auc.pojo.Param;
import com.auc.pojo.Role;
import com.auc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;
    //查询所有用户
    @Override
    public List<Role> selectRole(Integer page, Integer limit ,String roleName,String urisdiction) {
        page=(page-1)*limit;
        List<Role> roleList = userMapper.selectRole(page, limit,roleName,urisdiction);
        return roleList;
    }
    //查询总页数
    @Override
    public Integer queryRoleCount() {
        int count = userMapper.queryRoleCount();
        return count;
    }
    //查询关系表中的参数值值

    //增加管理员账号
    @Override
    public boolean addRole(String paramName,String roleName) {
       boolean flag=false;

       Param param =userMapper.inquireUser(paramName);
       Param param2=userMapper.inquireUser("启用");
       int n=userMapper.addRole(param.getParamValue(),roleName,param2.getParamValue());
       if (n>0){
           flag=true;
       }
        return flag;
    }
    //查询所有用户

}
