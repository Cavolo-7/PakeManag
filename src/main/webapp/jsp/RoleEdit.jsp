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
    <link rel="stylesheet" href="../css/font.css">
    <link rel="stylesheet" href="../css/xadmin.css">
    <script src="../layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../js/xadmin.js"></script>
<%--    <script src="${pageContext.request.contextPath}/js/RoleEdit.js"></script>--%>

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
                        <button class="layui-btn" data-type="reload" id="search">搜索</button>
                        <br><br><br>
<%--                        <button class="layui-btn" onclick="xadmin.open('添加用户','./AddUser.jsp',450,270)"><i--%>
<%--                                class="layui-icon"></i>添加--%>
<%--                        </button>--%>
                    </div>
                </div>
                <div class="layui-card-body ">
                    <table class="layui-hide" id="rootTable" lay-filter="rootTable"></table>

                    <div id="roleTree"></div>

                </div>
            </div>
        </div>
    </div>
</div>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
    </script>

    <script>
        layui.use(['form', 'table','layer','tree','util'], function () {
            var table = layui.table
            var form = layui.form;
            var util = layui.util;
            var laydate = layui.laydate;
            $ = layui.jquery;
            layer = layui.layer;
            var tree = layui.tree;
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
                    , {field: 'roleId', hide:true}
                    , {field: 'roleName', width: '20%', title: '管理员名字', align: 'center', edit: true}
                    , {field: 'urisdictionName', width: '20%', title: '权限级别', align: 'center', edit: true}
                    , {field: 'stateName', width: '20%', title: '状态', align: 'center', edit: true}
                    , {field: 'right',title: '操作', toolbar: '#barDemo', align: 'center'}
                ]]
                , id: 'testReload'
            })
            table.on('tool(rootTable)', function (obj) {
                var data = obj.data;
                //获得选中的节点
                // var checkData = tree.getChecked('roleTree');
                // var checkData = JSON.stringify(checkData[0]);
                // console.log(checkData)
                // $.ajax({
                //         url: path + "/root/updateMenu",
                //         type: "post",
                //         data: {
                //             "checkData": checkData,
                //             "roleId": roleId,
                //         },
                //         dataType: "text",
                //         beforeSend: function () {
                //         },
                //         success: function (result) {
                //             if (result == "success") {
                //                 alert("修改成功！")
                //             } else {
                //                 alert("修改失败！")
                //             }
                //         },
                //         error: function () {
                //         },
                //         complete: function () {
                //         }
                //     }
                // );

                if (obj.event === 'edit') {
                    layer.confirm('确定要修改嘛？', function (index) {

                    });
                    $.ajax({
                        url:"/root/rootAllot",
                        data: {"roleId": data.roleId},
                        type: "post",
                        dataType: "json",
                        beforeSend: function () {
                        },
                        success: function (obj) {
                            console.log("111111111")
                            console.log(obj)
                            // //渲染树
                            tree.render({
                                elem: '#roleTree'
                                , data: [obj] //数据源
                                , showCheckbox: true //显示复选框
                                , id: 'roleTree' //定义索引
                            });
                        },
                        error: function () {
                        },
                        complete: function () {
                        }
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

    </script>
</div>

</body>
</html>
