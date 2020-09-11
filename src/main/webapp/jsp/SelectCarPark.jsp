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
        <div class="layui-card-body " style="min-height: 500px;">
          <table class="layui-hide" id="firstTable" lay-filter="allCarParkTable"></table>
        </div>
      </div>
    </div>

    <div class="layui-col-md12 layui-col-md6" style="width: 50%">
      <div class="layui-card">
        <div class="layui-card-header">分区统计 </div>
        <div class="layui-card-body " style="min-height: 500px;min-width: 50px">
          <table class="layui-hide" id="secondTable" lay-filter="subareaStatisticsTable"></table>
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
        , {field: 'allPark', width: 100, title: '总车位数', align: 'center', edit: true}
        , {field: 'employPark', width: 100,title: '已用车位数', align: 'center'}
        ,{field: 'leisurePark',width: 100, title: '空闲从车位数', align: 'center'}
      ]]
      , id: 'testReload'
    })

    table.render({
      elem: '#subareaStatisticsTable'
      , id: 'subareaStatisticsTable'
      , url: '/detail/second'
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
        {type: 'numbers', width: 200, title: '序号', align: 'center'}
        , {field: 'whiteName', width: 300, title: '套餐类型', align: 'center', edit: true}
        , {field: 'whiteAccount', title: '收入', align: 'center'}
      ]]
      , id: 'testReload'
    })
  });
</script>
</body>
</html>
