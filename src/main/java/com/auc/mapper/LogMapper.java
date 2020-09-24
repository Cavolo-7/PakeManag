package com.auc.mapper;

import com.auc.pojo.Log;
import com.auc.pojo.White;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository  //将这个类注入spring容器
public interface LogMapper {
    public List<Log> queryLog(Integer page, Integer limit, String worker);  //查询日志

    public Integer queryLogCount( String worker); //查询日志总页码

}
