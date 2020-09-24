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
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0"
          media="(device-height: 568px)">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <title>出场缴费</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="../layui/layui.js"></script>
    <script type="text/javascript" src="../js/xadmin.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/amazeui.min.css"/>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
    <script src="../js/CarOut.js"></script>
</head>
<body>
<%--车牌号--%>
<input type="hidden" id="carNumber" value="${param.carNumber}">
<%--应付金额--%>
<input type="hidden" id="money" value="${param.money}">
<%--停车位id--%>
<input type="hidden" id="carportId" value="${param.carportId}">


<div class="pay">
    <div class="tr_recharge">
        <div class="tr_rechtext" style="text-align: center;height: 35px">
            <p>${param.welcomeMsg}</p>
        </div>
        <form action="" class="am-form" id="doc-vld-msg">
            <div class="tr_rechbox"
                 style="border: 0px;padding-top: 5px;padding-bottom: 0px;padding-left: 20px;padding-right: 20px">
                <div class="tr_rechhead" style="margin-bottom: 20px">
                    <img src="../imags/ys_head2.jpg"/>
                    <p>车牌号：
                        <a>${param.carNumber}</a>
                    </p>
                    <c:if test="${param.carType}!='白名单用户'">
                        <p style="margin-left: 50px">停车类型：
                            <a>${param.carType}</a>
                        </p>
                    </c:if>
                    <c:if test="${not empty param.payState}">
                        <p style="margin-left: 50px">缴费状态：
                            <a style="color: red">${param.payState}</a>
                        </p>
                    </c:if>
                    <p style="margin-left: 50px">停车位：
                        <a>${param.carPort}</a>
                    </p>
                    <c:if test="${not empty param.longTime}">
                        <p style="margin-left: 50px">停车时长：
                            <a>${param.longTime}分钟</a>
                        </p>
                    </c:if>

                    <p style="margin-left: 50px">入场时间：
                        <a>${param.startTime}</a>
                    </p>
                    <c:if test="${not empty param.endTime}">
                        <p style="margin-left:50px">出场时间：
                            <a>${param.endTime}</a>
                        </p>
                    </c:if>

                </div>
                <c:if test="${param.money!='null'}">
                    <c:if test="${param.money!=0}">
                        <div class="tr_rechcho am-form-group" style="margin-bottom: 0px">
                            <input type="text" id="payMoney" style="display: inline-block;width: 150px">
                        </div>
                    </c:if>
                    <div class="tr_rechnum" style="border: 0px;margin-top: 10px">
                        <span>停车费用：</span>
                        <p class="rechnum">${param.money}元</p>
                    </div>
                </c:if>
            </div>

            <div class="tr_paybox" style="padding-top: 0px;text-align: center">
                <c:choose>
<%--                    无需缴费：白名单用户，月缴用户，自助缴费未超时--%>
                    <c:when test="${param.money=='null'}">
                        <input type="button" onclick="sure()" class="tr_pay am-btn" value="确定">
                    </c:when>

<%--                    无需缴费：临时车辆不满半小时,金额为 0 --%>
                    <c:when test="${param.money==0}">
                        <input type="button" onclick="zeroMoney()" class="tr_pay am-btn" value="确定">
                    </c:when>

<%--                    需要缴费：临时车辆，自助缴费超时,金额不为 0--%>
                    <c:otherwise>
                        <input type="button" onclick="pay()" class="tr_pay am-btn" value="现金支付">
                        <input type="button" onclick="Alipy()" class="tr_pay am-btn" value="支付宝支付">
                    </c:otherwise>
                </c:choose>
            </div>

        </form>
    </div>
</div>

</body>

</html>


