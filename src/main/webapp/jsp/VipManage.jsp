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
                            <input class="layui-input" name="vipName" placeholder="请输入用户姓名" id="vipName"
                                   autocomplete="off">
                        </div>
                        <div class="layui-inline">
                            <input class="layui-input" name="account" placeholder="请输入用户账号" id="account"
                                   autocomplete="off">
                        </div>
                        <div class="layui-inline">
                            <input class="layui-input" name="phone" placeholder="请输入电话号码" id="phone" autocomplete="off">
                        </div>
                        <div class="layui-inline">
                            <input class="layui-input" type="date" name="vipStarTime" placeholder="开始时间" id="vipStarTime" autocomplete="off">
                        </div>
                        <div class="layui-inline">
                            <input class="layui-input" type="date" name="vipEndTime" placeholder="截止时间" id="vipEndTime" autocomplete="off">
                        </div>
                        <button class="layui-btn" data-type="reload" id="search">搜索</button>
                        <br><br><br>
                        <%--                        <button class="layui-btn layui-btn-danger" data-type="getCheckData">批量删除</button>--%>
                        <button class="layui-btn" onclick="xadmin.open('添加用户','./AddVip.jsp',600,470)"><i
                                class="layui-icon"></i>新增VIP
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

    <a class="layui-btn layui-btn-xs" lay-event="edit">续费</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">退费</a>
    <a class="layui-btn layui-btn-xs" lay-event="detail">重置密码</a>
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
            , url: '/vip/getVipList'
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
                , {field: 'vipId', title: 'ID', width: '5%',align: 'center',hide: true}
                , {field: 'vipAccount', title: '用户账号', width: '5%',align: 'center'}
                , {field: 'vipName', title: '用户名', width: '10%',align: 'center'}
                , {field: 'sexName', title: '性别', width: '5%',align: 'center'}
                , {field: 'vipAge', title: '年龄', width: '5%',align: 'center'}
                , {field: 'vipPhone', title: '电话', width: '10%',align: 'center'}
                , {field: 'vipAddress', title: '住址', width: '10%',align: 'center'}
                ,{field: 'vipCarNumber', title: '车牌号', width: '10%',align: 'center'}
                , {field: 'vipRecharge', title: '用户余额', width: '10%',align: 'center'}
                , {field: 'vipScore', title: '用户积分', width: '5%',align: 'center'}
                , {field: 'vipStarTime', width: '10%', title: '开通时间', align: 'center'}
                , {field: 'vipEndTime', width: '10%', title: '截止时间', align: 'center'}
                , {field: 'produceName', title: '产品名称', width: '10%',align: 'center'}
                , {field: 'workerName', title: '办理员工', width: '10%',align: 'center'}
                , {field: 'right', title: '操作', toolbar: '#barDemo', align: 'center'}
            ]]
            , id: 'testReload'
        })
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                layer.confirm('确定要续费吗？', function (index) {
                layer.open({
                    // anim: 1,
                    type: 2,//Page层类型
                    area: ['500px', '500px'],
                    title: 'VIP续费',
                    shadeClose: true,
                    shade: false,
                    id: 'alterp',
                    shade: 0.6, //遮罩透明度,
                    maxmin: true, //允许全屏最小化,
                    anim: 1, //0-6的动画形式，-1不开启,
                    content: ['/jsp/VipRenew.jsp'],
                    success: function (layero, index) {
                        var body = layer.getChildFrame('body', index);
                        body.contents().find("#vipAccount").val(data.vipAccount)
                        body.contents().find("#vipName").val(data.vipName)
                        body.contents().find("#vipCarNumber").val(data.vipCarNumber)
                    },
                    end: function () {
                        $("#search").click();
                    }
                });

                });
            } else if (obj.event === 'del') {
                layer.confirm('确定要退费吗？', function (index) {
                    layer.open({
                        // anim: 1,
                        type: 2,//Page层类型
                        area: ['500px', '500px'],
                        title: 'VIP退费',
                        shadeClose: true,
                        shade: false,
                        id: 'alterp',
                        shade: 0.6, //遮罩透明度,
                        maxmin: true, //允许全屏最小化,
                        anim: 1, //0-6的动画形式，-1不开启,
                        content: ['/jsp/VipRefund.jsp'],
                        success: function (layero, index) {
                            var body = layer.getChildFrame('body', index);
                            body.contents().find("#vipAccount").val(data.vipAccount)
                            body.contents().find("#vipName").val(data.vipName)
                            body.contents().find("#vipCarNumber").val(data.vipCarNumber)
                        },
                        end: function () {
                            $("#search").click();
                        }
                    });

                });
            } else if (obj.event === 'detail') {
                layer.confirm('确定要重置密码吗？', function (index) {
                    $.ajax({
                        url: "/vip/updateVipPassword",
                        data: {vipAccount: data.vipAccount},
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
            }
        });


        var $ = layui.$, active = {
            reload: function () {
                var vipName = $('#vipName').val();
                var account = $('#account').val();
                var phone = $('#phone').val();
                var vipStarTime=$('#vipStarTime').val();
                var vipEndTime=$('#vipEndTime').val();
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        key: {
                            vipName: vipName,
                            account: account,
                            phone: phone,
                            vipStarTime:vipStarTime,
                            vipEndTime:vipEndTime,
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

