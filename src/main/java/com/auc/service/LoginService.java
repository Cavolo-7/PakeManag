package com.auc.service;

import com.auc.pojo.Admin;
import com.auc.pojo.Menu;
import com.auc.pojo.Role;

import java.util.List;
import java.util.Map;

public interface LoginService {

    //登录
    public Admin login(Admin admin);

    //菜单显示
    public Map<String, List<Menu>> findMenus(Integer roleId);

    //查询账号状态
    public  boolean chaState(String workerAccount);

    //人脸识别登录
    public Admin fecaLogin(String workerName);

    //查询角色id
    public Admin selectRoleId(String faceId);
}
