<%--
  Created by IntelliJ IDEA.
  User: 69080
  Date: 2020/8/17
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>收费日结</title>
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
                            <input class="layui-input" name="personCarnumber" placeholder="请输入车牌号码" id="personCarnumber" autocomplete="off">
                        </div>
                        <div class="layui-inline">
                            <input class="layui-input" type="date" name="date1" placeholder="开始时间"
                                   id="date1" autocomplete="off">
                        </div>
                        <div class="layui-inline">
                            <input class="layui-input" type="date" name="date2" placeholder="截止时间"
                                   id="date2" autocomplete="off">
                        </div>
                        <div class="layui-inline">
                            <form class="layui-form">
                                <div class="layui-input-inline" style="margin-top: 5px">
                                    <select name="workerNames" id="workerNames" lay-verify="required">
                                        <option value="">请选择</option>
                                        <c:if test="${not empty adminList}">
                                            <c:forEach items="${adminList}" var="admin">
                                                <option value="${admin.workerName}" >${admin.workerName}</option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </form>
                        </div>
                        <button class="layui-btn" data-type="reload" id="search">搜索</button>
                        <%--                        <button class="layui-btn layui-btn-danger" data-type="getCheckData">批量删除</button>--%>
<%--                        <button class="layui-btn" onclick="xadmin.open('添加用户','./AddVip.jsp',600,470)"><i--%>
<%--                                class="layui-icon"></i>新增VIP--%>
<%--                        </button>--%>
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
    <a class="layui-btn layui-btn-xs" lay-event="edit">开通会员</a>
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
            , url: '/settlement/getDetailList'
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
            , toolbar: '#demo'
            , cols: [[
                //序号
                // {type: 'checkbox', width: '5%', fixed: 'left', align: 'center'}
                {type: 'numbers', width: '5%', title: '序号', align: 'center' unresize: true, sort: true, totalRowText: '合计'}
                , {field: 'detailId', title: 'ID', width: '5%',align: 'center',hide: true}
                , {field: 'detailCarnumber', title: '车牌号', width: '10%',align: 'center'}
                , {field: 'detailEvent', title: '业务', width: '10%',align: 'center'}
                , {field: 'produceId', title: '产品ID', width: '5%',align: 'center',hide: true}
                , {field: 'detailTime', title: '记录时间', width: '15%',align: 'center'}
                , {field: 'detailMoney', title: '金额', width: '10%',align: 'center',totalRow: true}
                , {field: 'workerName', title: '工作人员', width: '10%',align: 'center'}
                ,{field: 'detailType', title: '支付方式', width: '10%',align: 'center'}
                , {field: 'right', title: '操作', toolbar: '#barDemo', align: 'center'}
            ]]
            , id: 'testReload'
        })
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                layer.confirm('确定要开通会员吗？', function (index) {
                    layer.open({
                        // anim: 1,
                        type: 2,//Page层类型
                        area: ['500px', '500px'],
                        title: 'VI开通',
                        shadeClose: true,
                        shade: false,
                        id: 'alterp',
                        shade: 0.6, //遮罩透明度,
                        maxmin: true, //允许全屏最小化,
                        anim: 1, //0-6的动画形式，-1不开启,
                        content: ['/jsp/AddVip.jsp'],
                        success: function (layero, index) {
                            var body = layer.getChildFrame('body', index);
                            body.contents().find("#personId").val(data.personId)
                            body.contents().find("#personAccount").val(data.personAccount)
                            body.contents().find("#personName").val(data.personName)
                            body.contents().find("#personCarnumber").val(data.personCarnumber)
                        },
                        end: function () {
                            $("#search").click();
                        }
                    });
                });

            }
        })

        var $ = layui.$, active = {
            reload: function () {
                var personCarnumber = $('#personCarnumber').val();
                var date1 = $('#date1').val();
                var date2 = $('#date2').val();
                var workerNames=$('#workerNames').val();
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        key: {
                            personCarnumber: personCarnumber,
                            date1: date1,
                            date2: date2,
                            workerNames:workerNames,
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

