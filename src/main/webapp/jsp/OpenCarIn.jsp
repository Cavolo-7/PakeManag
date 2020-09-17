<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0" media="(device-height: 568px)">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <title>车辆入场信息</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/amazeui.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
    <script src="${pageContext.request.contextPath}/js/CarOut.js"></script>
</head>
<body>
<input type="hidden" id="path" value="${pageContext.request.contextPath}">

<div class="pay">
    <div class="tr_recharge">
        <div class="tr_rechtext" style="text-align: center;height: 35px">
            <p>${param.welcomeMsg}</p>
        </div>
        <form action="" class="am-form" id="doc-vld-msg">
            <div class="tr_rechbox"
                 style="border: 0px;padding-top: 5px;padding-bottom: 0px;padding-left: 20px;padding-right: 20px">
                <div class="tr_rechhead" style="margin-bottom: 20px">
                    <img src="${pageContext.request.contextPath}/imags/ys_head2.jpg"/>
                    <p>车牌号：
                        <a>${param.carNumber}</a>
                    </p>
                    <c:if test="${param.carType}!='白名单用户'">
                        <p style="margin-left: 50px">停车类型：
                            <a>${param.carType}</a>
                        </p>
                    </c:if>
                    <p style="margin-left: 50px">停车位：
                        <a>${param.carPort}</a>
                    </p>
                    <p style="margin-left: 50px">入场时间：
                        <a>${param.startTime}</a>
                    </p>
                </div>
            </div>
            <div class="tr_paybox" style="padding-top: 0px;text-align: center">
                <input type="button" onclick="sure()" class="tr_pay am-btn" value="确定">
            </div>
        </form>
    </div>
</div>

</body>

</html>


