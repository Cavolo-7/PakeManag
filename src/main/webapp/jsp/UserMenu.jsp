
<%--
  Created by IntelliJ IDEA.
  User: JC
  Date: 2020/8/12
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>后台菜单</title>
    <link href="${pageContext.request.contextPath}/css/Menu.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/Menu.js" charset="utf-8"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript" charset="utf-8"></script>
    <%
        String path=request.getContextPath();
    %>
</head>
<body class="layui-layout-body">
<input type="hidden" id="path" value="<%=path%>">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">共享文档管理系统</div>
        <ul class="layui-nav layui-layout-right">

        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <c:if test="${not empty MenuMap}">
                <ul class="layui-nav layui-nav-tree" lay-filter="test">
                    <c:forEach items="${MenuMap}" var="MenuMap">
                        <li class="layui-nav-item layui-nav-itemed">
                            <a class="" href="javascript:;">${MenuMap.key}</a>
                            <dl class="layui-nav-child">
                                <c:forEach items="${MenuMap.value}" var="list">
                                    <dd><a onclick="toggles(this)" title="${list.menuUrl};">${list.menuName}</a></dd>
                                </c:forEach>
                            </dl>
                        </li>
                    </c:forEach>
                </ul>
            </c:if>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe src=" " id="iframe"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
    </div>
</div>
<script src="../src/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>
