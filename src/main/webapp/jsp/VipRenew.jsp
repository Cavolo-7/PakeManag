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
    <title>vip套餐续费</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form">
            <div class="layui-form-item">
                <div class="layui-input-inline">
                    <input type="hidden" id="personId" name="personId" autocomplete="off" class="layui-input" >
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-inline">
                    <input type="hidden" id="recordEndtime" name="recordEndtime" autocomplete="off" class="layui-input" >
                </div>
            </div>
            <div class="layui-form-item">
                <label for="personAccount" class="layui-form-label">
                    <span class="x-red"></span>登录账号
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="personAccount" name="personAccount" required="" lay-verify="personAccount"
                           autocomplete="off" disabled="false" class="layui-input" disabled="false">
                </div>
            </div>

            <div class="layui-form-item">
                <label for="personName" class="layui-form-label">
                    <span class="x-red"></span>用户名
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="personName" name="personName" required="" lay-verify="personName"
                           autocomplete="off" disabled="false" class="layui-input" disabled="false">
                </div>
            </div>

            <div class="layui-form-item">
                <label for="personCarnumber" class="layui-form-label">
                    <span class="x-red"></span>车牌号
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="personCarnumber" name="personCarnumber" required="" lay-verify="personCarnumber"
                           autocomplete="off"  disabled="false" class="layui-input" disabled="false">
                </div>
            </div>

            <div class="layui-form-item">
                <label for="produceName" class="layui-form-label">
                    <span class="x-red"></span>月缴产品</label>
                <div class="layui-input-inline">
                    <select name="produceName" id="produceName" lay-verify="required" lay-filter="produceName" class="select">
                        <option value="">请选择</option>
                        <c:if test="${not empty produceList2}">
                            <c:forEach items="${produceList2}" var="p">
                                <option value="${p.produceName}" >${p.produceName}</option>
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
                           autocomplete="off" class="layui-input" disabled="false">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"> <span class="x-red"></span></label></label>
                <button class="layui-btn" lay-filter="add" lay-submit="">
                    现金续费
                </button>


                    <button class="layui-btn" lay-filter="zf" lay-submit="">
                        网上支付续费
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
        //监听提交
        form.on('submit(add)', function (data) {
            $.ajax({
                url: "/person/vipRenew",
                data: data.field,
                dataType: 'text',
                method: 'post',
                success: function (data) {
                    if (data == "续费成功") {
                        layer.msg("续费成功!")
                        // //关闭当前frame
                        setTimeout(function () {
                            xadmin.close();
                        }, 2000000);
                        // // 可以对父窗口进行刷新
                        xadmin.father_reload();
                    } else if(data == "续费失败"){
                        layer.msg("续费失败!")
                    }
                }
            })
            return false;
            });
//网上支付
        form.on('submit(zf)', function (data) {
            $.ajax({
                url: "/person/renewAlipay",
                data: data.field,
                dataType: 'text',
                method: 'post',
                success: function (data) {
                    if (data == "续费成功") {
                        layer.alert("续费成功!")
                        // //关闭当前frame
                        setTimeout(function () {
                            xadmin.close();
                        }, 2000000);
                        // // 可以对父窗口进行刷新
                        xadmin.father_reload();
                    } else if(data == "续费失败"){
                        layer.alert("续费失败!")
                    }
                }
            })
            return false;
        });


    });
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