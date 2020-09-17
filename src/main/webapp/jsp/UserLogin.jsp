<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%--
  Created by IntelliJ IDEA.
  User: JC
  Date: 2020/7/8
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link href="${pageContext.request.contextPath}/css/UserLogin.css" rel="stylesheet">
    <style></style>
</head>
<%
    String path = request.getContextPath();
%>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/UserLogin.js" charset="utf-8"></script>
<body>
<input type="hidden" id="path" value="<%=path%>">
<div class="logDiv">
<div>
    <div class="title">用户登录</div>
    <form action="${pageContext.request.contextPath}/LogReg/loginPerson" method="post" id="formLogin">
        <table align="center"  style="border-collapse:separate; border-spacing:0px 10px;">
            <tr>
                <td><label>账号：</label></td>
                <td><input type="text" name="personAccount" id="personAccount" placeholder="请输入账号" style="width: 150px;height: 30px"></td>
            </tr>
            <tr>
                <td><label>密码：</label></td>
                <td><input type="password" name="personPassword" id="personPassword" placeholder="请输入密码" style="width: 150px;height: 30px"></td>
            </tr>
            <tr>
                <td><label>验证码：</label></td>
                <td><input type="text" name="vCode" id="vCode" placeholder="请输入验证码" style="width: 150px;height: 30px"></td>
            </tr>
            <tr>
                <td align="center">
                    <img style="width:100px;height: 40px" id="vCodeImg" src="${pageContext.request.contextPath}/verifyCodeServlet" onclick="changeImg()">
                </td>
                <td align="center">
                    <label  onclick="changeImg()">看不清!</label>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input class="loginBtn" type="button" id="btnLogin" value="登录" onclick="jqAjax()">
                </td>
            </tr>
            <tr>
                <td colspan="2"  align="right"><a href="${pageContext.request.contextPath}/jsp/UserReg.jsp">注册新账号</a></td>
            </tr>
        </table>
    </form>
</div>
</div>
</body>
</html>
