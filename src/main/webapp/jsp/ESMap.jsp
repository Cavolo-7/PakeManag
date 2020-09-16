<%--
  Created by IntelliJ IDEA.
  User: 69080
  Date: 2020/9/13
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
  <meta charset="UTF-8" />
  <title>迪士尼</title>
  <meta name="keywords" content="停车场导航,商场导航,停车场定位,室内地图,易景地图,ESMap" />
  <meta name="description" content="停车场车位占用例子定时5秒从后台获取数据,停车场导航,商场导航,停车场定位,易景室内三维地图引擎提供地图浏览、缩放、旋转、图层显隐等基础功能，支持自定义室内地图显示风格及样式，可自动绘制楼层热力图、散点图等专题地图，快速进行空间大数据分析展示。支持跨楼层精准的点到点之间的最短、最优路径计算，支持对路径结果进行导航和动画,并提供丰富的地图主题资源供二次开发调用。" />
  <link href="../esmap/lib/bootstrap.min.css" rel="stylesheet">
  <link href="../esmap/Case/Park/css/common.css" rel="stylesheet">
  <link href="../esmap/Case/Park/css/iconfont/iconfont.css" rel="stylesheet">
</head>
<style type="text/css">
  .viewmode-group {
    position: absolute;
    right: 12px;
    top: 32%;
    border-radius: 6px;
    border: none;
  }

  .viewmode-group button {
    display: inline-block;
    width: 38px;
    height: 38px;
    border-radius: 4px;
    border: none;
    background-image: url("../esmap/Case/Park/image/wedgets/3D.png");
  }

  .parking {
    width: 320px;
    height: 46px;
    line-height: 46px;
    left: 100px;
    bottom: 14px;
    border: 1px solid #083344;
    border-radius: 4px;
    color: rgb(255, 255, 255);
    background-color: rgba(71, 92, 105, 0.8);
    font-size: 16px;
    text-align: center;
  }

  .fix {
    position: fixed;
  }

  .codition {
    width: 120px;
    left: 10px;
    bottom: 120px;
  }

  .codition ul {
    width: 100%;
    padding: 6px;
    list-style-type: none;
  }

  .codition ul li {
    display: list-item;
    height: 36px;
    background-color: rgb(255, 255, 255);
    line-height: 36px;
    text-align: center;
  }

  .codition ul li span {
    display: inline-block;
    width: 18px;
    height: 18px;
    border-radius: 50%;
    margin-right: 10px;
    vertical-align: middle;
  }

  .codition-first {
    background-color: #f00;
  }

  .codition-second {
    background-color: #0f0;
  }

  .codition-third {
    background-color: rgb(126, 172, 202);
  }

  .i-test-tip {
    width: 360px;
    height: 46px;
    left: 470px;
    bottom: 14px;
    border-radius: 4px;
    overflow: hidden;
    /* position: relative; */
    background-color: rgba(71, 92, 105, 0.8);
    text-align: center;
  }

  .test-tip {
    position: absolute;
    top: 0;
    left: 100%;
    color: #fff;
    font-size: 24px;
    line-height: 46px;
    white-space: nowrap;
    word-break: keep-all;
    text-overflow: ellipsis;
  }

  .test-tip span {
    color: #0f0;
  }
</style>

<body ms-controller="ctrl" class="ms-controller">
<div id="map-container"></div>
<div class="loading">
  <div class="lodingImg"></div>
</div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <h1>
      <a href="/" title="室内地图-地图轨迹回放" target="_blank">迪士尼停车场</a>（一个无敌的停车场）
    </h1>

    <div class="tips-right">
      <span class="tip1"></span> <span class="tip2"></span>
    </div>
    <div class="tips-msg">
      <div class="msg msg1">
        <div class="erweima"></div>
        <p>手机扫一扫进入体验</p>
      </div>
      <div class="msg msg2">
        <h4>迪斯尼</h4>
        <p>这是一个无敌的停车场</p>
        <div style="display: none"></div>
      </div>
    </div>
  </div>
</nav>

<div class="parking fix" id="parking"><span id="carid"></span>车位情况：<span id="YorN"></span></div>
<div class="codition fix">
  <ul>
    <li><span class="codition-first"></span>占用车位</li>
    <li><span class="codition-second"></span>空闲车位</li>
    <li><span class="codition-third"></span>固定车位</li>
  </ul>
</div>
<div class="i-test-tip fix" id="i-test-tip">
  <div class="test-tip">
    停车场车位总数：<span id="total"></span>个，当前剩余车位数 <span id="freedata"></span>。
  </div>
</div>
<div class="viewmode-floor btn-floor-vertical" data-toggle="buttons">
  <button id="btn2D" class="btn btn-default">2D</button>
  <button id="btn3D" class="btn btn-default">3D</button>
</div>

<script src="../esmap/lib/config.js"></script>
<script src="../esmap/lib/esmap-1.6.min.js"></script>
<script src="../esmap/lib/jquery-2.1.4.min.js"></script>
<script src="../esmap/lib/jquery.qrcode.min.js"></script>
<script src="../esmap/lib/tips_controls.js"></script>
<script src="../esmap/lib/bootstrap.min.js"></script>

<script type="text/javascript">
  //定义全局map变量
  var map;
  var esmapID = 10005;
  var styleid = getQueryString("styleid") || defaultOpt.themeID;
  var floorControl;
  // 楼层控制控件配置参数（几楼）
  var ctlOpt = new esmap.ESControlOptions({
    position: esmap.ESControlPositon.RIGHT_TOP,
    imgURL: "../esmap/Case/Park/image/wedgets/"
  });
  // 放大、缩小控件配置
  var ctlOpt1 = new esmap.ESControlOptions({
    position: esmap.ESControlPositon.LEFT_TOP, // 位置 左上角
    // 位置x,y的偏移量
    offset: {
      x: 20,
      y: 60
    },
    imgURL: "../esmap/Case/Park/image/wedgets/"
  });
  map = new esmap.ESMap({
    container: $("#map-container")[0], // 渲染dom
    mapDataSrc: "../esmap/data", //地图数据位置
    mapThemeSrc: "../esmap/data/theme", //主题数据位置
    focusAlphaMode: true, // 对不可见图层启用透明设置 默认为true
    focusAnimateMode: true, // 开启聚焦层切换的动画显示
    focusAlpha: 0.4, // 对不聚焦图层启用透明设置，当focusAlphaMode = true时有效
    focusFloor: 1,
    mapAudioSrc: '../esmap/lib',
    token:'escope',
    // visibleFloors: "all",
    themeID: styleid //自定义样式主题ID
  });
  map.openMapById(esmapID); //打开地图
  map.showCompass = true; //显示指南针

  var parkData = null,
      pos = 0;
  var color = ["#7eacca", "#ff0000", "#00ff00"];
  var statusname=["固定车位","有车","无车"];
  //地图加载完成回调
  map.on("loadComplete", function () {
    floorControl = new esmap.ESScrollFloorsControl(map, ctlOpt);
    var zoomControl = new esmap.ESZoomControl(map, ctlOpt1);
    bingEvents();
    marquee();
    //先执行显示一次；
    setTimeout(function () {CallLoadData()},10);
    //开启定时器从后台获取数据
    setInterval(function () {
      CallLoadData();
    }, 5000);
  });

  function CallLoadData() {
    $.ajax({
      url: "../esmap/map",
      method: 'post',
      dataType: 'json',
      success: function (data) {
        if (data != null) {
          var mydata=new Map();
          parkData = data.put;
          //1.解析数据,将数据按每层进行整理
          var total =  0;
          for (var i = 0, len = parkData.length; i < len; ++i) {
            var m = parkData[i];
            var d=mydata.get(m.fnum);
            if(d==null)
            {
              d = {"idlist":[[],[],[]]}; //存放三种状态
            }
            total++;
            d.idlist[m.status].push(m.iD); //根据不同的状态存放不同的id
            mydata.set(m.fnum,d);
          }

          var showtext="";
          //2.更新车位颜色
          for (var i = 0; i < mydata.size; i++) {
            var d1 = mydata.get(i+1);
            var fnum = i+1;
              // var fnum = d1[0];
              // var d = d1[1];
            for(var j=0;j<color.length;j++)
              {
                //调用批量修改颜色接口来修改
                map.changeModelColor({
                  id:d1.idlist[j],
                  fnum: fnum,
                  color: color[j]
                });
              }
              showtext += map.floorNames[fnum-1]+":"+d1.idlist[2].length+"个  ";
            }

            //3.显示更新统计
            $("#freedata").html(showtext); //滚动字幕 相应楼层剩余停车位数
            $("#total").html(total);

        } else {
        }
      }
    })
    // var id = [];
    // var fileName = '../esmap/Case/Park/data' + pos + '.json'; //json数据切换
  }

  //地图点击事件
  map.on("mapClickNode", function (event) {
    console.log(event)
    if (event.nodeType == esmap.ESNodeType.NONE ||
        event.nodeType == esmap.ESNodeType.FLOOR ||
        event.name == "楼梯")
      return;
    $("#parking").css("fontSize", "18px").html();
    $("#carid").css("color", "rgb(255, 255, 0)").html(event.name); //停车位ID
    for (var i = 0; i < parkData.length; ++i) {
      if (event.ID == parkData[i].iD) {
        $("#YorN").html(statusname[parkData[i].status]);
      }
    }
  });

  //滚动字幕
  function marquee() {
    var scrollWidth = $('#i-test-tip').width();
    var textWidth = $('.test-tip').width();
    var i = scrollWidth;
    setInterval(function () {
      i--;
      if (i < -textWidth) {
        i = scrollWidth;
      }
      $('.test-tip').animate({
        'left': i + 'px'
      }, 8);
    }, 8);
  }

  //绑定事件
  function bingEvents() {
    // 2维显示事件
    document.getElementById('btn2D').onclick = function () {
      map.viewMode = esmap.ESViewMode.MODE_2D; // 2维模式
    };

    // // 3维显示事件
    document.getElementById('btn3D').onclick = function () {
      map.viewMode = esmap.ESViewMode.MODE_3D;; // 3维模式
    };
  }
</script>
</body>

</html>
