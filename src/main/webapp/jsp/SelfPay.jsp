<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: acsk
  Date: 2020/9/13
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>自助缴费</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/SelfPay.css">

</head>
<body>
<input type="hidden" value="${pageContext.request.contextPath}" id="path">
<input type="hidden" id="body">
<input type="hidden" id="subject">
<input type="hidden" id="total_amount">
<input type="hidden" id="State">


<div class="search bar1">
    <form method="post">
        <input type="text" placeholder="请输入您的车牌号" id="carNumber">
        <input type="button" id="search" onclick="findCar()" value="搜索 ">
    </form>
</div>


<article class="receipt active"  id="info-div">
    <section class="receipt__half upper">
        <p>结算单据</p>
        <h1 id="money"></h1>
        <p class="sm" id="nowTime"></p>
        <div class="receipt__content">
            <table style="font-size: 12px">
                <tbody>
                <tr>
                    <td>车牌号</td>
                    <td id="number"></td>
                </tr>
                <tr>
                    <td>停车位</td>
                    <td id="carPort"></td>
                </tr>
                <tr>
                    <td>停车类型</td>
                    <td id="carType"></td>
                </tr>
                <tr>
                    <td>入场时间</td>
                    <td id="startTime"></td>
                </tr>
                <tr>
                    <td>出场时间</td>
                    <td id="endTime"></td>
                </tr>
                <tr>
                    <td>停车时长</td>
                    <td id="longTime"></td>
                </tr>
                <tr>
                    <td>缴费状态</td>
                    <td id="payState"></td>
                </tr>
                </tbody>
            </table>
        </div>
    </section>
    <section class="receipt__half lower">
        <button onclick="Alipay()">支付宝支付</button>
    </section>
</article>
<script src="${pageContext.request.contextPath}/js/SelfPay.js"></script>
</body
></html>
