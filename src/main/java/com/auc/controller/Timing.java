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
    public void JudgeVip(){
        timingService.JudgeVip();
    }

    //早班
    @Scheduled(cron = "0 0 0 * * ?")
    public void Sttlement(){

        timingService.Sttlement();
    }

    //午班
    @Scheduled(cron = "0 0 0 * * ?")
    public void Sttlement2(){

        timingService.Sttlement2();
    }

    //晚班
    @Scheduled(cron = "0 0 0 * * ?")
    public void Sttlement3(){

        timingService.Sttlement3();
    }
}
