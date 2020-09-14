package com.auc.service.impl;

import com.auc.mapper.TimingMapper;

import com.auc.pojo.Person;
import com.auc.pojo.Record;
import com.auc.service.TimingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 系统定时执行实现类
 */
@Service
public class TimingServiceImpl implements TimingService {

    @Autowired
    TimingMapper timingMapper;

    @Override
    public void JudgeVip() {
        SimpleDateFormat sdf  =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Person> list = new ArrayList<Person>();
        List<Record> lists = new ArrayList<Record>();
        list=timingMapper.JudgeVip();
        Date nowDate=new Date();
        System.out.println(nowDate);
        for (int i=0;i<list.size();i++) {
            lists= timingMapper.QueryVip(list.get(0).getPersonId(),nowDate);
                if ( lists.size() <= 0) {
                    timingMapper.UpdateVip(list.get(0).getPersonId());
                    timingMapper.RemoveVip(list.get(0).getPersonId());

                }
        }
    }

    @Override
    public void Sttlement() {
        String earlyTime=getDate(8,0);
        String afterTime=getDate(16,0);

        timingMapper.Sttlement(earlyTime,afterTime);
    }

    @Override
    public void Sttlement2() {
        String afterTime=getDate(16,0);
        String nightTime=getDate(24,0);
        timingMapper.Sttlement(afterTime,nightTime);
    }

    @Override
    public void Sttlement3() {
        String nightTime=getDate(24,0);
        String nextTime=getDate(8,1);
        timingMapper.Sttlement(nightTime,nextTime);
    }

    public String getDate(Integer inte ,Integer inte2){
        Date date = new Date();
        if (inte2==1) {
            date.setDate(date.getDate()+1);
        }else{
            date.setDate(date.getDate());
        }
        date.setHours(inte);
        date.setMinutes(0);
        date.setSeconds(0);
        Long goodsTime=date.getTime();
        String str=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(goodsTime);
        return str;
    }

}


