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
    <title>添加管理员</title>
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
                <label for="workerAccount" class="layui-form-label">
                    <span class="x-red">*</span>登录账号
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="workerAccount" name="workerAccount" required="" lay-verify="workerAccount"
                           autocomplete="off" disabled="false" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>将会成为您唯一的登入名
                </div>
            </div>

            <div class="layui-form-item">
                <label for="workerName" class="layui-form-label">
                    <span class="x-red">*</span>用户名
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="workerName" name="workerName" required="" lay-verify="workerName"
                           autocomplete="off" disabled="false" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label for="workerAge" class="layui-form-label">
                    <span class="x-red">*</span>年龄
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="workerAge" name="workerAge" required="" lay-verify="workerAge"
                           autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label for="sex" class="layui-form-label">
                    <span class="x-red">*</span>性别
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="sex" name="sex" required="" lay-verify="sex"
                           autocomplete="off" class="layui-input">
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
                <label for="workerAddress" class="layui-form-label">
                    <span class="x-red">*</span>住址
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="workerAddress" name="workerAddress" required="" lay-verify="workerAddress"
                           autocomplete="off" class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label for="roleName" class="layui-form-label">
                    <span class="x-red">*</span>角色</label>
                <div class="layui-input-inline">
                    <select id="roleName" name="roleName" class="valid">
                        <option value="收费员">收费员</option>
                        <option value="管理员">管理员</option>
                        <option value="超级管理员">超级管理员</option>
                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <label for="stateName" class="layui-form-label">
                    <span class="x-red">*</span>状态</label>
                <div class="layui-input-inline">
                    <select id="stateName" name="stateName" class="valid">
                        <option value="启用">启用</option>
                        <option value="禁用">禁用</option>
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
                  修改
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
            workerAccount:[/^[0-9]+$/,'账号为整数类型'],
            workerAccount:function(value){
                if (value.length<2){
                    return '账号长度需要大于或大于3位'
                }
            },

            workerName:function(value){
              if (value.length<2){
                  return '用户名需要大于或等于两个字符'
              }
            },

            workerAge:[ /^([1-9]\d?|1[01]\d|120)$/,'年龄填写错误'],

            // phone:[/^([1]\d{10}|([\(（]?0[0-9]{2,3}[）\)]?[-]?)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?)$/,'手机号码格式错误'],

            workerAddress:function(value){
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
                url: "/admin/updateAdmin",
                data: data.field,
                dataType: 'text',
                method: 'post',
                success: function (data) {
                    if (data == "修改成功") {
                        layer.msg("修改成功!")
                        // //关闭当前frame
                        setTimeout(function () {
                            xadmin.close();
                        }, 2000000);
                        // // 可以对父窗口进行刷新
                        xadmin.father_reload();
                    } else if(data == "修改失败"){
                        layer.msg("修改失败!")
                    }else if (data == "该号码已存在"){
                        layer.msg("该号码已存在!")
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