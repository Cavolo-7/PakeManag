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
    <title>出场缴费</title>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/amazeui.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" />
</head>

<body>
<div class="pay">
    <div class="tr_recharge">
        <form action="" class="am-form" id="doc-vld-msg">
            <div class="tr_rechbox">
                <div class="tr_rechhead">
                    <img src="${pageContext.request.contextPath}/imags/ys_head2.jpg" />
                    <p>车牌号：
                        <a>${param.carNumber}</a>
                    </p>
                    <p style="margin-left: 50px">停车时长：
                        <a>${param.minute}分钟</a>
                    </p>
                </div>
                <div class="tr_rechcho am-form-group">
                    <input type="number" min="0" max="100000" value="12.00元" class="othbox" />
                    <span style="margin-left: -15px">现金缴费</span>
                    <label class="am-radio" style="margin-right:30px;">
                        <input type="checkbox" name="radio1" style="margin-right: 12px"><img src="${pageContext.request.contextPath}/imags/zfbpay.png"/>
                    </label>
                </div>
                <div class="tr_rechnum">
                    <span>停车费用：</span>
                    <p class="rechnum">${param.money}元</p>
                </div>
            </div>
            <div class="tr_paybox">
                <input type="submit" value="确认支付" class="tr_pay am-btn" />
            </div>
        </form>
    </div>
</div>

<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
</body>

</html>


