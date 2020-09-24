package com.auc.controller;

import com.auc.pojo.Costrules;
import com.auc.pojo.Reserve;
import com.auc.pojo.WelcomeInfo;
import com.auc.service.CarReserveService;
import com.auc.service.impl.CarReserveServiceImpl;
import com.auc.service.impl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @基本功能: 停车位预约
 * @program:ParkManage
 * @author:acsk
 * @create:2020-09-21 09:24:31
 **/
@Controller
@RequestMapping(value = "/carReserve")
public class CarReserveController {

    @Autowired
    private CarReserveServiceImpl CarReserveServiceImpl;


    /**
     * @Author: TheBigBlue
     * @Description: 查询计费规则
     * @Date: 2020/9/23
     * @return: void
     **/
    @ResponseBody
    @RequestMapping(value = "/findCostrules")
    public List<Costrules> findCostrules() {
        List<Costrules> costrulesList = CarReserveServiceImpl.findCostrules();
        return costrulesList;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 判断停车位是否可预约
     * @Date: 2020/9/21
     * @return: void
     **/
    @ResponseBody
    @RequestMapping(value = "/judge")
    public Reserve judge(HttpServletRequest request) {
        String carNumber = request.getParameter("carNumber");
        Reserve reserve = CarReserveServiceImpl.judge(carNumber);
        return reserve;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 进行预约
     * @Date: 2020/9/21
     * @Param request:
     * @return: com.auc.pojo.Reserve
     **/
    @ResponseBody
    @RequestMapping(value = "/isReserve")
    public String isReserve(HttpServletRequest request) {
        String carNumber = request.getParameter("carNumber");
        String carportId = request.getParameter("carportId");
        boolean flag = CarReserveServiceImpl.isReserve(carNumber, new Integer(carportId));
        String str = "";
        if (flag == true) {
            str = "success";
        } else {
            str = "error";
        }
        return str;
    }

}