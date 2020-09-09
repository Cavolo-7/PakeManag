package com.auc.mapper;

import com.auc.pojo.Param;
import com.auc.pojo.Produce;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品管理类
 */

@Mapper
@Repository
public interface ProduceMapper {

    public List<Produce> queryProduce(Integer page, Integer limit, String produceName, String paramName); //查询月缴产品

    public Integer queryProduceCount(String produceName, String paramName); //查询月缴产品总页码

    public Integer delProduce(Integer produceId,Integer produceStatic);  //月缴产品禁用-启用

    public Integer updProduce(String produceId,String produceName,String produceMoney);  //月缴产品修改

    public Integer addProduce(Produce produce);  //月缴产品增加

    public Param queryProduceStatic(String paramName); //通过查找参数表找到对应的value值
}
