<%--
  Created by IntelliJ IDEA.
  User: 69080
  Date: 2020/8/17
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
<head>
  <meta charset="UTF-8">
  <title>角色管理</title>
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
<input type="hidden" value="${pageContext.request.contextPath}" id="path">
<div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">演示</a>
            <a>
              <cite>导航元素</cite></a>
          </span>
  <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()"
     title="刷新">
    <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
</div>
<div class="layui-fluid">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md12">
      <div class="layui-card">
        <div class="layui-card-body ">
          <div class="demoTable">
            <div class="layui-inline">
              <input class="layui-input" name="roleName" placeholder="请输入管理员名字" id="roleName" autocomplete="off">
            </div>
            <div class="layui-inline">
              <input class="layui-input" name="urisdiction" placeholder="请输入管理权限" id="urisdiction" autocomplete="off">
            </div>
            <button class="layui-btn" data-type="reload" id="sou">搜索</button>
            <br><br><br>
            <button class="layui-btn" onclick="xadmin.open('添加用户','./AddUser.jsp',450,270)"><i
                    class="layui-icon"></i>添加
            </button>
          </div>
        </div>
        <div class="layui-card-body ">
          <table class="layui-hide" id="userTable" lay-filter="userTable"></table>
        </div>
      </div>
    </div>
  </div>
</div>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</body>

<script>
  layui.use(['form', 'table'], function () {
    var table = layui.table
    var form = layui.form;
    var util = layui.util;
    var laydate = layui.laydate;
    table.render({
      elem: '#userTable'
      , id: 'userTable'
      , url: '/userControl/selectRole'
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
        , {type: 'numbers', width: '10%', title: '序号', align: 'center'}
        , {field: 'roleName', width: '20%', title: '管理员名字', align: 'center', edit: true}
        , {field: 'urisdictionName', width: '20%', title: '权限级别', align: 'center', edit: true}
        , {field: 'roleState', width: '20%', title: '状态', align: 'center', edit: true}
        , {field: 'right', width: '32%',title: '操作', toolbar: '#barDemo', align: 'center'}
      ]]
      , id: 'testReload'
    })
    table.on('tool(userTable)', function (obj) {
      var data = obj.data;
      if (obj.event === 'edit') {
        layer.confirm('真的要修改么', function (index) {
          $.ajax({
            url: "/personManage/edit",
            data: {'whiteAccount': data.whiteAccount,'whiteName': data.whiteName,'whiteCarnumber': data.whiteCarnumber,'whitePhone': data.whitePhone},
            method: 'post',
            dataType: 'text',
            success: function (data) {
              if (data == "编辑成功") {
                layer.msg("编辑成功")
              } else {
                layer.msg("编辑失败")
              }
            }
          })
        });

      }
      else if (obj.event === 'del') {
        layer.confirm('真的删除行么', function (index) {
          $.ajax({
            url: "/personManage/del",
            data: {'whiteAccount': data.whiteAccount},
            method: "post",
            dataType: "text",
            success: function (data) {
              if (data == "删除成功") {
                layer.msg("删除成功")
                obj.del();
                layer.close(index);
              } else {
                layer.msg("删除失败")
              }
            }
          })
        });
      }
    });

    // var $ = layui.$, active = {
    //   reload: function () {
    //     //执行重载
    //     table.reload('testReload', {
    //       page: {
    //         curr: 1 //重新从第 1 页开始
    //       }
    //       , where: {
    //         roleName: $("#roleName").val(),
    //         urisdiction: $("#urisdiction").val(),
    //       }
    //     }, 'data');
    //   }
    // };


    //点击查询按钮，重载表格
    $('#sou').on('click', function () {
      table.reload('testReload', {
        url: "/userControl/selectRole",
        where: {
          roleName: $("#roleName").val(),
          urisdiction: $("#urisdiction").val(),
        },
        page: {
          curr: 1
        }
      });
      return false;
    });
    //
    // $('.demoTable .layui-btn').on('click', function () {
    //   var type = $(this).data('type');
    //   active[type] ? active[type].call(this) : '';
    // });

    // var $ = layui.$, active = {
    //   getCheckData: function () { //获取选中数据
    //     var checkStatus = table.checkStatus('testReload')
    //         , data = checkStatus.data;
    //     layer.alert(JSON.stringify(data));
    //   }
    // };

  });
</script>
</html>