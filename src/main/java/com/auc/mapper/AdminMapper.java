package com.auc.mapper;


import com.auc.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper   //这个注解代表是mybatis中的一个mapper类
@Repository  //将这个类注入spring容器
public interface AdminMapper {

    public Admin Longin(Admin admin);

}
