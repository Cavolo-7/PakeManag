package com.auc.mapper;

import com.auc.pojo.Admin;
import com.auc.pojo.Menu;
import com.auc.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper   //这个注解代表是mybatis中的一个mapper类
@Repository  //将这个类注入spring容器
public interface LoginMapper {
    //显示菜单
    public List<Menu> findMenusByPid(@Param("parentId") Integer parentId, @Param("roleId") Integer roleId);

    //登录
    public Admin login(Admin admin);

    //查询用户权限
    public Role findRoot(Integer RoleId);

    //查询账号状态
    public  Admin chaState(String workerAccount);

    //人脸识别登录
    public Admin fecaLogin(String workerName);

    //查询角色id
    public Admin selectRoleId(String faceId);
}
