package com.auc.mapper;


import com.auc.pojo.Admin;
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

    //删除管理员账号
    public Integer deleteAdmin(String workerAccount);

}
