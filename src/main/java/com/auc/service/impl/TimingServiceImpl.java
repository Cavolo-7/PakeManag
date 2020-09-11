package com.auc.service.impl;

import com.auc.mapper.TimingMapper;
import com.auc.pojo.Vip;
import com.auc.service.TimingService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
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
        List<Vip> list = new ArrayList<Vip>();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        list=timingMapper.JudgeVip();
        Date nowDate=new Date();
        for (int i=0;i<list.size();i++) {
            try {
                Date endDate = sdf.parse(list.get(0).getVipEndTime());
                boolean flag = nowDate.getTime() >= endDate.getTime();
                if (flag){
                    timingMapper.RemoveVip(list.get(0).getVipAccount());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

}


