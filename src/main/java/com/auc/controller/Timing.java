package com.auc.controller;

import com.auc.service.TimingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

    /**
     * 系统定时执行任务
     */
@Component
public class Timing {

    @Autowired
    TimingService timingService;

    @Scheduled(cron = "0 0 0 * * ?")
    public  void Charging(){
        
        timingService.JudgeVip();
    }
}
