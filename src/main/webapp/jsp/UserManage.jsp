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
            <button class="layui-btn" data-type="reload" id="search">搜索</button>
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
  {{#  if(d.stateName=="启用"){ }}
  <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" title="禁用" lay-event="disable" value="禁用" onclick="upd(this)">禁用</a>
  {{#  } else { }}
  <a class="layui-btn layui-btn-sm layui-btn-xs" lay-event="enabled" title="启用" value="启用" onclick="upd(this)">启用</a>
  {{#  } }}
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
         {type: 'numbers', width: '10%', title: '序号', align: 'center'}
        , {field: 'roleId', hide:true}
        , {field: 'roleName', width: '20%', title: '管理员名字', align: 'center', edit: true}
        , {field: 'urisdictionName', width: '20%', title: '权限级别', align: 'center', edit: true}
        , {field: 'stateName', width: '20%', title: '状态', align: 'center', edit: true}
        , {field: 'right',title: '操作', toolbar: '#barDemo', align: 'center'}
      ]]
      , id: 'testReload'
    })
    table.on('tool(userTable)', function (obj) {
      var data = obj.data;
      if (obj.event === 'edit') {
        layer.confirm('真的要修改么', function (index) {
          layer.open({
            // anim: 1,
            type: 2,//Page层类型
            area: ['400px', '250px'],
            title: '修改管理员信息',
            shadeClose: true,
            shade: false,
            id: 'alterp',
            shade: 0.6, //遮罩透明度,
            maxmin: true, //允许全屏最小化,
            anim: 1, //0-6的动画形式，-1不开启,
            content: ['/jsp/UpdateRole.jsp'],
            success: function (layero, index) {
              var body = layer.getChildFrame('body', index);
              body.contents().find("#roleId").val(data.roleId)
              body.contents().find("#roleName").val(data.roleName)
              body.contents().find("#urisdictionName").val(data.urisdictionName)
            },
            end: function () {
              $("#search").click();
            }
          });
        });

      }

    });

    //点击查询按钮，重载表格
    $('#search').on('click', function () {
      table.reload('testReload', {
        url: "/userControl/selectRole",
        where: {
          roleId:$("#roleId").val(),
          roleName: $("#roleName").val(),
          urisdiction: $("#urisdiction").val(),
        },
        page: {
          curr: 1
        }
      });
      return false;
    });

  });

  function upd(obj) {
    layer.confirm('确定要禁用？', function (index){
      console.log()
      $.ajax({
        url: "/userControl/roleState",
        dataType: "text",
        method: "post",
        data: {roleId: $(obj).parent().parent().parent("tr").children("td").eq(1).children("div").text(),
          roleState: $(obj).text()},
        success: function (data) {
          console.log(data)
          if (data == "启用") {
            $("#search").click();
            layer.msg("操作成功！", {icon: 6, time: 1000})
          }else if (data == "禁用"){
            $("#search").click();
            layer.msg("操作成功！", {icon: 6, time: 1000})
          }else {
            layer.msg('操作失败!', {icon: 6, time: 1000});
          }
        }
      })
    });
  }
</script>
</html>