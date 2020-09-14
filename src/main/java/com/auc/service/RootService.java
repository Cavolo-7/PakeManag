package com.auc.service;

import com.auc.pojo.Menu;
import com.auc.pojo.TreeNode;

import java.util.List;

public interface RootService {

    //查询全部菜单
    public List<Menu> inquireMenu(Integer roleId);

    //根据角色显示菜单
    public List<Menu> findMenu(Integer roleId);


}
