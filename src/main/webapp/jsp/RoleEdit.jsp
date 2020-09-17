<%--
  Created by IntelliJ IDEA.
  User: acsk
  Date: 2020/8/14
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>权限修改</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
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
            <a href="">人员管理</a>
            <a>
              <cite>权限管理</cite></a>
          </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5">
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="paramName" placeholder="请输入权限级别" autocomplete="off" class="layui-input" id="paramName">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn" lay-submit="" lay-filter="" id="searchBtn">搜索</button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-body ">
                    <table class="layui-hide" id="rootTable" lay-filter="rootTable"></table>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
</script>

<script>
    layui.use(['form', 'table'], function () {
        var table = layui.table
        var form = layui.form;
        table.render({
            elem: '#rootTable'
            , id: 'rootTable'
            , url: '/root/selectRole'
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
                , {field: 'paramId', title: 'ID', align: 'center', hide: true}
                , {field: 'paramName', title: '权限级别', align: 'center'}
                , {field: 'paramValue', title: '权限值', align: 'center', hide: true}
                , {field: 'right', title: '操作', toolbar: '#barDemo', align: 'center'}
            ]]
        })


        //点击查询按钮，重载表格
        $('#searchBtn').on('click', function () {
            table.reload('rootTable', {
                url: '/root/selectRole',
                where: {
                    paramName: $('#paramName').val(),
                },
                page: {
                    curr: 1
                }
            });
            return false;
        });


        table.on('tool(rootTable)', function (obj) {
            if (obj.event === 'edit') {
                layer.confirm('确定要修改嘛？', function (index) {
                    layer.close(index);//关闭特定层(confirm)
                    var name = obj.data.paramName;//权限级别
                    var value = obj.data.paramValue;//权限值
                    xadmin.open('修改权限', '/jsp/OpenRoleEdit.jsp?name=' + name + '&value=' + value, 600, 400);//打开权限树弹出层
                });
            }
        });
    });

</script>
</div>
</body>
</html>
