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
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"
            charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="${pageContext.request.contextPath}/js/RoleEdit.js"></script>
</head>
<body>
<input type="hidden" id="path" value="${pageContext.request.contextPath}">
<input type="hidden" id="roleValue" value="${param.roleValue}">
<div class="layui-fluid">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: -10px;margin-bottom: 10px">
        <legend>${param.roleName}</legend>
    </fieldset>
    <div class="layui-col-md12 layui-col-md12 layui-col-sm12">
        <div id="roleTree" class="layui-col-xs12 layui-col-sm12 layui-col-md12"></div>
    </div>
    <script>
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
    </script>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
    </script>
</div>

</body>
</html>
