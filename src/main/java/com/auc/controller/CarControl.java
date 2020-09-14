package com.auc.controller;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapMergePayModel;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
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
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.alipay.api.AlipayConstants.*;
import static com.auc.util.AlipayConfig.*;


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
     * @Description: 车牌扫描
     * @Date: 2020/9/11
     * @Param request:
     * @Param file:
     * @return: com.auc.util.LayuiData
     **/
    @ResponseBody
    @RequestMapping(value = "/findCarNumber")
    public LayuiData findCarNumber(HttpServletRequest request, MultipartFile file) throws IOException {
        String projectPath = FileUtil.uploadFile(request, file);
        String accessToken = authServiceImpl.getAuth();//获取accessToken
        Result carInfo = FileUtil.getCarNumber(projectPath, accessToken);//调用车牌识别接口扫描车牌
        LayuiData layuiData = new LayuiData();
        if (carInfo.getError_code() != null && carInfo.getError_msg() != null) {
            layuiData.setMsg("error");
        } else {
            layuiData.setMsg("success&" + carInfo.getWords_result().getNumber() + "&" + projectPath);
        }
        layuiData.setCode(0);
        return layuiData;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 空闲时显示屏信息
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
     * @Description: 车辆入场
     * @Date: 2020/9/8
     * @Param request:
     * @Param file:
     * @return: void
     **/
    @ResponseBody
    @RequestMapping(value = "/carIn")
    public WelcomeInfo carIn(HttpServletRequest request) {
        String carNumber = request.getParameter("carNumber");
        String path = request.getParameter("photoPath");
        WelcomeInfo welcomeInfo = carServiceImpl.carIn(carNumber, path);
        return welcomeInfo;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 车辆入库手动输入车牌
     * @Date: 2020/9/9
     * @Param request:
     * @Param file:
     * @return: com.auc.util.LayuiData
     **/
    @ResponseBody
    @RequestMapping(value = "/inputCarIn")
    public WelcomeInfo inputCarIn(HttpServletRequest request) {
        String carNumber = request.getParameter("carNumber");
        WelcomeInfo welcomeInfo = carServiceImpl.carIn(carNumber, null);
        return welcomeInfo;
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
    public WelcomeInfo carOut(HttpServletRequest request) {
        String carNumber = request.getParameter("carNumber");
        WelcomeInfo welcomeInfo = carServiceImpl.carOut(carNumber);
        return welcomeInfo;
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
    public String payMoney(HttpServletRequest request) {
        String payMoney = request.getParameter("payMoney");//应付金额
        String carNumber = request.getParameter("carNumber");//车牌号
        String carportId = request.getParameter("carportId");//车位id
        System.out.println("carportId："+carportId);
        boolean flag = carServiceImpl.insertDetail(new Integer(payMoney), carNumber,new Integer(carportId));
        String result = "";
        if (flag == true) {
            result = "success";
        } else {
            result = "error";
        }
        return result;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 支付宝支付
     * @Date: 2020/9/14
     * @Param request:
     * @Param response:
     * @return: void
     **/
    @ResponseBody
    @RequestMapping(value = "/Alipay")
    public String Alipay(HttpServletRequest request, HttpServletResponse response) throws IOException, AlipayApiException {
        System.out.println("alipy*********************************");
        String WIDout_trade_no = request.getParameter("WIDout_trade_no");
        String WIDsubject = request.getParameter("WIDsubject");
        String WIDtotal_amount = request.getParameter("WIDtotal_amount");
        String WIDbody = request.getParameter("WIDbody");
        System.out.println(WIDout_trade_no+","+WIDsubject+","+WIDtotal_amount+","+WIDbody);

        //封装Rsa签名方式
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl, app_id, merchant_private_key, format, charset, alipay_public_key, sign_type);  //获得初始化的AlipayClient
        //创建Request请求
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest(); //创建API对应的request
        //封装传入参数
        AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
        model.setOutTradeNo(WIDout_trade_no);//商品id
        model.setSubject(WIDsubject);//商品名称
        model.setTotalAmount(WIDtotal_amount);//支付金额
        model.setBody(WIDbody);//商品描述
        //设置参数
        alipayRequest.setBizModel(model);
        //设置异步回调地址
        alipayRequest.setNotifyUrl(notify_url);
        //设置同步回调地址
        alipayRequest.setReturnUrl(return_url);
        //生成表单
        String form = alipayClient.pageExecute(alipayRequest).getBody();
        System.out.println("form："+form);
        return form;
    }


}