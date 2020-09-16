<%--
  Created by IntelliJ IDEA.
  User: 69080
  Date: 2020/9/10
  Time: 0:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
  <meta charset="UTF-8">
  <title>停车场实时状态查看</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
  <link rel="stylesheet" href="../css/font.css">
  <link rel="stylesheet" href="../css/xadmin.css">
  <script src="../layui/layui.js" charset="utf-8"></script>
  <script type="text/javascript" src="../js/xadmin.js"></script>
<%--  <!--[if lt IE 9]>--%>
<%--  <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>--%>
<%--  <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>--%>
<%--  <![endif]-->--%>
</head>
<body>
<div class="layui-fluid">
  <div class="layui-row layui-col-space15">

    <div class="layui-col-md12 layui-col-md6" style="width: 50%">
      <div class="layui-card">
        <div class="layui-card-header">总车位数 </div>
        <div class="layui-card-body " style="min-height: 280px;min-width: 50px">
          <table class="layui-hide" id="allCarParkTable" lay-filter="allCarParkTable"></table>
        </div>
      </div>
    </div>

    <div class="layui-col-md12 layui-col-md6" style="width: 50%">
      <div class="layui-card">
        <div class="layui-card-header">分区统计 </div>
        <div class="layui-card-body " style="min-height: 280px;min-width: 50px">
          <table class="layui-hide" id="subareaStatisticsTable" lay-filter="subareaStatisticsTable"></table>
        </div>
      </div>
    </div>

    <div class="layui-col-md12">
      <div class="layui-card">
        <div class="layui-card-body ">
          <blockquote class="layui-elem-quote">
          </blockquote>
          <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
          <div id="main" style="width: 100%;height:400px;"></div>
          <blockquote class="layui-elem-quote">
          </blockquote>
        </div>
      </div>
    </div>

  </div>
</div>
</div>

<script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>
<script type="text/javascript">
  layui.use(['form', 'table'], function () {
    var table = layui.table
    var form = layui.form;
    var util = layui.util;
    var laydate = layui.laydate;
    table.render({
      elem: '#allCarParkTable'
      , id: 'allCarParkTable'
      , url: '/carPark/selectAllPark'
      , cellMinWidth: 80
      // 限制每页的条数
      , limit: 10
      , limits: [10]
      //数据没有时显示
      , text: {
        none: '暂无相关数据'
      }
      // 开启分页
      , page: false
      , cols: [[
        //序号
        {type: 'numbers', width: 200, title: '序号', align: 'center'}
        , {field: 'allPark', width: 100, title: '总车位数', align: 'center'}
        , {field: 'employPark', width: 100,title: '已用车位数', align: 'center'}
        ,{field: 'leisurePark', title: '空闲车位数', align: 'center'}
      ]]
      , id: 'testReload'
    })

    table.render({
      elem: '#subareaStatisticsTable'
      , id: 'subareaStatisticsTable'
      , url: '/carPark/selectSubareaPark'
      , cellMinWidth: 80
      // 限制每页的条数
      , limit: 10
      , limits: [10]
      //数据没有时显示
      , text: {
        none: '暂无相关数据'
      }
      // 开启分页
      , page: true
      , cols: [[
        //序号
        {type: 'numbers', width: 80, title: '序号', align: 'center'}
        , {field: 'carportArea', width: 80, title: '分区编号', align: 'center'}
        , {field: 'allSubarea', width: 120, title: '分区总车位数', align: 'center'}
        , {field: 'subarEaemploy',width: 120, title: '分区已用车位数', align: 'center'}
        , {field: 'subarLeisure', title: '分区空闲车位数', align: 'center'}
      ]]
      , id: 'testReload'
    })
  });

  // 基于准备好的dom，初始化echarts实例
  var myChart = echarts.init(document.getElementById('main'));

  // 指定图表的配置项和数据
  var option = {
    title: {
      text: '折线图堆叠'
    },
    tooltip: {
      trigger: 'axis'
    },
    legend: {
      data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
    },
    grid: {
      left: '3%',
      right: '4%',
      bottom: '3%',
      containLabel: true
    },
    toolbox: {
      feature: {
        saveAsImage: {}
      }
    },
    xAxis: {
      type: 'category',
      boundaryGap: false,
      data: ['周一','周二','周三','周四','周五','周六','周日']
    },
    yAxis: {
      type: 'value'
    },
    series: [
      {
        name:'邮件营销',
        type:'line',
        stack: '总量',
        data:[120, 132, 101, 134, 90, 230, 210]
      },
      {
        name:'联盟广告',
        type:'line',
        stack: '总量',
        data:[220, 182, 191, 234, 290, 330, 310]
      },
      {
        name:'视频广告',
        type:'line',
        stack: '总量',
        data:[150, 232, 201, 154, 190, 330, 410]
      },
      {
        name:'直接访问',
        type:'line',
        stack: '总量',
        data:[320, 332, 301, 334, 390, 330, 320]
      },
      {
        name:'搜索引擎',
        type:'line',
        stack: '总量',
        data:[820, 932, 901, 934, 1290, 1330, 1320]
      }
    ]
  };


  // 使用刚指定的配置项和数据显示图表。
  myChart.setOption(option);
</script>
</body>
</html>
