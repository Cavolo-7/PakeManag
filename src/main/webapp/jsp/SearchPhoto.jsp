<%--
  Created by IntelliJ IDEA.
  User: 69080
  Date: 2020/9/16
  Time: 15:46
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
  <title>反向寻车</title>
  <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/CarNumberInput.css" />
  <style>
    .car_input{width:500px; margin:100px auto;}
  </style>

</head>
<body>
<input type="hidden" id="path" value="${pageContext.request.contextPath}">
<div class="car_input">
  <ul class="clearfix ul_input">
    <li id="cp1" class="input_zim" data-sort= "1"><span></span></li>
    <li id="cp2" data-sort="2"><span></span></li>
    <li id="cp3" data-sort="3"><span></span></li>
    <li id="cp4" data-sort="4"><span></span></li>
    <li id="cp5" data-sort="5"><span></span></li>
    <li id="cp6" data-sort="6"><span></span></li>
    <li id="cp7" data-sort="7"><span></span></li>
    <li id="cp8" data-sort="8" style="display:none;"><span></span></li>
    <li class="xinneng"><span><img src="${pageContext.request.contextPath}/imags/xinweng.png" style="margin-top: 8px"></span></li>
    <input type="button" value="确认" onclick="carSearch()" id="submitBtn" style="height: 40px; width: 65px;border: 0px;background-color: #1eb97d;color: white">
  </ul>
</div>
<img src="" id="photo">
<script src="${pageContext.request.contextPath}/js/slide.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
<script>
  layui.use(['layer', 'form'], function () {

    var $ = layui.jquery
        , layer = layui.layer
        , form = layui.form;

    $('.car_input li').on('click', function () {
      document.activeElement.blur();  // 阻止弹出系统软键盘
      var _cliss = $(this).attr("class");
      var _sort = $(this).data("sort");

      $(this).addClass("input_zim").siblings().removeClass("input_zim");

      if (_sort == 1) {
        $('body').keyboard({
          defaults: 'symbol',    //键盘显示类型   English 字母  number 数字  symbol 符号
          inputClass: _cliss,        //输入框Class
        });
      } else {
        $('body').keyboard({
          defaults: 'English',    //键盘显示类型   English 字母  number 数字  symbol 符号
          inputClass: _cliss,        //输入框Class
        });
      }
    });

    $(document).on("click", '#keyboard .keyContent li', function (event) {

      $(".input_zim span").html($(this).text());
      var _sort = $(".input_zim").data("sort") + 1;
      if (_sort == 2) {
        $('body').keyboard({
          defaults: 'English',    //键盘显示类型   English 字母  number 数字  symbol 符号
        });
      }
      $("#cp" + _sort).addClass("input_zim").siblings().removeClass("input_zim");
    });

    $(document).on("click", '.del', function (event) {
      $(".input_zim span").text('');
      var _sort = $(".input_zim").data("sort") - 1;
      $("#cp" + _sort).addClass("input_zim").siblings().removeClass("input_zim");
    });

    $(document).on("click", '.xinneng', function (event) {
      $(".xinneng").remove();
      $("#cp8").show();
    });

  });



  function carSearch() {
    var carNum1 = $("#cp1").text();
    var carNum2 = $("#cp2").text();
    var carNum3 = $("#cp3").text();
    var carNum4 = $("#cp4").text();
    var carNum5 = $("#cp5").text();
    var carNum6 = $("#cp6").text();
    var carNum7 = $("#cp7").text();
    var carNum8 = $("#cp8").text();
    var carNumber = "";
    if (carNum1 != '' && carNum2 != '' && carNum3 != '' && carNum4 != '' && carNum5 != '' && carNum6 != '' && carNum7 != '' && carNum8 == '') {
      carNumber = carNum1 + carNum2 + carNum3 + carNum4 + carNum5 + carNum6 + carNum7;
    }
    if (carNum1 != '' && carNum2 != '' && carNum3 != '' && carNum4 != '' && carNum5 != '' && carNum6 != '' && carNum7 != '' && carNum8 != '') {
      carNumber = carNum1 + carNum2 + carNum3 + carNum4 + carNum5 + carNum6 + carNum7 + carNum8;
    }
    var path = $("#path").val();
    //1.判断非空（7位，或者8位）
    $.ajax({
          url: "/esmap/photo",
          type: "post",
          data: {
            "carNumber": carNumber,
          },
          dataType: "json",
          beforeSend: function () {
            if (carNum1 == '' || carNum2 == '' || carNum3 == '' || carNum4 == '' || carNum5 == '' || carNum6 == '' || carNum7 == '') {
              alert("请输入正确的车牌号！")
              return false;
            }
          },
          success: function (data) {
            console.log(data);
            console.log(data.carportPhoto);
            if (data!=null){
              $("#photo").attr("src",data.carportPhoto)
            }
          },
        }
    );
  }
</script>
</body>
</html>
