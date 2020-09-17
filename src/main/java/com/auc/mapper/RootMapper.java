package com.auc.mapper;

import com.auc.pojo.Menu;
import com.auc.pojo.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface RootMapper {

    //查询所有用户
    public List<Param> selectRole(Integer page, Integer limit,String paramName);

    //查询页码
    public Integer queryRoleCount(String paramName);

    //查询系统全部菜单
    public List<Menu> inquireMenu(Integer parentId);

    //根据权限等级查询对应的菜单
    public List<Menu> findAdminMenuById(Integer parentId, Integer urisdictionId);

    //删除该权限等级所有权限
    public Integer deleteAll(Integer urisdictionId);

    //增加该权限等级所分配到的权限
    public Integer insertAll(HashMap hashMap);


}
