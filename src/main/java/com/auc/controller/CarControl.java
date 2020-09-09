package com.auc.controller;


import com.auc.pojo.WelcomeInfo;
import com.auc.service.impl.AuthServiceImpl;
import com.auc.service.impl.CarServiceImpl;
import com.auc.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

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
        String originalFilename = file.getOriginalFilename();//获取文件名
        String prefix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1); //获取后缀名（格式）
        String uuid = UUID.randomUUID().toString();//使用UUID+后缀名保存
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = df.format(date);
        String savePath = request.getSession().getServletContext().getRealPath("/upload");//保存路径
        //要保存的路径和文件名
        String projectPath = savePath + File.separator + dateStr + File.separator + uuid + "." + prefix;
        System.out.println("保存路径：" + projectPath);
        File files = new File(projectPath);
        //判断目录是否存在
        if (!files.getParentFile().exists()) {
            files.getParentFile().mkdirs();
        }
        file.transferTo(files);// 将接收的文件保存到指定文件中
        System.out.println("success");
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

}