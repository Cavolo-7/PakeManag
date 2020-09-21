package com.auc.controller;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapMergePayModel;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.auc.mapper.CarInMapper;
import com.auc.pojo.Alipay;
import com.auc.pojo.CarPort;
import com.auc.pojo.Result;
import com.auc.pojo.WelcomeInfo;
import com.auc.service.impl.AuthServiceImpl;
import com.auc.service.impl.CarServiceImpl;
import com.auc.util.AlipayConfig;
import com.auc.util.AlipayUtil;
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
import java.io.UnsupportedEncodingException;
import java.util.*;

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
     * @Description: 空闲时显示屏信息
     * @Date: 2020/9/8
     * @return: java.lang.String
     **/
    @ResponseBody
    @RequestMapping(value = "/noCarWelcome")
    public ModelAndView noCarWelcome() {
        System.out.println("noCarWelcome()");
        WelcomeInfo welcomeInfo = carServiceImpl.noCarWelcome();//查询空闲时的欢迎信息
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("welcomeInfo", welcomeInfo);
        modelAndView.setViewName("/jsp/CarIn.jsp");
        return modelAndView;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 车牌入场扫描
     * @Date: 2020/9/11
     * @Param request:
     * @Param file:
     * @return: com.auc.util.LayuiData
     **/
    @ResponseBody
    @RequestMapping(value = "/findCarNumber")
    public LayuiData findCarNumber(HttpServletRequest request, MultipartFile file) throws IOException {
        String projectPath = FileUtil.uploadFile(request, file);//上传车辆入场照片
        String accessToken = authServiceImpl.getAuth();//获取accessToken
        Result carInfo = FileUtil.getCarNumber(projectPath, accessToken);//调用车牌识别接口扫描车牌
        LayuiData layuiData = new LayuiData();
        if (carInfo.getError_code() != null && carInfo.getError_msg() != null) {//车牌扫描失败
            layuiData.setMsg("error");
        } else {//车牌扫描成功---车辆可进场判断：（1）停车场车位满时不能再入场（2）车辆已在停车场时不能再入场
            int num = carServiceImpl.findCarPortNum();
            if (num > 0) {//停车场车位未满时
                CarPort carPort = carServiceImpl.findCarPort(carInfo.getWords_result().getNumber());//查询车库表是否有该车辆
                if (carPort == null) {//没有该车牌时
                    layuiData.setMsg("success&" + carInfo.getWords_result().getNumber() + "&" + projectPath);
                } else {//有该车牌时,判断是否为预约用户,预约时间
                    if (carPort.getCarportReserveid() != null) {//被预约
                        layuiData.setMsg("success&" + carInfo.getWords_result().getNumber() + "&" + projectPath);//返回预约用户可停车消息
                    } else {//未被预约，则是已停车，返回不能重复停车消息
                        layuiData.setMsg("repeat");
                    }
                }
            } else {//停车场车位满时
                layuiData.setMsg("full");
            }
        }
        layuiData.setCode(0);
        return layuiData;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 车牌出场扫描
     * @Date: 2020/9/11
     * @Param request:
     * @Param file:
     * @return: com.auc.util.LayuiData
     **/
    @ResponseBody
    @RequestMapping(value = "/findCarNumberOut")
    public LayuiData findCarNumberOut(HttpServletRequest request, MultipartFile file) throws IOException {
        String projectPath = FileUtil.uploadFile(request, file);//上传车辆入场照片
        String accessToken = authServiceImpl.getAuth();//获取accessToken
        Result carInfo = FileUtil.getCarNumber(projectPath, accessToken);//调用车牌识别接口扫描车牌
        LayuiData layuiData = new LayuiData();
        if (carInfo.getError_code() != null && carInfo.getError_msg() != null) {//车牌扫描失败
            layuiData.setMsg("error");
        } else {//车牌扫描成功
            //查询车库表是否有该车辆
            CarPort carPort = carServiceImpl.findCarPort(carInfo.getWords_result().getNumber());
            if (carPort == null) {
                layuiData.setMsg("nocar");//该车不在车库
            } else {
                layuiData.setMsg("success&" + carInfo.getWords_result().getNumber());//该车在车库
            }
        }
        layuiData.setCode(0);
        return layuiData;
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
        String carNumber = request.getParameter("carNumber");//车牌号
        String path = request.getParameter("photoPath");//入场照片
        WelcomeInfo welcomeInfo = carServiceImpl.carIn(carNumber, path);//车辆入场业务
        return welcomeInfo;//返回车辆入场信息
    }


    /**
     * @Author: TheBigBlue
     * @Description: 车辆入场手动输入车牌
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
        String carNumber = request.getParameter("carNumber");//车牌号
        WelcomeInfo welcomeInfo = carServiceImpl.carOut(carNumber);//车辆出场业务
        return welcomeInfo;//返回出场信息
    }


    /**
     * @Author: TheBigBlue
     * @Description: 车辆出场无需支付
     * @Date: 2020/9/17
     * @Param request:
     * @return: java.lang.String
     **/
    @ResponseBody
    @RequestMapping(value = "/carOutNoPay")
    public String carOutNoPay(HttpServletRequest request) {
        String carNumber = request.getParameter("carNumber");//车牌号
        String carportId = request.getParameter("carportId");//车位id
        String result = "";
        boolean flag = carServiceImpl.carOutNoPay(carNumber, new Integer(carportId));
        if (flag == true) {
            result = "success";
        } else {
            result = "error";
        }
        return result;
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
        System.out.println("carportId：" + carportId);
        boolean flag = carServiceImpl.carOutMoney(new Integer(payMoney), carNumber, new Integer(carportId));
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
     * @Description: 车辆出场支付宝支付
     * @Date: 2020/9/16
     * @Param request:
     * @Param response:
     * @return: java.lang.String
     **/
    @ResponseBody
    @RequestMapping(value = "/carOutAlipay")
    public String carOutAlipay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String subject = request.getParameter("subject");//订单标题
        String total_amount = request.getParameter("total_amount");//订单总金额
        String body = request.getParameter("body");//商品描述信息
        String form = carServiceImpl.carOutAlipay(subject, total_amount, body);
        return form;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 车辆出场支付宝支付结果同步通知
     * @Date: 2020/9/15
     * @Param request:
     * @Param response:
     * @return: void
     **/
    @RequestMapping(value = "/carOutAlipayReturnUrl")
    public ModelAndView carOutAlipayReturnUrl(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException {
        //获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
        ModelAndView modelAndView = new ModelAndView();
        if (signVerified) {
//            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8"); //商户订单号
            WelcomeInfo welcomeInfo = carServiceImpl.noCarWelcome();//查询空闲时的欢迎信息
            modelAndView.addObject("welcomeInfo", welcomeInfo);
            modelAndView.addObject("isCarOut", true);
            modelAndView.setViewName("/jsp/CarIn.jsp");
        } else {
        }
        return modelAndView;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 车辆出场支付宝支付结果异步通知
     * @Date: 2020/9/15
     * @Param request:
     * @Param response:
     * @return: void
     **/
    @RequestMapping(value = "/carOutAlipayNotify")
    public void carOutAlipayNotify(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException {
        //获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
        if (signVerified) {//验证成功
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");//交易金额
            String subject = params.get("subject");//车牌
            if (total_amount != null && !total_amount.equals("")) {
                String str[] = total_amount.split("\\.");
                CarPort carPort = carServiceImpl.findCarPort(subject);
                carServiceImpl.carOutAlipaySuccess(new Integer(str[0]), subject, carPort.getCarportId());//车辆出场支付宝支付成功
            }
            response.getWriter().print("success");
        } else {//验证失败
            response.getWriter().print("fail");
        }
    }


    /**
     * @Author: TheBigBlue
     * @Description: 查询车辆结算信息
     * @Date: 2020/9/15
     * @Param request:
     * @return: com.auc.pojo.WelcomeInfo
     **/
    @ResponseBody
    @RequestMapping(value = "/findCarPayInfo")
    public WelcomeInfo findCarPayInfo(HttpServletRequest request) {
        String carNumber = request.getParameter("carNumber");
        WelcomeInfo welcomeInfo = carServiceImpl.findCarPayInfo(carNumber);
        return welcomeInfo;
    }

    /**
     * @Author: TheBigBlue
     * @Description: 自助缴费--支付宝支付
     * @Date: 2020/9/14
     * @Param request:
     * @Param response:
     * @return: void
     **/
    @ResponseBody
    @RequestMapping(value = "/Alipay")
    public String alipay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String subject = request.getParameter("subject");//订单标题
        String total_amount = request.getParameter("total_amount");//订单总金额
        String body = request.getParameter("body");//商品描述信息
        String form = carServiceImpl.alipay(subject, total_amount, body);
        return form;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 自助缴费支付宝支付结果同步通知
     * @Date: 2020/9/15
     * @Param request:
     * @Param response:
     * @return: void
     **/
    @RequestMapping(value = "/alipayReturnUrl")
    public ModelAndView alipayReturnUrl(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException {
        //获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
        ModelAndView modelAndView = new ModelAndView();
        if (signVerified) {
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8"); //商户订单号
            Alipay alipay = carServiceImpl.findAlipay(out_trade_no);
            WelcomeInfo welcomeInfo = carServiceImpl.findCarPayInfo(alipay.getAlipayCarnumber());//查询车辆结算信息
            modelAndView.addObject("welcomeInfo", welcomeInfo);
            modelAndView.setViewName("/jsp/SelfPaySuccess.jsp");//跳转回自助缴费页面
        } else {
        }
        return modelAndView;
    }


    /**
     * @Author: TheBigBlue
     * @Description: 自助缴费支付宝支付结果异步通知
     * @Date: 2020/9/15
     * @Param request:
     * @Param response:
     * @return: void
     **/
    @RequestMapping(value = "/alipayNotify")
    public void alipayNotify(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException {
        //获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
        if (signVerified) {//验证成功
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");//交易金额
            String subject = params.get("subject");//车牌
            if (total_amount != null && !total_amount.equals("")) {
                String str[] = total_amount.split("\\.");
                carServiceImpl.alipaySuccess(new Integer(str[0]), subject, null);//自助缴费成功
            }
            response.getWriter().print("success");
        } else {//验证失败
            response.getWriter().print("fail");
        }
    }


}