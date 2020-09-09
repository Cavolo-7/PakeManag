package com.auc.service;

import com.auc.pojo.Admin;
import com.auc.pojo.LayuiData;

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

    //查询员工参数id
    public Integer selectWorkerParam(String paramName);

    //查询管理员账号是否存在
    public Admin selectAdminAccount(String workerAccount);

    //查询管理员手机号码是否存在
    public  Admin selectAdminPhone(String workerPhoe);

    //修改管理员
    public boolean updateAdmin(Admin admin);
}
