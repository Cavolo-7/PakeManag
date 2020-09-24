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
                        <br><br><br>
                        <button class="layui-btn" onclick="xadmin.open('年度统计','./YearDetail.jsp',600,470)"><i
                                class="layui-icon"></i>年度统计
                        </button>
                    </div>
                </div>
                <div class="layui-card-body ">
                    <table class="layui-hide" id="demo" lay-filter="demo">
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/html" id="barDemo">
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
            ,totalRow: true
            ,defaultToolbar:['print']
            , cellMinWidth: 80
            , text: {
                none: '暂无相关数据'
            }

            , toolbar: '#demo'
            , cols: [[
                ,{type: 'numbers', width: '5%', title: '序号', align: 'center', totalRowText: '合计'}
                , {field: 'detailId', title: 'ID', width: '5%',align: 'center',hide: true}
                , {field: 'detailCarnumber', title: '车牌号', width: '10%',align: 'center'}
                , {field: 'detailEvent', title: '业务', width: '10%',align: 'center'}
                , {field: 'produceId', title: '产品ID', width: '5%',align: 'center',hide: true}
                , {field: 'detailTime', title: '记录时间', width: '15%',align: 'center'}
                , {field: 'detailMoney', title: '金额', width: '10%',align: 'center',totalRow: true}
                , {field: 'workerName', title: '工作人员', width: '10%',align: 'center'}
                , {field: 'detailType', title: '支付方式', align: 'center'}
            ],

            ]
            , id: 'testReload'
        })


        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });

</script>
</html>

