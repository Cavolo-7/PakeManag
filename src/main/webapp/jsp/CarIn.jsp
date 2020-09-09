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
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Mobeva Template</title>
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/imags/mobeva-fav.jpg" />
    <!-- Bootstrap Css -->
    <link rel="stylesheet" href="http://cdn.bootstrapmb.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <!-- Font Awesome Css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendor/fontawesome/css/all.min.css" />
    <!-- Owl Carousel Css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendor/owl_carousel/css/owl.carousel.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendor/owl_carousel/css/owl.theme.default.css"/>
    <!-- Custom Style Css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css" />
    <script src="${pageContext.request.contextPath}/js/CarIn.js"></script>

</head>
<body>
<input type="hidden" value="${pageContext.request.contextPath}" id="path">
<!-- Body Wrapper -->
<div class="overflow-hidden">
    <!-- Header Section -->
    <header id="ms-header" class="position-relative">
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-lg-3">
                    <a class="navbar-brand ms-logo-pad"><img src="${pageContext.request.contextPath}/imags/Logo.png" class="img-fluid" alt="Logo"/></a>
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
                            <div id="Date" style="font-size: 15px;margin-top: 15px"></div>
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
                            <li>
                                <p class="font-weight-light text-white" style="font-size: 15px;margin-bottom: 10px">
                                    <span class="d-inline-block">停车位：</span>${welcomeInfo.carPort}
                                </p>
                            </li>
                            <li>
                                <p class="font-weight-light text-white" style="font-size: 15px;margin-bottom: 10px">
                                    <span class="d-inline-block">车牌号：</span>${welcomeInfo.carNumber}
                                </p>
                            </li>
                            <li>
                                <p class="font-weight-light text-white" style="font-size: 15px;margin-bottom: 10px">
                                    <span class="d-inline-block">停车类型：</span>${welcomeInfo.carType}
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
                                    <img class="img-fluid pb-3 ms-main-img" src="${pageContext.request.contextPath}/imags/24.png" alt="Service Image"/>
                                    <p class="ms-font-lato font-weight-bold">车辆入场</p>
                                    <div class="ms-service-box-hover position-absolute rounded" id="choseFile" >
                                        <img class="img-fluid pb-3" src="${pageContext.request.contextPath}/imags/25.png" alt="Service Hover Image"/>
                                        <p class="ms-font-lato font-weight-bold">车辆入场</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-6 col-md-6 pl-2 pl-md-3">
                                <div class="ms-service-box rounded text-center position-relative">
                                    <img class="img-fluid pb-3 ms-main-img" src="${pageContext.request.contextPath}/imags/23.png" alt="Service Image"/>
                                    <p class="ms-font-lato font-weight-bold">
                                        SHUTTLE SERVICE
                                    </p>
                                    <div class="ms-service-box-hover position-absolute rounded">
                                        <img class="img-fluid pb-3" src="${pageContext.request.contextPath}/imags/26.png" alt="Service Hover Image"/>
                                        <p class="ms-font-lato font-weight-bold">
                                            SHUTTLE SERVICE
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-6 col-md-6 pr-2 pr-md-3">
                                <div class="ms-service-box rounded text-center position-relative mb-0">
                                    <img class="img-fluid pb-3 ms-main-img" src="${pageContext.request.contextPath}/imags/22.png" alt="Service Image"/>
                                    <p class="ms-font-lato font-weight-bold">车辆出场</p>
                                    <div class="ms-service-box-hover position-absolute rounded">
                                        <img class="img-fluid pb-3" src="${pageContext.request.contextPath}/imags/27.png" alt="Service Hover Image"/>
                                        <p class="ms-font-lato font-weight-bold">车辆出场</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-6 col-md-6 pl-2 pl-md-3">
                                <div class="ms-service-box rounded text-center position-relative mb-0">
                                    <img class="img-fluid pb-3 ms-main-img" src="${pageContext.request.contextPath}/imags/21.png" alt="Service Image"/>
                                    <p class="ms-font-lato font-weight-bold">RESTORATION</p>
                                    <div class="ms-service-box-hover position-absolute rounded">
                                        <img class="img-fluid pb-3" src="${pageContext.request.contextPath}/imags/28.png" alt="Service Hover Image"/>
                                        <p class="ms-font-lato font-weight-bold">RESTORATION</p>
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

<!-- Bootstrap Js -->
<script src="http://cdn.bootstrapmb.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<!-- Font Awesome Js -->
<script src="${pageContext.request.contextPath}/vendor/fontawesome/js/all.min.js"></script>
<!-- Owl Carousel Js -->
<script src="${pageContext.request.contextPath}/vendor/owl_carousel/js/owl.carousel.min.js"></script>
</body>
</html>
