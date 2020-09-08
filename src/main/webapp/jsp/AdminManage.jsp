<%--
  Created by IntelliJ IDEA.
  User: JC
  Date: 2020/8/16
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>管理员信息查询</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js" charset="UTF-8"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="UTF-8"></script>
<%--    <script src="${pageContext.request.contextPath}/js/Admin.js" charset="UTF-8"></script>--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
</head>
<body>
<input type="hidden" id="path" value="${pageContext.request.contextPath}">
<div>
<%--    <form class="layui-form" action="${pageContext.request.contextPath}/adminServlet?methodName=getAdminList" method="post">--%>
        <div class="layui-form-item">
            <div class="layui-input-block" style="margin-top: 20px">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">用户名：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="adminName" id="adminName" placeholder="请输入管理员姓名" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">账号：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="account" id="account" placeholder="请输入管理员账号" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">电话：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="phone" id="phone" placeholder="请输入电话号码" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                        <button class="layui-btn" style="margin-top: 0px;" id="search" data-type="reload">
                            <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                        </button>
<%--                            <button class="layui-btn" type="button" onclick="cx(this)">查询</button>--%>
                        <button class="layui-btn" type="button" id="searchUserifAccount11" onclick="addAdmin(this)">添加</button>
                    </div>

                </div>
            </div>
        </div>
<%--    </form>--%>
</div>
<div>
    <table id="demo" lay-filter="test"></table>
    <script type="text/html" id="barDemo">
<%--        <a class="layui-btn  layui-btn-xs" lay-event="detail" >添加</a>--%>
        <a class="layui-btn layui-btn-xs" lay-event="edit" onclick="updateAdmin(this)">修改</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
    <script>
        var path = $("#path").val();
        //加载table模块
        layui.use(['table', 'layer', 'laypage'], function () {
            var table = layui.table;
            var laypage = layui.laypage; //分页
            var layer = layui.layer; //弹层


            //执行一个 table 实例
            table.render({
                elem: '#demo'
                , height: 312
                , url: path + '/admin/getAdminList' //数据接口
                , page: {//开启分页
                    layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']
                    , limit: 4//一页显示多少条
                    , limits: [1,2, 5,10]//每页条数的选择项
                    , groups: 2 //只显示 2 个连续页码
                    ,first: "首页" //不显示首页
                    ,last: "尾页" //不显示尾页
                }
                , toolbar: 'default'
                , cols: [[ //表头
                    {field: 'workerId', title: 'ID', width: 80, sort: true,hidden:true}
                    , {field: 'workerAccount', title: '用户名', width: 180}
                    , {field: 'workerName', title: '用户名', width: 180}
                    , {field: 'workerSex', title: '性别', width: 280, sort: true}
                    , {field: 'workerAge', title: '年龄', width: 280, sort: true}
                    , {field: 'workerPhone', title: '电话', width: 4280, sort: true}
                    , {field: 'workerAddress', title: '住址', width: 280, sort: true}
                    , {field: 'roleName', title: '角色', width: 280, sort: true}
                    , {field: 'stateName', title: '账号状态', width: 280, sort: true}
                    , {fixed: 'right',  align: 'center', toolbar: '#barDemo'}

                ]]

            });

            //监听头工具栏事件
            table.on('tool(test)', function (obj) {
                var checkStatus = table.checkStatus(obj.config.id)
                    , data = checkStatus.data; //获取选中的数据
                switch (obj.event) {
                    case 'add':
                        layer.msg('添加');
                        break;
                }

            });


            table.on('tool(test)', function (obj) {
                var data = obj.data;
                 if (obj.event === 'del') {
                     layer.confirm('真的要删除吗', function (index) {
                         $.ajax({
                             url: path + "/admin/deleteAdmin",
                             data: {adminId: data.adminId},
                             success: function (data) {
                                 if (data == "删除成功") {
                                     obj.del();
                                     layer.alert("删除成功");
                                     layer.close(index);

                                 } else {
                                     layer.alert("删除失败");
                                     layer.close(index);
                                 }
                             }
                         })

                     });
                 }
            });


            var active = {
                reload: function () {
                    var adminName = $("#adminName").val();//搜索框内容
                    var date=$("#account").val();
                    var date1=$("#phone").val();
                    //执行重载
                    table.reload('demo', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        , where: {
                            adminName: adminName,//作为参数传递给后端
                            account:account,
                            phone:phone,
                        }
                    });

                }

            };

            $('#search').on('click', function () {
                var type = $(this).data('type');//自定义type属性，这里即为reload
                active[type] ? active[type].call(this) : ''; //如果存在active[type]，则调用改函数
            });

        });





    </script>

</div>
</body>
</html>
