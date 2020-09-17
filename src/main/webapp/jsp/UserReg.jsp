<%--
  Created by IntelliJ IDEA.
  User: JC
  Date: 2020/8/11
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js" charset="utf-8"></script>
<%--    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>--%>
<%--    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>--%>
    <script src="${pageContext.request.contextPath}/js/UserReg.js" charset="utf-8"></script>
    <link href="${pageContext.request.contextPath}/css/UserReg.css" rel="stylesheet">
    <%
        String path = request.getContextPath();
    %>
</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
<div class="logDiv">
    <div class="title">注册</div>
    <form action="${pageContext.request.contextPath}/LogReg/regPerson" method="post">
        <table align="center">
            <tr>
                <td><label>用户名：</label></td>
                <td><input type="text" placeholder="请输入用户名" name="personName" id="personName"></td>
            </tr>
            <tr>
                <td><label>账号：</label></td>
                <td><input type="text" placeholder="请输入账号" name="personAccount" id="personAccount"></td>
            </tr>
            <tr>
                <td><label>密码：</label></td>
                <td><input type="password" placeholder="请输入密码" id="password" name="password"></td>
            </tr>
            <tr>
                <td><label>确认密码：</label></td>
                <td><input type="password" placeholder="请确认密码" id="passwords" name="passwords"></td>
            </tr>
            <tr>
                <td><label>车牌号：</label></td>
                <td><input type="text" placeholder="请输入车牌号" id="carNumber" name="carNumber"></td>
            </tr>
            <tr>
                <td><label>性别：</label></td>
                <td><input name="sex" type="radio" value="男">男 &nbsp; &nbsp; <input name="sex" type="radio" value="女">女</td>
            </tr>
            <tr>
                <td><label>年龄:</label></td>
                <td><input type="text"  placeholder="请输入年龄" id="personAge" name="personAge" required="" lay-verify="personAge"></td>
            </tr>
            <tr>
                <td><label>手机号：</label></td>
                <td><input type="text" placeholder="请输入手机号码" id="personPhone" name="personPhone"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="button" value="注册" onclick="reg(this)"> <input type="button" value="返回" onclick="back(this)"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
