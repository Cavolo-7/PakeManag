<%--
  Created by IntelliJ IDEA.
  User: cjw
  Date: 2020/9/8
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html  class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>停车场管理员登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/html5.min.js"></script>
    <script src="${pageContext.request.contextPath}/respond.min.js"></script>


    <![endif]-->
</head>
<body class="login-bg">
<input type="hidden" value="${pageContext.request.contextPath}" id="path">
<div class="login layui-anim layui-anim-up">
    <div class="message">停车场管理员登录</div>
    <div id="darkbannerwrap"></div>

    <form method="post" class="layui-form" >
        <input name="account" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" id="account">
        <hr class="hr15">
        <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input" id="password">
        <hr class="hr15">
        <input value="登录" onclick="jqAjax()"  style="width:100%;" type="button">
        <br>
        <br>
        <input value="人脸登录" onclick="Ajax(this)"  style="width:100%;" type="button">
        <hr class="hr20" >
    </form>
</div>

<script src="${pageContext.request.contextPath}/js/Login.js"></script>
</body>
</html>