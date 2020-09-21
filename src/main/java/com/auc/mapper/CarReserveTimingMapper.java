package com.auc.mapper;

import com.auc.pojo.Detail;
import com.auc.pojo.Person;
import com.auc.pojo.Record;
import com.auc.pojo.Reserve;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface CarReserveTimingMapper {

    public List<Reserve> findReserveList();//查询预约名单

}
