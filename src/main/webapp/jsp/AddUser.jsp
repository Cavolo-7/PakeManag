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
  <title>增加计费规则</title>
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
        <label for="roleName" class="layui-form-label">
          <span class="x-red">*</span>角色名字
        </label>
        <div class="layui-input-inline">
          <input type="text" id="roleName" name="roleName" required="" lay-verify="required"
                 autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label for="paramName" class="layui-form-label">
          <span class="x-red">*</span>权限级别</label>
        <div class="layui-input-inline">
          <select id="paramName" name="paramName" class="valid"  lay-verify="required">
            <option value=""></option>
            <option value="一级权限">一级权限</option>
            <option value="二级权限">二级权限</option>
            <option value="三级权限">三级权限</option>
          </select>
        </div>
      </div>
      <button class="layui-btn" lay-submit lay-filter="addRole" style="margin-left: 150px">
        增加
      </button>
      <button class="layui-btn" onclick="closeAdd()">
        退出
      </button>
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

      // money: [
      //   /^[0-9]*[1-9][0-9]*$/,
      //   '输入金额是否合法'
      // ],
    });

    //监听提交
    form.on('submit(addRole)', function (data) {
      console.log(data);
      $.ajax({
        url: "/userControl/addRole",
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
            }, 20000);
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

