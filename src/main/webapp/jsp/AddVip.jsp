<%--
  Created by IntelliJ IDEA.
  User: JC
  Date: 2020/9/7
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>添加vip用户</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    <%--    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->--%>
    <%--    <!--[if lt IE 9]>--%>
    <%--        <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>--%>
    <%--        <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>--%>
    <%--    <![endif]-->--%>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form">
            <div class="layui-form-item">
                <div class="layui-input-inline">
                    <input type="hidden" id="personId" name="personId" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label for="personAccount" class="layui-form-label">
                    <span class="x-red"></span>登录账号
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="personAccount" name="personAccount" required="" lay-verify="personAccount"
                           autocomplete="off" class="layui-input" >
                </div>
                <div class="layui-form-mid layui-word-aux">
                </div>
            </div>

            <div class="layui-form-item">
                <label for="personName" class="layui-form-label">
                    <span class="x-red"></span>用户名
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="personName" name="personName" required="" lay-verify="personName"
                           autocomplete="off" class="layui-input" >
                </div>
            </div>

            <div class="layui-form-item">
                <label for="personCarnumber" class="layui-form-label">
                    <span class="x-red"></span>车牌号
                </label>
                <div class="layui-input-inline">
<%--                    return false;--%>
                    <input type="text" id="personCarnumber" name="personCarnumber" required=""
                           lay-verify="personCarnumber"
                           autocomplete="off" class="layui-input" >
                </div>
            </div>

            <div class="layui-form-item">
                <label for="produceName" class="layui-form-label">
                    <span class="x-red"></span>月缴产品</label>
                <div class="layui-input-inline">
                    <%--                        onchange="show_sub(this.options[this.options.selectedIndex].value)"--%>
                    <select name="produceName" id="produceName" lay-verify="required" lay-filter="produceName"
                            class="select">
                        <option value="">请选择</option>
                        <c:if test="${not empty produceList2}">
                            <c:forEach items="${produceList2}" var="p">
                                <option value="${p.produceName}">${p.produceName}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <label for="money" class="layui-form-label">
                    <span class="x-red"></span>套餐金额
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="money" name="money" required="" lay-verify="money"
                           autocomplete="off" class="layui-input" >
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label"> <span class="x-red"></span></label></label>
                <button class="layui-btn" lay-filter="add" lay-submit="">
                    现金开通
                </button>
<%--                onclick="zf(this)"--%>
                <button class="layui-btn" lay-filter="zf" lay-submit="">
                    网上支付开通
                </button>
                <button class="layui-btn" lay-filter="quit" onclick="quit(this)">
                    取消
                </button>
            </div>
        </form>
    </div>
</div>
<script>layui.use(['form', 'layer'],
    function () {
        $ = layui.jquery;
        var form = layui.form,
            layer = layui.layer;


        //自定义验证规则
        form.verify({
            personAccount: [/^[0-9]+$/, '账号为整数类型'],
            personAccount: function (value) {
                if (value.length < 2) {
                    return '账号长度需要大于或大于3位'
                }
            },

            personName: function (value) {
                if (value.length < 2) {
                    return '用户名需要大于或等于两个字符'
                }
            },
            personCarnumber: [
                /^[\u4E00-\u9FA5]([0-9A-Z]{6})|([0-9A-Z]{5}[\u4E00-\u9FA5]{1})$/,
                '车牌号码是否合法'
            ],
        });
        //选择套餐后加上值
        form.on('select(produceName)', function (data) {
            var produceName = $("#produceName").val()
            if (produceName != null) {
                $.ajax({
                    url: "/person/selectMoney",
                    data: {produceName: produceName},
                    method: "post",
                    dataType: "text",
                    success: function (data) {
                        $("#money").val(data)
                    }
                })
            }
        });

        // form.on('submit(zf)', function (data) {
        //     var personId = $("#personId").val()
        //     var personAccount = $("#personAccount").val()
        //     var personCarnumber = $("#personCarnumber").val()
        //     var personName = $("#personName").val()
        //     var subject="开通会员";
        //     var total_amount = $("#money").val()
        //     var body=$("#produceName").val();
        //     if ( produceName&& produceName!=''&& total_amount!= null &&total_amount!='') {
        //         top.location.href="/person/zf?subject="+subject+"&total_amount="+total_amount+"&body="+body+"&personId="+personId+"&personAccount="+personAccount+"&personCarnumber="+personCarnumber+"&personName="+personName;
        //         top
        //     } else {
        //         layer.alert("请选择要开通的套餐！")
        //     }
        //     return false;
        // });


        //监听提交
        form.on('submit(add)', function (data) {
            var produceName = $("#produceName").val()
            var money = $("#money").val()
            if (produceName != null && money != null) {
                $.ajax({
                    url: "/person/addVip",
                    data: data.field,
                    dataType: 'text',
                    method: 'post',
                    success: function (data) {
                        if (data == "开通成功") {
                            layer.msg("开通成功!")
                            // //关闭当前frame
                            setTimeout(function () {
                                xadmin.close();
                            }, 20000);
                            // // 可以对父窗口进行刷新
                            xadmin.father_reload();
                        } else if (data == "开通失败") {
                            layer.msg("开通失败!")
                        }
                    }
                })
            } else {
                layer.msg("请选择要开通的套餐！")
            }
            return false;
        });
        //支付宝开通
        //监听提交
        form.on('submit(zf)', function (data) {
            var produceName = $("#produceName").val()
            var money = $("#money").val()

                $.ajax({
                    url: "/person/addVipAlipay",
                    data: data.field,
                    dataType: 'text',
                    method: 'post',
                    success: function (data) {
                        if (data == "开通成功") {
                            layer.msg("开通成功!")
                            // //关闭当前frame
                            setTimeout(function () {
                                xadmin.close();
                            }, 20000);
                            // // 可以对父窗口进行刷新
                            xadmin.father_reload();
                        } else if (data == "开通失败") {
                            layer.msg("开通失败!")
                        }
                    }
                })
            return false;
        });

    });

// function zf(node) {
//     var personId = $("#personId").val()
//     var personAccount = $("#personAccount").val()
//     var personCarnumber = $("#personCarnumber").val()
//     var personName = $("#personName").val()
//     var subject="开通会员";
//     var total_amount = $("#money").val()
//     var body=$("#produceName").val();
//     if ( body&& body!=''&& total_amount!= null &&total_amount!='') {
//         window.open("/person/zf?subject="+subject+"&total_amount="+total_amount+"&body="+body+"&personId="+personId+"&personAccount="+personAccount+"&personCarnumber="+personCarnumber+"&personName="+personName);
//     } else {
//         layer.alert("请选择要开通的套餐！")
//     }
// }


function quit(node) {
    setTimeout(function () {
        xadmin.close();
    }, 20000);
    // // 可以对父窗口进行刷新
    xadmin.father_reload();
}



</script>
</body>

</html>