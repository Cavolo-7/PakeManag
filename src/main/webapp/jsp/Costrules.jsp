<%--
  Created by IntelliJ IDEA.
  User: 69080
  Date: 2020/8/17
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
<head>
  <meta charset="UTF-8">
  <title>计费规则</title>
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
  <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()"
     title="刷新">
    <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
</div>
<div class="layui-fluid">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md12">
      <div class="layui-card">
        <div class="layui-card-body ">
          <div class="demoTable">
            <button class="layui-btn" data-type="reload" id="search" >搜索</button>
            <button class="layui-btn" onclick="xadmin.open('添加产品','./AddCostrules.jsp',380,500)"><i
                    class="layui-icon"></i>添加
            </button>
          </div>
        </div>
        <div class="layui-card-body ">
          <table class="layui-hide" id="costrulesTable" lay-filter="costrulesTable"></table>
        </div>
      </div>
    </div>
  </div>
</div>
<script type="text/html" id="barDemo">
  {{#  if(d.paramName=="启用"){   }}
  <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" title="禁用" lay-event="disable" value="禁用" onclick="produce_yes(this)">禁用</a>
  {{#  } else { }}
  <a class="layui-btn layui-btn-sm layui-btn-xs" lay-event="enabled" title="启用" value="启用" onclick="produce_yes(this)">启用</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
  {{#  } }}
 </script>
</body>

<script>



  layui.use(['form', 'table'], function () {
    var table = layui.table
    var form = layui.form;
    var util = layui.util;
    var laydate = layui.laydate;
    table.render({
      elem: '#costrulesTable'
      , id: 'costrulesTable'
      , url: '/costrules/query'
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
      , cols: [[
        //序号
        , {type: 'numbers', width: '5%', title: '序号', align: 'center'}
        , {field: 'costrulesId', title: '规则编号',hide:true}
        , {field: 'costrulesName', width: '10%',title: '规则名字', align: 'center',hide:false}
        , {field: 'costrulesMin', width: '7%', title: '起始时间', align: 'center'}
        , {field: 'costrulesMax', width: '7%', title: '截止时间', align: 'center'}
        , {field: 'costrulesDescribe', width: '30%', title: '规则描述', align: 'center', edit: true}
        , {field: 'costrulesBasemoney', width: '9%', title: '基础价钱 元/小时', align: 'center', edit: true}
        , {field: 'costrulesAddmoney', width: '9%', title: '增量价钱 元/小时', align: 'center', edit: true}
        , {field: 'paramName', width: '8%', title: '计费状态', align: 'center'}
        , {field: 'right', title: '操作', toolbar: '#barDemo', align: 'center'}
      ]]
      , id: 'testReload'
    })
    table.on('tool(costrulesTable)', function (obj) {
      var data = obj.data;
      if (obj.event === 'edit') {
        layer.confirm('真的要修改该套餐么', function (index) {
          $.ajax({
            url: "/costrules/edit",
            data: {"costrulesId":data.costrulesId,"costrulesDescribe":data.costrulesDescribe,"costrulesBasemoney":data.costrulesBasemoney,"costrulesAddmoney":data.costrulesAddmoney},
            method: 'post',
            dataType: 'text',
            success: function (data) {
              if (data == "编辑成功") {
                layer.msg("编辑成功")
              } else {
                layer.msg("编辑失败")
              }
            }
          })
        });
      }else if (obj.event === 'del') {
        layer.confirm('真的删除行么', function (index) {
          $.ajax({
            url: "/costrules/del",
            data: {'costrulesName': data.costrulesName},
            method: "post",
            dataType: "text",
            success: function (data) {
              if (data == "删除成功") {
                layer.msg("删除成功")
                $("#search").click();
                layer.close(index);
              } else {
                layer.msg("删除失败")
              }
            }
          })
        });
      }
    });

    var $ = layui.$, active = {
      reload: function () {
        var produceStatic = $('#produceStatic');
        var produceName = $('#produceName');
        //执行重载
        table.reload('testReload', {
          page: {
            curr: 1 //重新从第 1 页开始
          }
          , where: {
            key: {
              produceStatic: produceStatic.val(),
              produceName: produceName.val(),
            }
          }
        }, 'data');
      }
    };

    $('.demoTable .layui-btn').on('click', function () {
      var type = $(this).data('type');
      active[type] ? active[type].call(this) : '';
    });
  });

  function produce_yes(obj) {
    layer.confirm('确认要修改状态吗？', function (index) {
      console.log()
      $.ajax({
        url: '/costrules/updstatic',
        dataType:'text',
        method: 'post',
        data: {"costrulesName":$(obj).parent().parent().parent("tr").children("td").eq(2).children("div").text(),
          "costrulesState":$(obj).text(),
        },
        success: function (data) {
          console.log(data)
          if (data == "启用") {
            $("#search").click();
            layer.msg('操作成功!', {icon: 6, time: 1000});
          }else if(data == "禁用"){
            $("#search").click();
            layer.msg('操作成功!', {icon: 6, time: 1000});
          }else {
            layer.msg('操作失败!', {icon: 6, time: 1000});
          }
        }
      })
    });
  }

</script>
</html>