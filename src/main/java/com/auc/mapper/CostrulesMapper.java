package com.auc.mapper;

import com.auc.pojo.Costrules;
import com.auc.pojo.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 计费规则类
 */

@Mapper
@Repository
public interface CostrulesMapper {

    public List<Costrules> queryCostrules(Integer page, Integer limit);  //查询计费规则

    public Integer queryCostrulesCount(); //查询计费规则总页码

    public Integer delCostrules(String costrulesName);  //计费规则删除

    public Integer updCostrules(Integer costrulesId,String costrulesDescribe,Integer costrulesBasemoney,Integer costrulesAddmoney);  //计费规则修改

    public Integer addCostrules(Costrules costrules);  //计费规则增加

    public Integer addCostrulesdemo(Costrules costrules);  //计费规则增加(增加8时区)

    public Integer UpdStatic(String costrulesName,Integer costrulesState); //计费规则禁用-启用

    public Param queryCostrulesStatic(String paramName); //通过查找参数表找到对应的value值

    public Integer getCostrulesStatic(String costrulesName,Integer costrulesState); //查询计费规则状态是否禁用--和删除一起使用
}
