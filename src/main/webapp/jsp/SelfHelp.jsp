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
    <title>Cleo - Agency Landing Page Template</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- font -->
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700;800;900&display=swap" rel="stylesheet">
    <!-- end font -->

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/magnific-popup.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/SelfHelp.css">
</head>
<body>
<input id="path" value="${pageContext.request.contextPath}" type="hidden">
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
            <!--				<div class="col-md-4 col-sm-12">-->
            <!--					<div class="content">-->
            <!--						<div class="serv-icon">-->
            <!--							<i class="icon ion-ios-desktop"></i>-->
            <!--							<span class="clone-icon"><i class="icon ion-ios-desktop"></i></span>-->
            <!--						</div>-->
            <!--						<h5>Web Development</h5>-->
            <!--						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit deserunt</p>-->
            <!--					</div>-->
            <!--				</div>-->
        </div>
        <!--			<div class="row">-->
        <!--				<div class="col-md-4 col-sm-12">-->
        <!--					<div class="content">-->
        <!--						<div class="serv-icon">-->
        <!--							<i class="icon ion-logo-html5"></i>-->
        <!--							<span class="clone-icon"><i class="icon ion-logo-html5"></i></span>-->
        <!--						</div>-->
        <!--						<h5>HTML 5</h5>-->
        <!--						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit deserunt</p>-->
        <!--					</div>-->
        <!--				</div>-->
        <!--				<div class="col-md-4 col-sm-12">-->
        <!--					<div class="content">-->
        <!--						<div class="serv-icon">-->
        <!--							<i class="icon ion-ios-paper"></i>-->
        <!--							<span class="clone-icon"><i class="icon ion-ios-paper"></i></span>-->
        <!--						</div>-->
        <!--						<h5>Branding</h5>-->
        <!--						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit deserunt</p>-->
        <!--					</div>-->
        <!--				</div>-->
        <!--				<div class="col-md-4 col-sm-12">-->
        <!--					<div class="content">-->
        <!--						<div class="serv-icon">-->
        <!--							<i class="icon ion-logo-wordpress"></i>-->
        <!--							<span class="clone-icon"><i class="icon ion-logo-wordpress"></i></span>-->
        <!--						</div>-->
        <!--						<h5>Wordpress</h5>-->
        <!--						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit deserunt</p>-->
        <!--					</div>-->
        <!--				</div>-->
        <!--			</div>-->
    </div>
</div>
<!-- end services -->
<script>
    function openSelfHelf() {
        var path = $("#path").val();
        location.href = path+'/jsp/SelfPay.jsp';
    }

    function openArea() {
        var path = $("#path").val();
        location.href = path+'/jsp/Area.jsp';
    }
</script>

</body>
</html>
