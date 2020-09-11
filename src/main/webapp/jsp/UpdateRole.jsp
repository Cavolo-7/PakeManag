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
                <input type="hidden" id="roleId" name="roleId" required="" lay-verify="workerName"
                       autocomplete="off" disabled="false" class="layui-input">
                <label for="roleName" class="layui-form-label">
                    <span class="x-red">*</span>管理员名字
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="roleName" name="roleName" required="" lay-verify="roleName"
                           autocomplete="off"  class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="urisdictionName" class="layui-form-label">
                    <span class="x-red">*</span>权限级别</label>
                <div class="layui-input-inline">
                    <select id="urisdictionName" name="urisdictionName" class="valid"  lay-verify="required">
                        <option value=""></option>
                        <option value="一级权限">一级权限</option>
                        <option value="二级权限">二级权限</option>
                        <option value="三级权限">三级权限</option>
                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <label for="urisdictionName" class="layui-form-label">
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
        // form.verify({
        //     workerAccount:[/^[0-9]+$/,'账号为整数类型'],
        //     workerAccount:function(value){
        //         if (value.length<2){
        //             return '账号长度需要大于或大于3位'
        //         }
        //     },
        //
        //     workerName:function(value){
        //       if (value.length<2){
        //           return '用户名需要大于或等于两个字符'
        //       }
        //     },
        //
        //     workerAge:[ /^([1-9]\d?|1[01]\d|120)$/,'年龄填写错误'],
        //
        //
        //     workerAddress:function(value){
        //       if (value==''){
        //           return '住址必须填写'
        //       }
        //     },
        //
        //     pass: [/(.+){6,12}$/, '密码必须6到12位'],
        //     repass: function (value) {
        //         if ($('#L_pass').val() != $('#L_repass').val()) {
        //             return '两次密码不一致';
        //         }
        //     }
        // });

        //监听提交
        form.on('submit(add)', function (data) {
            $.ajax({
                url: "/userControl/updRole",
                data: data.field,
                dataType: 'text',
                method: 'post',
                success: function (data) {
                    if (data == "编辑成功") {
                        layer.msg("编辑成功!")
                        // //关闭当前frame
                        setTimeout(function () {
                            xadmin.close();
                        }, 2000000);
                        // // 可以对父窗口进行刷新
                        xadmin.father_reload();
                    } else if(data == "编辑成功"){
                        layer.msg("编辑失败!")
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