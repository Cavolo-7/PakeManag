package com.auc.service;

/**
  * @Author: TheBigBlue
  * @Description:  认证接口 ---车牌识别
  * @Date: 2020/9/8
  * @Param null:
  * @return: null
  **/
public interface AuthService {

    public  String getAuth();//获取权限token

    public  String getAuth(String ak, String sk);//获取API访问token
}
