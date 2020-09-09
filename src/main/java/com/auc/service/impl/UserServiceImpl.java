package com.auc.service.impl;

import com.auc.mapper.UserMapper;
import com.auc.pojo.Admin;
import com.auc.pojo.LayuiData;
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
    //查询所有用户

}
