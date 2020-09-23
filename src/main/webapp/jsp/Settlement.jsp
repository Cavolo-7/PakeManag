<%--
  Created by IntelliJ IDEA.
  User: 69080
  Date: 2020/9/16
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="x-admin-sm">
<head>
  <meta charset="UTF-8">
  <title>收费日结</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport"
        content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
  <link rel="stylesheet" href="../css/font.css">
  <link rel="stylesheet" href="../css/xadmin.css">
  <script src="../layui/layui.js" charset="utf-8"></script>
  <script type="text/javascript" src="../js/xadmin.js"></script>
</head>
<body>

<div class="layui-fluid">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md12">
      <div class="layui-card">
        <div class="layui-card-body ">
          <div class="demoTable">
            <button class="layui-btn" data-type="reloadMorning" id="morning" value="morning">早班报表</button>
            <button class="layui-btn" data-type="reloadNoon" id="noon" value="noon">午班报表</button>
            <button class="layui-btn" data-type="reloadEvening" id="evening" value="evening">晚班报表</button>
           <div class="demoTable">
           <div class="layui-card-body ">
              <table class="layui-hide" id="demo" lay-filter="demo"></table>
           </div>
         </div>
       </div>
      </div>
     </div>
    </div>
  </div>
</div>
<script type="text/html" id="barDemo">
</script>
</body>

<script>
  layui.use(['form', 'table'], function () {
    var table = layui.table
    var form = layui.form;
    var util = layui.util;
    var laydate = layui.laydate;

    table.render({
      elem: '#demo'
      , id: 'demo'
      , url: '/settle/getSettle'
      ,totalRow: true
      ,defaultToolbar:['print']
      , cellMinWidth: 80
      // 限制每页的条数
      , limit: 10
      , limits: [10]
      //数据没有时显示
      , text: {
        none: '暂无相关数据'
      }
      // 开启分页
      // , page: true
      , toolbar: '#demo'
      , cols: [[
        ,{type: 'numbers', width: '5%', title: '序号', align: 'center'}
        , {field: 'detailId', title: 'ID', width: '5%',align: 'center',hide: true}
        , {field: 'detailCarnumber', title: '车牌号', width: '10%',align: 'center'}
        , {field: 'detailEvent', title: '业务', width: '10%',align: 'center'}
        , {field: 'produceId', title: '产品ID', width: '5%',align: 'center',hide: true}
        , {field: 'detailTime', title: '记录时间', width: '15%',align: 'center'}
        , {field: 'detailMoney', title: '金额', width: '10%',align: 'center'}
        , {field: 'workerName', title: '工作人员', width: '10%',align: 'center'}
        , {field: 'detailType', title: '支付方式', align: 'center'}
      ],
      ]
      , id: 'testReload'
    })

    var $ = layui.$, active = {
      reloadMorning: function () {
        var morning = $('#morning');
        //执行重载
        table.reload('testReload', {
          page: {
            curr: 1 //重新从第 1 页开始
          }
          , where: {
            key: {
              judgeTime: morning.val(),
            }
          }
        }, 'data');
      },

      reloadNoon: function () {
        var noon = $('#noon');
        //执行重载
        table.reload('testReload', {
          page: {
            curr: 1 //重新从第 1 页开始
          }
          , where: {
            key: {
              judgeTime: noon.val(),
            }
          }
        }, 'data');
      },

      reloadEvening: function () {
        var evening = $('#evening');
        //执行重载
        table.reload('testReload', {
          page: {
            curr: 1 //重新从第 1 页开始
          }
          , where: {
            key: {
              judgeTime: evening.val(),
            }
          }
        }, 'data');
      }
    };

    $('.demoTable .layui-btn').on('click', function () {
      var type = $(this).data('type');
      active[type] ? active[type].call(this) : '';
    });
  });

</script>
</html>

