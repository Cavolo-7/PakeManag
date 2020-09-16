package com.auc.service.impl;

import com.auc.mapper.RootMapper;
import com.auc.pojo.Menu;
import com.auc.pojo.Role;
import com.auc.pojo.TreeNode;
import com.auc.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RootServiceImpl implements RootService {

    @Autowired
    public RootMapper rootMapper;
    //查询全部菜单
    @Override
    public List<Menu> inquireMenu(Integer roleId) {
        List<Menu> list = new ArrayList<>();
        list=rootMapper.inquireMenu(roleId);
        return list;
    }
    //根据角色显示菜单
    @Override
    public List<Menu> findMenu(Integer roleId) {
//        List<Menu> list1=new ArrayList<>();
//        list1=rootMapper.findMenu(roleId);
        List<Menu> list = rootMapper.findAdminMenuById(new Integer(0),new Integer(roleId));
        return list;
    }

    @Override
    public List<Role> selectRole(Integer page, Integer limit ,String roleName,String urisdiction,String roleState) {
        page=(page-1)*limit;
        List<Role> roleList = rootMapper.selectRole(page, limit,roleName,urisdiction,roleState);
        return roleList;
    }

    //查询总页数
    @Override
    public Integer queryRoleCount() {
        int count = rootMapper.queryRoleCount();
        return count;
    }

}
