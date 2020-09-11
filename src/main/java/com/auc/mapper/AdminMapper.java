package com.auc.mapper;


import com.auc.pojo.Admin;
import com.auc.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper   //这个注解代表是mybatis中的一个mapper类
@Repository  //将这个类注入spring容器
public interface AdminMapper {

    //查询管理员相关数据信息
    public List<Admin> selectAdmin(@Param("condition") Map<String, String> condition, @Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize, Integer record);

    //查询计算
    public Integer selectAdminCount(@Param("condition") Map<String, String> condition);

    //管理员离职
    public Integer updateDimission(Admin admin);

    //查询参数id
    public Integer selectParam(String paramName);

    //查询员工参数id
    public Integer selectWorkerParam(String paramName);

    //重置管理员密码
    public Integer updateAdminPassword(String workerAccount);

    //添加管理员账号
    public Integer addAdmin(Admin admin);

    //查询角色id
    public Integer selectRoleId(String roleName);

    //查询管理员账号是否存在
    public Admin selectAdminAccount(String workerAccount);

    //查询管理员手机号码是否存在
    public  Admin selectAdminPhone(String workerPhoe);

    //修改管理员
    public Integer updateAdmin(Admin admin);

    //查询角色名字集合
    public List<Role> selectRoleNameList();

    //查询角色名字集合状态
    public List<Role> selectRoleStateName();
}
