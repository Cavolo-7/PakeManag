package com.auc.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.auc.mapper.CarInMapper;
import com.auc.pojo.Alipay;
import org.springframework.beans.factory.annotation.Autowired;


import static com.auc.util.AlipayConfig.*;

/**
 * AlipayUtil  支付宝接口工具类
 */
public class AlipayUtil {


    /**
     * @Author: TheBigBlue
     * @Description: 支付宝的下单接口
     * @Date: 2020/9/14
     * @Param out_trade_no:    商户订单号
     * @Param subject:         订单标题
     * @Param total_amount:   订单总金额，单位为元，精确到小数点后两位
     * @Param body:           商品描述信息(可选)
     * @return: java.lang.String
     **/
    public static String getAlipay(String out_trade_no, String subject, String total_amount, String body,String notify_url,String return_url) throws AlipayApiException {
        //封装Rsa签名方式
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl, app_id, merchant_private_key, format, charset, alipay_public_key, sign_type);  //获得初始化的AlipayClient
        //创建Request请求
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest(); //创建API对应的request
        //设置异步回调地址
        alipayRequest.setNotifyUrl(notify_url);
        //设置同步回调地址
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //生成表单
        String form = alipayClient.pageExecute(alipayRequest).getBody();
        System.out.println("form:"+form);
        return form;
    }



}