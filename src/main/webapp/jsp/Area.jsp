<%--
  Created by IntelliJ IDEA.
  User: 69080
  Date: 2020/9/15
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zxx">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>选择查找区域</title>
  <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <link rel="icon" href="">

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
      <div class="col-md-6 col-sm-12" onclick="openA()">
        <div class="content">
          <div class="serv-icon">
            <i class="icon ion-ios-bulb"></i>
            <span class="clone-icon"><i class="icon ion-ios-bulb"></i></span>
          </div>
          <h5>A区域</h5>
          <p>Looking for vehicle location</p>
        </div>
      </div>

      <div class="col-md-6 col-sm-12" onclick="openB()">
        <div class="content">
          <div class="serv-icon">
            <i class="icon ion-ios-bulb"></i>
            <span class="clone-icon"><i class="icon ion-ios-phone-portrait"></i></span>
          </div>
          <h5>B区域</h5>
          <p>Self service payment</p>
        </div>
      </div>

      <div class="col-md-6 col-sm-12"  onclick="openC()">
        <div class="content">
          <div class="serv-icon">
            <i class="icon ion-ios-bulb"></i>
            <span class="clone-icon"><i class="icon ion-ios-bulb"></i></span>
          </div>
          <h5>C区域</h5>
          <p>Looking for vehicle location</p>
        </div>
      </div>

      <div class="col-md-6 col-sm-12"  onclick="openD()">
        <div class="content">
          <div class="serv-icon">
            <i class="icon ion-ios-bulb"></i>
            <span class="clone-icon"><i class="icon ion-ios-bulb"></i></span>
          </div>
          <h5>D区域</h5>
          <p>Looking for vehicle location</p>
        </div>
      </div>

    </div>
  </div>
</div>
<!-- end services -->
<script src="../layui/layui.all.js"></script>
<script>
  // layui.use(['layer'], function () {
  //   layer = layui.layer;

  function openA() {
    location.href = '/jsp/CarNumberSearchA.jsp';
  }

  function openB() {
    var path = $("#path").val();
    location.href = path+'/jsp/CarNumberSearchB.jsp';
  }

  function openC() {
    var path = $("#path").val();
    location.href = path+'/jsp/CarNumberSearchC.jsp';
  }

  function openD() {
    var path = $("#path").val();
    location.href = path+'/jsp/CarNumberSearchD.jsp';
  }
  // });
</script>

</body>
</html>

