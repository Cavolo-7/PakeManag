package com.auc.mapper;

import com.auc.pojo.Menu;
import com.auc.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper   //这个注解代表是mybatis中的一个mapper类
@Repository  //将这个类注入spring容器
public interface RootMapper {

    //根据id显示全部菜单-
    public List<Menu> inquireMenu(Integer roleId);

    //查询全部菜单
    public List<Menu> findMenu(Integer roleId);

    //查询所有用户
    public  List<Role> selectRole(Integer page, Integer limit, String roleName, String urisdiction, String roleState);

    //查询页码
    public Integer queryRoleCount();

    public List<Menu> findAdminMenuById(Integer parentId,Integer urisdictionId);
}
