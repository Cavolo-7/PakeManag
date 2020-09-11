package com.auc.controller;


import com.auc.pojo.Result;
import com.auc.pojo.WelcomeInfo;
import com.auc.service.impl.AuthServiceImpl;
import com.auc.service.impl.CarServiceImpl;
import com.auc.util.FileUtil;
import com.auc.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;


/**
 * @基本功能:
 * @program:ParkManage
 * @author:acsk
 * @create:2020-09-08 08:58:29
 **/
@Controller
@RequestMapping(value = "/car")
public class CarControl {

    @Autowired
    private CarServiceImpl carServiceImpl;
    @Autowired
    private AuthServiceImpl authServiceImpl;


    /**
     * @Author: TheBigBlue
     * @Description: 车辆入场
     * @Date: 2020/9/8
     * @Param request:
     * @Param file:
     * @return: void
     **/
    @ResponseBody
    @RequestMapping(value = "/carIn")
    public LayuiData carIn(HttpServletRequest request, MultipartFile file) throws IOException {
        System.out.println("carIn");
        String projectPath = FileUtil.uploadFile(request, file);//上传文件
        String accessToken = authServiceImpl.getAuth();//获取accessToken，调用车牌识别接口
        String carNumber = carServiceImpl.carIn(accessToken, projectPath);//车辆入库业务
        LayuiData layuiData = new LayuiData();
        if ((carNumber != null) && (!carNumber.equals(""))) {
            layuiData.setMsg("success&" + carNumber);
        } else {
            layuiData.setMsg("error");
        }
        layuiData.setCode(0);
        return layuiData;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 无法识别车牌时输入车牌
     * @Date: 2020/9/9
     * @Param request:
     * @Param file:
     * @return: com.auc.util.LayuiData
     **/
    @ResponseBody
    @RequestMapping(value = "/inputCarIn")
    public LayuiData inputCarIn(HttpServletRequest request) throws IOException {
        System.out.println("inputCarIn");
        String carNumber = request.getParameter("carNumber");
        System.out.println("carNumber：" + carNumber);
        carServiceImpl.inputCarIn(carNumber);
        LayuiData layuiData = new LayuiData();
        if ((carNumber != null) && (!carNumber.equals(""))) {
            layuiData.setMsg("success&" + carNumber);
        } else {
            layuiData.setMsg("error");
        }
        layuiData.setCode(0);
        return layuiData;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 空闲时入场显示屏信息
     * @Date: 2020/9/8
     * @return: java.lang.String
     **/
    @ResponseBody
    @RequestMapping(value = "/noCarWelcome")
    public ModelAndView noCarWelcome() {
        System.out.println("noCarWelcome()");
        WelcomeInfo welcomeInfo = carServiceImpl.noCarWelcome();//查询空闲时的欢迎信息
        System.out.println(welcomeInfo);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("welcomeInfo", welcomeInfo);
        modelAndView.setViewName("/jsp/CarIn.jsp");
        return modelAndView;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 车辆入场时显示屏信息
     * @Date: 2020/9/8
     * @return: java.lang.String
     **/
    @ResponseBody
    @RequestMapping(value = "/carWelcome")
    public ModelAndView carWelcome(HttpServletRequest request) {
        String carNumber = request.getParameter("carNumber");
        System.out.println(carNumber);
        System.out.println("CarWelcome()");
        WelcomeInfo welcomeInfo = carServiceImpl.carWelcome(carNumber);//查询入场时的欢迎信息
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("welcomeInfo", welcomeInfo);
        modelAndView.setViewName("/jsp/CarIn.jsp");
        return modelAndView;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 车辆出场
     * @Date: 2020/9/10
     * @Param request:
     * @Param file:
     * @return: com.auc.util.LayuiData
     **/
    @ResponseBody
    @RequestMapping(value = "/carOut")
    public LayuiData carOut(HttpServletRequest request, MultipartFile file) throws IOException {
        String projectPath = FileUtil.uploadFile(request, file);
        String accessToken = authServiceImpl.getAuth();//获取accessToken
        Result carInfo = FileUtil.getCarNumber(projectPath, accessToken);//调用车牌识别接口扫描车牌
        LayuiData layuiData = new LayuiData();
        if (carInfo.getError_code() != null && carInfo.getError_msg() != null) {
            layuiData.setMsg("error");
        } else {
            layuiData.setMsg("success");
        }
        layuiData.setCode(0);
        return layuiData;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 车辆出场现金支付
     * @Date: 2020/9/11
     * @Param request:
     * @return: com.auc.util.LayuiData
     **/
    @ResponseBody
    @RequestMapping(value = "/payMoney")
    public String payMoney(HttpServletRequest request) throws IOException {
        String payMoney = request.getParameter("payMoney");//应付金额
        String carNumber = request.getParameter("carNumber");//车牌号
        boolean flag = carServiceImpl.insertDetail(new Integer(payMoney), carNumber);
        String result = "";
        if (flag == true) {
            result = "success";
        } else {
            result = "error";
        }
        return result;
    }


}