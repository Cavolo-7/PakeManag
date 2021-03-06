package com.auc.service;

import com.auc.pojo.*;

import java.util.List;
import java.util.Map;

public interface AdminService {

    //查询管理员列表表格数据
    public LayuiData<Admin> selectAdminList(Map<String, String> condition, Integer curPage, Integer pageSize);

    //管理员离职
    public boolean updateDimission(Admin admin);

    //查询参数id
    public Integer selectParam(String paramName);

    //重置管理员密码
    public boolean updateAdminPassword(String workerAccount);

    //添加管理员账号
    public boolean addAdmin(Admin admin);

    //查询角色id
    public Integer selectRoleId(String roleName);

    //查询员工状态参数id
    public Integer selectWorkerParam(String paramName);

    //查询员工性别参数id
    public Integer selectSexParam(String sexName);

    //查询管理员账号是否存在
    public Admin selectAdminAccount(String workerAccount);

    //查询用户账号是否存在
    public Person selectPersonAccount(String personAccount);

    //查询管理员手机号码是否存在
    public  Admin selectAdminPhone(String workerPhoe);

    //修改管理员
    public boolean updateAdmin(Admin admin);

    //查询角色名字集合
    public List<Role> selectRoleList();

    //查询角色名字集合状态
    public List<Role> selectRoleStateName();

    //查询收费员名字集合
    public List<Admin> selectAdminNameList();
}
