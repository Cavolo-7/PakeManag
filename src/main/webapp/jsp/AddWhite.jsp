<%--
  Created by IntelliJ IDEA.
  User: 69080
  Date: 2020/8/17
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
<head>
  <meta charset="UTF-8">
  <title>增加白名单</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport"
        content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
  <link rel="stylesheet" href="../css/font.css">
  <link rel="stylesheet" href="../css/xadmin.css">
  <script src="../layui/layui.js" charset="utf-8"></script>
  <script type="text/javascript" src="../js/xadmin.js"></script>
  <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<%--  <!--[if lt IE 9]>--%>
<%--  <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>--%>
<%--  <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>--%>
<%--  <![endif]-->--%>
</head>
<body>
<div class="layui-fluid">
  <div class="layui-row">
    <form class="layui-form">
      <div class="layui-form-item">
        <label for="username" class="layui-form-label">
          <span class="x-red">*</span>用户名
        </label>
        <div class="layui-input-inline">
          <input type="text" id="username" name="username" required="" lay-verify="required"
                 autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">
          <span class="x-red">*</span>将会成为您唯一的登入名
        </div>
      </div>
      <div class="layui-form-item">
        <label for="account" class="layui-form-label">
          <span class="x-red">*</span>账号
        </label>
        <div class="layui-input-inline">
          <input type="text" id="account" name="account" required="" lay-verify="required"
                 autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">
          <span class="x-red">*</span>将会成为您唯一的登入名
        </div>
      </div>
      <div class="layui-form-item">
        <label for="phone" class="layui-form-label">
          <span class="x-red">*</span>手机
        </label>
        <div class="layui-input-inline">
          <input type="text" id="phone" name="phone" required="" lay-verify="phone"
                 autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">
          <span class="x-red">*</span>
        </div>
      </div>
      <div class="layui-form-item">
        <label for="L_carnumber" class="layui-form-label">
          <span class="x-red">*</span>车牌号
        </label>
        <div class="layui-input-inline">
          <input type="text" id="L_carnumber" name="carnumber" required="" lay-verify="carnumber"
                 autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">
          <span class="x-red">*</span>
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
        <button class="layui-btn" lay-submit lay-filter="add" >
          增加
        </button>
        <button class="layui-btn" onclick="closeAdd()">
          退出
        </button>
      </div>
    </form>
  </div>
</div>
<script>

  function closeAdd(){
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭
  }

  layui.use(['form', 'layer'], function () {
  $ = layui.jquery;
  var form = layui.form,
      layer = layui.layer;

  //自定义验证规则
  form.verify({
    nikename: function (value) {
      if (value.length < 5) {
        return '昵称至少得5个字符啊';
      }
    },
    pass: [/(.+){6,12}$/, '密码必须6到12位'],
    repass: function (value) {
      if ($('#L_pass').val() != $('#L_repass').val()) {
        return '两次密码不一致';
      }
    },

    carnumber: [
        /^[\u4E00-\u9FA5]([0-9A-Z]{6})|([0-9A-Z]{5}[\u4E00-\u9FA5]{1})$/,
        '车牌号码是否合法'
      ],
  });

  //监听提交
  form.on('submit(add)', function (data) {
    console.log(data);
    $.ajax({
      url: "/personManage/add",
      data: data.field,
      dataType: 'text',
      method: 'post',
      success: function (datas) {
        console.log(datas)
        if (datas == "增加成功") {
          layer.msg("增加成功")
          //关闭当前frame
          setTimeout(function () {
            xadmin.close();
          }, 10000);
          // 可以对父窗口进行刷新
          xadmin.father_reload();
        } else {
          layer.msg("增加失败")
        }
      }
    })
    return false;
  });
});
</script>
</body>

</html>

