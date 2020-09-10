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
        <label for="costrulesName" class="layui-form-label">
          <span class="x-red">*</span>规则名字
        </label>
        <div class="layui-input-inline">
          <input type="text" id="costrulesName" name="costrulesName" required="" lay-verify="required"
                 autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label><span class="x-red" style="font-size: 10px">0 - 0.5小时：设置相关数据</span></label>
      </div>
      <div class="layui-form-item">
        <label for="costrulesBasemoney" class="layui-form-label">
          <span class="x-red">*</span>基础价钱
        </label>
        <div class="layui-input-inline">
          <input type="text" id="costrulesBasemoney" name="costrulesBasemoney" required="" lay-verify="money"
                 autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label for="costrulesAddmoney" class="layui-form-label">
          <span class="x-red">*</span>增量价钱
        </label>
        <div class="layui-input-inline">
          <input type="text" id="costrulesAddmoney" name="costrulesAddmoney" required="" lay-verify="money"
                 autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label for="costrulesDescribe" class="layui-form-label">
          <span class="x-red">*</span>规则描述
        </label>
        <div class="layui-input-inline">
          <input type="text" id="costrulesDescribe" name="costrulesDescribe" required="" lay-verify="required"
                 autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
         <label><span class="x-red" style="font-size: 10px">0.5 - 3小时：设置相关数据</span></label>
      </div>
      <div class="layui-form-item">
        <label for="costrulesBasemoney1" class="layui-form-label">
          <span class="x-red">*</span>基础价钱
        </label>
        <div class="layui-input-inline">
          <input type="text" id="costrulesBasemoney1" name="costrulesBasemoney1" required="" lay-verify="money"
                 autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label for="costrulesAddmoney1" class="layui-form-label">
          <span class="x-red">*</span>增量价钱
        </label>
        <div class="layui-input-inline">
          <input type="text" id="costrulesAddmoney1" name="costrulesAddmoney1" required="" lay-verify="money"
                 autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label for="costrulesDescribe1" class="layui-form-label">
          <span class="x-red">*</span>规则描述
        </label>
        <div class="layui-input-inline">
          <input type="text" id="costrulesDescribe1" name="costrulesDescribe1" required="" lay-verify="required"
                 autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label><span class="x-red" style="font-size: 10px">3 - 5小时：设置相关数据</span></label>
      </div>
      <div class="layui-form-item">
        <label for="costrulesBasemoney2" class="layui-form-label">
          <span class="x-red">*</span>基础价钱
        </label>
        <div class="layui-input-inline">
          <input type="text" id="costrulesBasemoney2" name="costrulesBasemoney2" required="" lay-verify="money"
                 autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label for="costrulesAddmoney2" class="layui-form-label">
          <span class="x-red">*</span>增量价钱
        </label>
        <div class="layui-input-inline">
          <input type="text" id="costrulesAddmoney2" name="costrulesAddmoney2" required="" lay-verify="money"
                 autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label for="costrulesDescribe2" class="layui-form-label">
          <span class="x-red">*</span>规则描述
        </label>
        <div class="layui-input-inline">
          <input type="text" id="costrulesDescribe2" name="costrulesDescribe2" required="" lay-verify="required"
                 autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label><span class="x-red" style="font-size: 10px">5 - 8小时：设置相关数据</span></label>
      </div>
      <div class="layui-form-item">
        <label for="costrulesBasemoney3" class="layui-form-label">
          <span class="x-red">*</span>基础价钱
        </label>
        <div class="layui-input-inline">
          <input type="text" id="costrulesBasemoney3" name="costrulesBasemoney3" required="" lay-verify="money"
                 autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label for="costrulesAddmoney3" class="layui-form-label">
          <span class="x-red">*</span>增量价钱
        </label>
        <div class="layui-input-inline">
          <input type="text" id="costrulesAddmoney3" name="costrulesAddmoney3" required="" lay-verify="money"
                 autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label for="costrulesDescribe3" class="layui-form-label">
          <span class="x-red">*</span>规则描述
        </label>
        <div class="layui-input-inline">
          <input type="text" id="costrulesDescribe3" name="costrulesDescribe3" required="" lay-verify="required"
                 autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label><span class="x-red" style="font-size: 10px">8 - 小时：设置相关数据</span></label>
      </div>
      <div class="layui-form-item">
        <label for="costrulesBasemoney4" class="layui-form-label">
          <span class="x-red">*</span>基础价钱
        </label>
        <div class="layui-input-inline">
          <input type="text" id="costrulesBasemoney4" name="costrulesBasemoney4" required="" lay-verify="money"
                 autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label for="costrulesAddmoney4" class="layui-form-label">
          <span class="x-red">*</span>增量价钱
        </label>
        <div class="layui-input-inline">
          <input type="text" id="costrulesAddmoney4" name="costrulesAddmoney4" required="" lay-verify="money"
                 autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label for="costrulesDescribe4" class="layui-form-label">
          <span class="x-red">*</span>规则描述
        </label>
        <div class="layui-input-inline">
          <input type="text" id="costrulesDescribe4" name="costrulesDescribe4" required="" lay-verify="required"
                 autocomplete="off" class="layui-input">
        </div>
      </div>
      <button class="layui-btn" lay-submit lay-filter="add" style="margin-left: 150px">
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

      money: [
        /^[0-9]*[1-9][0-9]*$/,
        '输入金额是否合法'
      ],
    });

    //监听提交
    form.on('submit(add)', function (data) {
      console.log(data);
      $.ajax({
        url: "/costrules/add",
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

