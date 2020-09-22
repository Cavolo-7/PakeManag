package com.auc.controller;

import com.auc.service.CarReserveTimingService;
import com.auc.service.TimingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 系统定时执行任务
 */
@Component
public class CarReserveTiming {

    @Autowired
    private CarReserveTimingService carReserveTimingService;

    /**
     * @Author: TheBigBlue
     * @Description: 判断预约停车是否超时
     * @Date: 2020/9/21
     * @return: void
     **/
    @Scheduled(cron = "0 */5  * * * ?")
    public void JudgeReserve() {
        System.out.println("判断预约停车是否超时（5分钟/次）");
        carReserveTimingService.JudgeReserve();
    }

}
