package com.auc.service;

import com.auc.pojo.Menu;
import com.auc.pojo.Param;
import com.auc.pojo.Role;
import com.auc.pojo.TreeNode;

import java.util.List;

public interface RootService {

    //查询所有用户
    public List<Param> selectRole(Integer page, Integer limit,String paramName);

    //查询总页数
    public Integer queryRoleCount(String paramName);

    //根据权限等级查询对应的菜单
    public TreeNode findRootMenu(Integer parentId,Integer urisdictionId);

    //修改权限等级所分配的菜单
    public boolean UpdateMenu(List<Integer> menuIdList, Integer urisdictionId);


}
