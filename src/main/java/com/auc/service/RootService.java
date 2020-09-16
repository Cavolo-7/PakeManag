package com.auc.service;

import com.auc.pojo.Menu;
import com.auc.pojo.Role;
import com.auc.pojo.TreeNode;

import java.util.List;

public interface RootService {

    //根据id显示全部菜单-
    public List<Menu> inquireMenu(Integer roleId);

    //菜单显示
    public List<Menu> findMenu(Integer roleId);

    //查询所有用户
    public List<Role> selectRole(Integer page, Integer limit , String roleName, String urisdiction , String roleState);

    //查询总页数
    public Integer queryRoleCount();

}
