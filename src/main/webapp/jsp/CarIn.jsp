<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: acsk
  Date: 2020/9/8
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zxx">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>车牌扫描</title>
    <link rel="shortcut icon" type="image/png" href="../imags/mobeva-fav.jpg"/>
    <link rel="stylesheet" href="http://cdn.bootstrapmb.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script src="../layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../js/xadmin.js"></script>
    <link rel="stylesheet" href="../vendor/fontawesome/css/all.min.css"/>
    <link rel="stylesheet" href="../vendor/owl_carousel/css/owl.carousel.min.css"/>
    <link rel="stylesheet" href="../vendor/owl_carousel/css/owl.theme.default.css"/>
    <link rel="stylesheet" href="../css/style.css"/>
    <link rel="stylesheet" href="../css/responsive.css"/>
    <script src="../js/CarIn.js"></script>
    <script>
        if (${isCarOut}){
            alert("支付成功，车辆出场成功！")
        }
        setInterval(function () {
            var date = new Date();
            var year = date.getFullYear(); //获取当前年份
            var mon = date.getMonth() + 1; //获取当前月份
            var da = date.getDate(); //获取当前日
            var day = date.getDay(); //获取当前星期几
            var h = date.getHours(); //获取小时
            var m = date.getMinutes(); //获取分钟
            var s = date.getSeconds(); //获取秒
            var d = document.getElementById('Date');
            d.innerHTML = year + '年' + mon + '月' + da + '日' + '星期' + day + ' ' + h + ':' + m + ':' + s;
        }, 1000);
    </script>
</head>
<body>
<!-- Body Wrapper -->
<div class="overflow-hidden">
    <!-- Header Section -->
    <header id="ms-header" class="position-relative">
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-lg-3">
                    <a class="navbar-brand ms-logo-pad"><img src="../imags/Logo.png" class="img-fluid" alt="Logo"/></a>
                </div>
            </div>
        </div>
    </header>
    <!-- Services Section -->
    <section id="ms-service-section">
        <div class="container">
            <div class="row">
                <div class="col-md-5 ms-left-image-bg">
                    <div class="text-white">
                        <h2 class="ms-font-weight-900">${welcomeInfo.welcomeMsg}</h2>
                        <h4 class="font-weight-normal pb-4">
                            <div id="Date" style="font-size: 15px;margin-top: 15px">
                                2020年9月12日星期5 10:10:10
                            </div>
                        </h4>
                        <ul class="list-group">
                            <li>
                                <p class="font-weight-light text-white" style="font-size: 15px;margin-bottom: 10px">
                                    <span class="d-inline-block">停车总车位：</span>${welcomeInfo.allNum}
                                </p>
                            </li>
                            <li>
                                <p class="font-weight-light text-white" style="font-size: 15px;margin-bottom: 10px">
                                    <span class="d-inline-block">已使用车位：</span>${welcomeInfo.useNum}
                                </p>
                            </li>
                            <li>
                                <p class="font-weight-light text-white" style="font-size: 15px;margin-bottom: 10px">
                                    <span class="d-inline-block">空余车位：</span>${welcomeInfo.noNum}
                                </p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-7">
                    <div class="ms-sec-padding">
                        <div class="row">
                            <div class="col-6 col-md-6 pr-2 pr-md-3">
                                <div class="ms-service-box rounded text-center position-relative">
                                    <img class="img-fluid pb-3 ms-main-img"
                                         src="../imags/24.png" alt="Service Image"/>
                                    <p class="ms-font-lato font-weight-bold">车辆入场</p>
                                    <div class="ms-service-box-hover position-absolute rounded" id="choseFile">
                                        <img class="img-fluid pb-3"
                                             src="../imags/25.png"
                                             alt="Service Hover Image"/>
                                        <p class="ms-font-lato font-weight-bold">车辆入场</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-6 col-md-6 pl-2 pl-md-3">
                                <div class="ms-service-box rounded text-center position-relative">
                                    <img class="img-fluid pb-3 ms-main-img"
                                         src="../imags/23.png" alt="Service Image"/>
                                    <p class="ms-font-lato font-weight-bold">入场手动输入车牌</p>
                                    <div class="ms-service-box-hover position-absolute rounded" onclick="openInput()">
                                        <img class="img-fluid pb-3"
                                             src="../imags/26.png"
                                             alt="Service Hover Image"/>
                                        <p class="ms-font-lato font-weight-bold">入场手动输入车牌</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-6 col-md-6 pr-2 pr-md-3">
                                <div class="ms-service-box rounded text-center position-relative mb-0">
                                    <img class="img-fluid pb-3 ms-main-img"
                                         src="../imags/22.png" alt="Service Image"/>
                                    <p class="ms-font-lato font-weight-bold">车辆出场</p>
                                    <div class="ms-service-box-hover position-absolute rounded" id="choseOutFile">
                                        <img class="img-fluid pb-3"
                                             src="../imags/27.png"
                                             alt="Service Hover Image"/>
                                        <p class="ms-font-lato font-weight-bold">车辆出场</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-6 col-md-6 pl-2 pl-md-3">
                                <div class="ms-service-box rounded text-center position-relative mb-0">
                                    <img class="img-fluid pb-3 ms-main-img"
                                         src="../imags/23.png" alt="Service Image"/>
                                    <p class="ms-font-lato font-weight-bold">出场手动输入车牌</p>
                                    <div class="ms-service-box-hover position-absolute rounded"
                                         onclick="openOutInput()">
                                        <img class="img-fluid pb-3"
                                             src="../imags/26.png"
                                             alt="Service Hover Image"/>
                                        <p class="ms-font-lato font-weight-bold">出场手动输入车牌</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<script src="http://cdn.bootstrapmb.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../vendor/fontawesome/js/all.min.js"></script>
<script src="../vendor/owl_carousel/js/owl.carousel.min.js"></script>
</body>
</html>

