<%--
  Created by IntelliJ IDEA.
  User: 69080
  Date: 2020/9/24
  Time: 0:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
<head>
  <meta charset="UTF-8">
  <title>白名单</title>
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
            <div class="layui-inline">
              <input class="layui-input" name="worker" placeholder="请输入操作人" id="worker" autocomplete="off">
            </div>
            <button class="layui-btn" data-type="reload">搜索</button>
          </div>
        </div>
        <div class="layui-card-body ">
          <table class="layui-hide" id="whiteTable" lay-filter="whiteTable"></table>
        </div>
      </div>
    </div>
  </div>
</div>
</body>

<script>

  layui.use(['form', 'table'], function () {
    var table = layui.table
    var form = layui.form;
    var util = layui.util;
    var laydate = layui.laydate;
    table.render({
      elem: '#whiteTable'
      , id: 'whiteTable'
      , url: '/log/QueryLog'
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
        , {type: 'numbers', width: '5%', title: '序号', align: 'center'}
        , {field: 'logEvent', width: '30%', title: '事件', align: 'center', edit: true}
        , {field: 'logTime', width: '45%', title: '操作时间', align: 'center'}
        , {field: 'logWorker', width: '20%', title: '操作人', align: 'center'}

      ]]
      , id: 'testReload'
    })

    var $ = layui.$, active = {
      reload: function () {
        var worker = $('#worker');
        //执行重载
        table.reload('testReload', {
          page: {
            curr: 1 //重新从第 1 页开始
          }
          , where: {
            key: {
              worker:worker.val(),
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