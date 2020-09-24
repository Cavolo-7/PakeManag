<%--
  Created by IntelliJ IDEA.
  User: acsk
  Date: 2020/9/13
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zxx">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>自助客户端</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700;800;900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/ionicons.min.css">
    <link rel="stylesheet" href="../layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../css/magnific-popup.css">
    <link rel="stylesheet" href="../css/SelfHelp.css">
    <script src="../layui/layui.js"></script>
    <script src="../js/SelfHelp.js"></script>
</head>
<body>
<!-- services -->
<div id="services" class="services section-bottom-only" style="padding-top: 20px">
    <div class="section-title">
        <h5 class="title-top">Services</h5>
        <h3>Our The Best Services</h3>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-sm-12" onclick="openArea()">
                <div class="content">
                    <div class="serv-icon">
                        <i class="icon ion-ios-bulb"></i>
                        <span class="clone-icon"><i class="icon ion-ios-bulb"></i></span>
                    </div>
                    <h5>反向寻车</h5>
                    <p>Looking for vehicle location</p>
                </div>

            </div>
            <div class="col-md-6 col-sm-12" onclick="openSelfHelf()">
                <div class="content">
                    <div class="serv-icon">
                        <i class="icon ion-ios-phone-portrait"></i>
                        <span class="clone-icon"><i class="icon ion-ios-phone-portrait"></i></span>
                    </div>
                    <h5>自助缴费</h5>
                    <p>Self service payment</p>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12 col-sm-12">
                <div class="layui-carousel" id="test1">
                    <div carousel-item="" id="picture">
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- end services -->
<script>

    function openSelfHelf() {
        location.href = '/jsp/SelfPay.jsp';
    }

    function openArea() {
        location.href = '/jsp/Area.jsp';
    }
</script>

</body>
</html>
