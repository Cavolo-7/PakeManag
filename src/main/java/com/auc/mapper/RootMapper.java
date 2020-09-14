package com.auc.mapper;

import com.auc.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper   //这个注解代表是mybatis中的一个mapper类
@Repository  //将这个类注入spring容器
public interface RootMapper {

    //查询全部菜单
    public List<Menu> inquireMenu();

    //根据角色显示菜单
    public List<Menu> findMenu(Integer roleId);

}
