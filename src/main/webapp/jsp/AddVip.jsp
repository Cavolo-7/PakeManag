<%--
  Created by IntelliJ IDEA.
  User: JC
  Date: 2020/9/7
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <label for="vipAccount" class="layui-form-label">
                    <span class="x-red">*</span>登录账号
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="vipAccount" name="vipAccount" required="" lay-verify="vipAccount"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>将会成为您唯一的登入名
                </div>
            </div>

            <div class="layui-form-item">
                <label for="vipName" class="layui-form-label">
                    <span class="x-red">*</span>用户名
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="vipName" name="vipName" required="" lay-verify="vipName"
                           autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label for="vipAge" class="layui-form-label">
                    <span class="x-red">*</span>年龄
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="vipAge" name="vipAge" required="" lay-verify="vipAge"
                           autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label fro="sex" class="layui-form-label">
                    <span class="x-red">*</span>性别
                </label>
                <div class="layui-input-block">
                    <input name="sex" type="radio" value="男" checked>男 &nbsp; &nbsp; <input name="sex" type="radio" value="女">女
                </div>
            </div>

            <div class="layui-form-item">
                <label for="phone" class="layui-form-label">
                    <span class="x-red">*</span>手机号码
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="phone" name="phone" required="" lay-verify="phone"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="carNumber" class="layui-form-label">
                    <span class="x-red">*</span>车牌号
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="carNumber" name="carNumber" required="" lay-verify="carNumber"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="vipAddress" class="layui-form-label">
                    <span class="x-red">*</span>住址
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="vipAddress" name="vipAddress" required="" lay-verify="vipAddress"
                           autocomplete="off" class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label for="produceName" class="layui-form-label">
                    <span class="x-red">*</span>月缴产品</label>
                <div class="layui-input-inline">
                    <select id="produceName" name="produceName" class="valid">
                        <option value="普通套餐">普通套餐</option>
                        <option value="黄金套餐">黄金套餐</option>
                        <option value="白金套餐">白金套餐</option>
                        <option value="钻石套餐">钻石套餐</option>
                        <option value="至尊套餐">至尊套餐</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label for="L_pass" class="layui-form-label">
                    <span class="x-red">*</span>密码
                </label>
                <div class="layui-input-inline">
                    <input type="password" id="L_pass" name="pass" required="" lay-verify="pass"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    6到16个字符
                </div>
            </div>
            <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">
                    <span class="x-red">*</span>确认密码
                </label>
                <div class="layui-input-inline">
                    <input type="password" id="L_repass" name="repass" required="" lay-verify="repass"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">
                </label>
                <button class="layui-btn" lay-filter="add" lay-submit="">
                    增加
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
            vipAccount:[/^[0-9]+$/,'账号为整数类型'],
            vipAccount:function(value){
                if (value.length<2){
                    return '账号长度需要大于或大于3位'
                }
            },

            vipName:function(value){
              if (value.length<2){
                  return '用户名需要大于或等于两个字符'
              }
            },

            vipAge:[ /^([1-9]\d?|1[01]\d|120)$/,'年龄填写错误'],

            carNumber: [
                /^[\u4E00-\u9FA5]([0-9A-Z]{6})|([0-9A-Z]{5}[\u4E00-\u9FA5]{1})$/,
                '车牌号码是否合法'
            ],

            vipAddress:function(value){
              if (value==''){
                  return '住址必须填写'
              }
            },
            pass: [/(.+){6,12}$/, '密码必须6到12位'],
            repass: function (value) {
                if ($('#L_pass').val() != $('#L_repass').val()) {
                    return '两次密码不一致';
                }
            }
        });

        //监听提交
        form.on('submit(add)', function (data) {
            $.ajax({
                url: "/vip/addVip",
                data: data.field,
                dataType: 'text',
                method: 'post',
                success: function (data) {
                    if (data == "增加成功") {
                        layer.msg("增加成功!")
                        // //关闭当前frame
                        setTimeout(function () {
                            xadmin.close();
                        }, 20000);
                        // // 可以对父窗口进行刷新
                        xadmin.father_reload();
                    } else if(data == "增加失败"){
                        layer.msg("增加失败!")
                    }else if (data == "账号已存在"){
                        layer.msg("该账号已经存在!")
                    }else if (data=="电话号码已存在"){
                        layer.msg("电话号码已存在!")
                    }else if (data=="车牌号已存在"){
                        layer.msg("车牌号已存在!")
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