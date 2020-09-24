<%--
  Created by IntelliJ IDEA.
  User: 69080
  Date: 2020/9/10
  Time: 0:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
  <meta charset="UTF-8">
  <title>收支明细</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
  <link rel="stylesheet" href="../css/font.css">
  <link rel="stylesheet" href="../css/xadmin.css">
  <script type="text/javascript" src="../js/xadmin.js"></script>
  <script src="https://www.jq22.com/jquery/echarts-4.2.1.min.js"></script>
  <script src="../layui/layui.js" charset="utf-8"></script>
  <script type="text/javascript" src="/resources/js/jquery-1.12.4.min.js"></script>

</head>
<body>
<div class="layui-fluid">
  <div class="layui-row layui-col-space15">

    <div class="layui-col-md12 layui-col-md6" style="width: 50%">
      <div class="layui-card">
        <div class="layui-card-header">临时用户和月缴用户 </div>
        <div class="layui-card-body " style="min-height: 280px;">
          <div id="hao" class="layui-col-sm12" style="height: 300px; width: 100%"></div>
<%--          <table class="layui-hide" id="firstTable" lay-filter="firstTable"></table>--%>
        </div>
      </div>
    </div>

    <div class="layui-col-md12 layui-col-md6" style="width: 50%">
      <div class="layui-card">
        <div class="layui-card-header">月缴用户不同产品包 </div>
        <div class="layui-card-body " style="min-height: 280px;min-width: 50px">
          <div id="wei" class="layui-col-sm12" style="height: 300px; width: 100%"></div>
        </div>
      </div>
    </div>

    <div class="layui-col-md12 layui-col-md6" style="width: 50%">
      <div class="layui-card">
        <div class="layui-card-header">自助缴费 </div>
        <div class="layui-card-body " style="min-height: 280px;min-width: 50px">
          <div id="zhu" class="layui-col-sm12" style="height: 300px; width: 100%"></div>
        </div>
      </div>
    </div>

    <div class="layui-col-md12 layui-col-md6" style="width: 50%">
      <div class="layui-card">
        <div class="layui-card-header">总收入、停放总车次 </div>
        <div class="layui-card-body " style="min-height: 280px;min-width: 50px">
          <div id="zon" class="layui-col-sm12" style="height: 300px; width: 100%"></div>
        </div>
      </div>
    </div>

  </div>
</div>
</div>

<%--<script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>--%>
<script type="text/javascript">

  // 基于准备好的dom，初始化echarts实例
  var myChart = echarts.init(document.getElementById('hao'));
  // 指定图表的配置项和数据
  var option = {
    title: {
      text: '临时用户和月缴用户收入统计树状图',
      subtext: '真实数据',
      x: 'center'
    },

    tooltip: {
      trigger: 'axis',
      axisPointer: { // 坐标轴指示器，坐标轴触发有效
        type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
      }
    },
    grid: {
      left: '3%',
      right: '4%',
      bottom: '3%',
      containLabel: true
    },
    xAxis: [{
      type: 'category',
      data: ['临时用户', '月缴用户'],
      axisTick: {
        alignWithLabel: true
      }
    }],
    yAxis: [{
      type: 'value'
    }],

  };

  $.ajax({
    url:"/detail/first",
    dataType:"json",
    success:function(jsonData){
      myChart.setOption({
        series: [{
          name: '发布量',
          data: jsonData.data,
          itemStyle: {
            normal: {
              //好，这里就是重头戏了，定义一个list，然后根据所以取得不同的值，这样就实现了，
              color: function(params) {
                var colorList = [
                  '#00a15c','#4169e1'
                ];
                return colorList[params.dataIndex]
              },
              //以下为是否显示，显示位置和显示格式的设置了
              label: {
                show: true,
                position: 'top',
                formatter: '{c}\n{b}'
              }
            }
          },
          type: 'bar',
          barWidth: '50%',
        }]
      });
      // 设置加载等待隐
      myChart.hideLoading();
    }
  });
  // 使用刚指定的配置项和数据显示图表。
  myChart.setOption(option);

  // 基于准备好的dom，初始化echarts实例
  var myChartView = echarts.init(document.getElementById('zhu'));
  // 指定图表的配置项和数据
  var option = {
    title: {
      text: '自助缴费收入统计树状图',
      subtext: '真实数据',
      x: 'center'
    },

    tooltip: {
      trigger: 'axis',
      axisPointer: { // 坐标轴指示器，坐标轴触发有效
        type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
      }
    },
    grid: {
      left: '3%',
      right: '4%',
      bottom: '3%',
      containLabel: true
    },
    xAxis: [{
      type: 'category',
      data: ['自助缴费'],
      axisTick: {
        alignWithLabel: true
      }
    }],
    yAxis: [{
      type: 'value'
    }],

  };

  $.ajax({
    url:"/detail/third",
    dataType:"json",
    success:function(jsonData){
      myChartView.setOption({
        series: [{
          name: '发布量',
          data: jsonData.data,
          itemStyle: {
            normal: {
              //好，这里就是重头戏了，定义一个list，然后根据所以取得不同的值，这样就实现了，
              color: function(params) {
                var colorList = [
                  '#00a15c'
                ];
                return colorList[params.dataIndex]
              },
              //以下为是否显示，显示位置和显示格式的设置了
              label: {
                show: true,
                position: 'top',
                formatter: '{c}\n{b}'
              }
            }
          },
          type: 'bar',
          barWidth: '50%',
        }]
      });
      // 设置加载等待隐
      myChartView.hideLoading();
    }
  });
  // 使用刚指定的配置项和数据显示图表。
  myChartView.setOption(option);


  // 基于准备好的dom，初始化echarts实例
  var myChartViews = echarts.init(document.getElementById('zon'));
  // 指定图表的配置项和数据
  var option = {
    title: {
      text: '总收入、停放总车次统计树状图',
      subtext: '真实数据',
      x: 'center'
    },

    tooltip: {
      trigger: 'axis',
      axisPointer: { // 坐标轴指示器，坐标轴触发有效
        type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
      }
    },
    grid: {
      left: '3%',
      right: '4%',
      bottom: '3%',
      containLabel: true
    },
    xAxis: [{
      type: 'category',
      data: ['总收入','总停车辆'],
      axisTick: {
        alignWithLabel: true
      }
    }],
    yAxis: [{
      type: 'value'
    }],

  };

  $.ajax({
    url:"/detail/fourth",
    dataType:"json",
    success:function(jsonData){
      myChartViews.setOption({
        series: [{
          name: '发布量',
          data: jsonData.data,
          itemStyle: {
            normal: {
              //好，这里就是重头戏了，定义一个list，然后根据所以取得不同的值，这样就实现了，
              color: function(params) {
                var colorList = [
                  '#00a15c','#4169e1'
                ];
                return colorList[params.dataIndex]
              },
              //以下为是否显示，显示位置和显示格式的设置了
              label: {
                show: true,
                position: 'top',
                formatter: '{c}\n{b}'
              }
            }
          },
          type: 'bar',
          barWidth: '50%',
        }]
      });
      // 设置加载等待隐
      myChartView.hideLoading();
    }
  });
  // 使用刚指定的配置项和数据显示图表。
  myChartViews.setOption(option);

  $(function () {
    getData4();
  });
  function  getData4() {
    $.ajax({
      type: 'post',
      dataType: 'text',
      url: '/detail/second',
      data: {},
      cache: false,
      async: true,
      success: function (data) {
        console.log(data)
        var data = eval('(' + data + ')');
        var data1 = new Array();
        var data2 = new Array();
        for (var i = 0; i < data.mapName.length; i++) {
          data1[i] = {value: data.mapValue[i], name: data.mapName[i]}
        }
        for (var i = 0; i < data.mapName.length; i++) {
          data2[i] = {name: data.mapName[i]}
        }
        var myCharts = echarts.init(document.getElementById('wei'));

        // 指定图表的配置项和数据
        option = {
          title: {
            text: '不同产品包的收入',
            x: 'center'
          },
          tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
          },
          legend: {
            orient: 'vertical',
            left: 'left',
            data: data2
          },
          series: [
            {
              name: '产品包',
              type: 'pie',
              radius: '55%',
              center: ['50%', '60%'],
              data: data1,
              itemStyle: {
                emphasis: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
              }
            }
          ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myCharts.setOption(option);
      }
    });
  }
</script>
</body>
</html>
