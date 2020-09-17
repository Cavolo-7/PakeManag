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
    <script type="text/javascript" src="../layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../js/xadmin.js"></script>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <script src="../js/OpenRoleEdit.js"></script>
</head>
<body>
<input type="hidden" id="value" value="${param.value}">
<input type="hidden" id="path" value="${pageContext.request.contextPath}">
<div class="layui-fluid">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: -10px;margin-bottom: 10px">
        <legend>${param.name}</legend>
    </fieldset>
    <div class="layui-col-md12 layui-col-md12 layui-col-sm12">
        <div id="roleTree" class="layui-col-xs12 layui-col-sm12 layui-col-md12"></div>
    </div>
</div>

<div style="text-align: center">
    <button class="layui-btn layui-btn-normal" id="update">修改</button>
    <button class="layui-btn layui-btn-normal" id="cancel">取消</button>
</div>
</body>
</html>
