<%--
  Created by IntelliJ IDEA.
  User: acsk
  Date: 2020/9/9
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0" media="(device-height: 568px)">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <title>车牌号码输入</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/CarNumberInput.css" />
    <style>
        .car_input{width:500px; margin:100px auto;}
    </style>

</head>
<body>
<input type="hidden" id="path" value="${pageContext.request.contextPath}">
<div class="car_input">

    <ul class="clearfix ul_input">
        <li id="cp1" class="input_zim" data-sort= "1"><span></span></li>
        <li id="cp2" data-sort="2"><span></span></li>
        <li id="cp3" data-sort="3"><span></span></li>
        <li id="cp4" data-sort="4"><span></span></li>
        <li id="cp5" data-sort="5"><span></span></li>
        <li id="cp6" data-sort="6"><span></span></li>
        <li id="cp7" data-sort="7"><span></span></li>
        <li id="cp8" data-sort="8" style="display:none;"><span></span></li>
        <li class="xinneng"><span><img src="${pageContext.request.contextPath}/imags/xinweng.png" style="margin-top: 8px"></span></li>
        <input type="button" value="确认" onclick="carInSubmit()" id="submitBtn" style="height: 40px; width: 65px;border: 0px;background-color: #1eb97d;color: white">
    </ul>

</div>

<script src="${pageContext.request.contextPath}/js/slide.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
<script src="${pageContext.request.contextPath}/js/CarNumberInput.js"></script>
</body>
</html>
