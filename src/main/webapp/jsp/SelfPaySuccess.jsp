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
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>自助缴费</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/SelfPay.css">
    <script>
        alert("支付成功！")
    </script>
</head>
<body>
<input type="hidden" value="${pageContext.request.contextPath}" id="path">
<input type="hidden" id="body">
<input type="hidden" id="subject">
<input type="hidden" id="total_amount">


<div class="search bar1">
    <form method="post">
        <input type="text" placeholder="请输入您的车牌号" id="carNumber">
        <input type="button" id="search" onclick="findCar()" value="搜索 ">
    </form>
</div>


<article class="receipt active" id="info-div" style="display: block">
    <section class="receipt__half upper">
        <p>结算单据</p>
        <h1 id="money">${welcomeInfo.money}元</h1>
        <p class="sm" id="nowTime">${welcomeInfo.endTime}</p>
        <div class="receipt__content">
            <table style="font-size: 12px">
                <tbody>
                <tr>
                    <td>车牌号</td>
                    <td id="number">${welcomeInfo.carNumber}</td>
                </tr>
                <tr>
                    <td>停车位</td>
                    <td id="carPort">${welcomeInfo.carPort}</td>
                </tr>
                <tr>
                    <td>停车类型</td>
                    <td id="carType">${welcomeInfo.carType}</td>
                </tr>
                <tr>
                    <td>入场时间</td>
                    <td id="startTime">${welcomeInfo.startTime}</td>
                </tr>
                <tr>
                    <td>出场时间</td>
                    <td id="endTime">${welcomeInfo.endTime}</td>
                </tr>
                <tr>
                    <td>停车时长</td>
                    <td id="longTime">${welcomeInfo.longTime}分</td>
                </tr>
                <tr>
                    <td>缴费状态</td>
                    <td id="payState">${welcomeInfo.payState}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </section>
    <section class="receipt__half lower">
        <button onclick="back()">返回主页</button>
    </section>
</article>
<script src="${pageContext.request.contextPath}/js/SelfPay.js"></script>
<script>
    //返回主页
    function back() {
        var path = $("#path").val();
        location.href = path + "/jsp/SelfHelp.jsp";
    }
</script>
</body
>
</html>
