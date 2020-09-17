package com.auc.util;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信验证工具类
 */
public class Textmessage {
    private static String accessKeyID = "LTAI4G7TjtzBgyKG8eifnUUU";

    private static String accessKeySecret = "3mYVIvwUuUGfAYlMQEZs34I97NGiHP";

    //短信api的请求地址  固定
    private static String domain  = "dysmsapi.aliyuncs.com";

    //指定地域名称 短信API的就是 cn-hangzhou 不能改变
    private static String regionId = "cn-hangzhou";

    //您的申请签名
    private static String signName = "智能停车场";

    //你的模板
    private static String templateCode = "SMS_202821233";

    public static boolean sender(String phoneNum, String message){
        // 指定地域名称 短信API的就是 cn-hangzhou 不能改变  后边填写您的  accessKey 和 accessKey Secret
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyID, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);

        // 创建通用的请求对象
        CommonRequest request = new CommonRequest();
        // 指定请求方式
        request.setSysMethod(MethodType.POST);
        // 短信api的请求地址  固定
        request.setSysDomain(domain);
        //签名算法版本  固定
        request.setSysVersion("2017-05-25");
        //请求 API 的名称
        request.setSysAction("SendSms");
        //指定地域名称
        request.putQueryParameter("RegionId", regionId);
        // 要给哪个手机号发送短信  指定手机号
        request.putQueryParameter("PhoneNumbers", phoneNum);
        // 您的申请签名
        request.putQueryParameter("SignName", signName);
        // 您申请的模板 code
        request.putQueryParameter("TemplateCode", templateCode);

        Map<String, Object> params = new HashMap<>();
        //这里的key就是短信模板中的 ${xxxx}
        params.put("code", message);

        // 放入参数  需要把 map转换为json格式  使用fastJson进行转换
        request.putQueryParameter("TemplateParam", JSON.toJSONString(params));

        try {
            CommonResponse response = client.getCommonResponse(request);
            return response.getHttpResponse().isSuccess();

        }  catch (ClientException e) {
            e.printStackTrace();
        }

        return false;
    }

}
