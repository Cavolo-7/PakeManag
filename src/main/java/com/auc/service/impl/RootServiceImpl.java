package com.auc.service.impl;

import com.auc.mapper.RootMapper;
import com.auc.pojo.Menu;
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
        list=rootMapper.inquireMenu();
        return list;
    }
    //根据角色显示菜单
    @Override
    public List<Menu> findMenu(Integer roleId) {
        List<Menu> list1=new ArrayList<>();
        list1=rootMapper.findMenu(roleId);
        return list1;
    }

}
