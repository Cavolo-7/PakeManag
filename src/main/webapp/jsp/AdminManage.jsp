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
    <title>管理员管理</title>
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
<div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">演示</a>
            <a>
              <cite>导航元素</cite></a>
          </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       onclick="location.reload()"
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
                            <input class="layui-input" name="adminName" placeholder="请输入管理员姓名" id="adminName"
                                   autocomplete="off">
                        </div>
                        <div class="layui-inline">
                            <input class="layui-input" name="account" placeholder="请输入管理员账号" id="account"
                                   autocomplete="off">
                        </div>
                        <div class="layui-inline">
                            <input class="layui-input" name="phone" placeholder="请输入电话号码" id="phone" autocomplete="off">
                        </div>
                        <button class="layui-btn" data-type="reload" id="search">搜索</button>
                        <br><br><br>
                        <%--                        <button class="layui-btn layui-btn-danger" data-type="getCheckData">批量删除</button>--%>
                        <button class="layui-btn" onclick="xadmin.open('添加用户','./AddAdmin.jsp',600,470)"><i
                                class="layui-icon"></i>添加
                        </button>
                    </div>
                </div>
                <div class="layui-card-body ">
                    <table class="layui-hide" id="demo" lay-filter="demo"></table>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/html" id="barDemo">
    {{#  if(d.stateName!="注销"){ }}
    {{#  if(d.stateName=="启用"){ }}
    <a class="layui-btn layui-btn-xs" lay-event="edit" onclick="updateAdmin(this)">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">注销</a>
    <a class="layui-btn layui-btn-xs" lay-event="detail">重置密码</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" title="禁用" lay-event="disable" value="禁用">禁用</a>
    {{#  } else { }}
    <a class="layui-btn layui-btn-sm layui-btn-xs" lay-event="enabled" title="启用" value="启用">启用</a>
    {{#  } }}
    {{#  }}}
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
            , url: '/admin/getAdminList'
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
                // {type: 'checkbox', width: '5%', fixed: 'left', align: 'center'}
                {type: 'numbers', width: '5%', title: '序号', align: 'center'}
                , {field: 'workerAccount', title: '账号', width: '5%'}
                , {field: 'workerName', title: '用户名', width: '10%'}
                , {field: 'sexName', title: '性别', width: '5%',}
                , {field: 'workerAge', title: '年龄', width: '5%',}
                , {field: 'workerPhone', title: '电话', width: '10%',}
                , {field: 'workerAddress', title: '住址', width: '10%',}
                , {field: 'roleName', title: '角色', width: '10%',}
                , {field: 'stateName', title: '账号状态', width: '5%',}
                , {field: 'workerCreatetimr', width: '10%', title: '创建时间', align: 'center'}
                , {field: 'workerPassword', title: '密码', width: '5%',hidden:true}
                , {field: 'right', title: '操作', toolbar: '#barDemo', align: 'center'}
            ]]
            , id: 'testReload'
        })
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                layer.open({
                    // anim: 1,
                    type: 2,//Page层类型
                    area: ['500px', '500px'],
                    title: '添加类型',
                    shadeClose: true,
                    shade: false,
                    id: 'alterp',
                    shade: 0.6, //遮罩透明度,
                    maxmin: true, //允许全屏最小化,
                    anim: 1, //0-6的动画形式，-1不开启,
                    content: ['/jsp/UpdateAdmin.jsp'],
                    success: function (layero, index) {
                        var body = layer.getChildFrame('body', index);
                        body.contents().find("#workerAccount").val(data.workerAccount)
                        body.contents().find("#workerName").val(data.workerName)
                        body.contents().find("#workerAge").val(data.workerAge)
                        body.contents().find("#sex").val(data.sexName)
                        body.contents().find("#phone").val(data.workerPhone)
                        body.contents().find("#workerAddress").val(data.workerAddress)
                        body.contents().find("#L_pass").val(data.workerPassword)
                        body.contents().find("#L_repass").val(data.workerPassword)
                    },
                    end: function () {
                        $("#search").click();
                    }
                });


            } else if (obj.event === 'del') {
                var stateName = "注销"
                layer.confirm('确定要注销吗？', function (index) {
                    $.ajax({
                        url: "/admin/updateDimission",
                        data: {workerAccount: data.workerAccount, stateName: stateName},
                        method: "post",
                        dataType: "text",
                        success: function (data) {
                            if (data == "注销成功") {
                                layer.msg("注销成功!")
                                // layer.close(index);
                                $("#search").click();
                            } else {
                                layer.msg("注销失败!")
                            }
                        }
                    })

                });
            } else if (obj.event === 'detail') {
                layer.confirm('确定要重置密码吗？', function (index) {
                    $.ajax({
                        url: "/admin/updateAdminPassword",
                        data: {workerAccount: data.workerAccount},
                        method: "post",
                        dataType: "text",
                        success: function (data) {
                            if (data == "重置成功") {
                                layer.alert("重置密码成功！默认密码为：123456")
                                // layer.close(index);
                            } else {
                                layer.msg("重置密码失败!")
                            }
                        }
                    })
                });
            } else if (obj.event === 'disable') {
                var stateName = "禁用"
                layer.confirm('确定要禁用？', function (index) {
                    $.ajax({
                        url: "/admin/updateAdminState",
                        data: {workerAccount: data.workerAccount, stateName: stateName},
                        method: "post",
                        dataType: "text",
                        success: function (data) {
                            if (data == "修改成功") {
                                layer.alert("禁用成功！")
                                $("#search").click();
                                // layer.close(index);
                            } else {
                                layer.msg("禁用失败!")
                            }
                        }
                    })
                });
            } else if (obj.event === 'enabled') {
                var stateName = "启用"
                layer.confirm('确定要启用？', function (index) {
                    $.ajax({
                        url: "/admin/updateAdminState",
                        data: {workerAccount: data.workerAccount, stateName: stateName},
                        method: "post",
                        dataType: "text",
                        success: function (data) {
                            if (data == "修改成功") {
                                layer.alert("启用成功！")
                                $("#search").click();
                                // layer.close(index);
                            } else {
                                layer.msg("启用失败!")
                            }
                        }
                    })
                });
            }
        });


        var $ = layui.$, active = {
            reload: function () {
                var adminName = $('#adminName').val();
                var account = $('#account').val();
                var phone = $('#phone').val();
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        key: {
                            adminName: adminName,
                            account: account,
                            phone: phone,
                        }
                    }
                }, 'data');
            }
        };

        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

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

