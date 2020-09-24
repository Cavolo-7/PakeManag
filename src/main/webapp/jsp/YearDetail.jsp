<%--
  Created by IntelliJ IDEA.
  User: 69080
  Date: 2020/9/23
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://www.jq22.com/jquery/echarts-4.2.1.min.js"></script>
<script src="../layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/resources/js/jquery-1.12.4.min.js"></script>
<html>
<head>
  <title>年度统计</title>
</head>
<body>
<div class="layui-card">
  <div class="layui-card-header">年度收入统计 </div>
  <div class="layui-card-body " style="min-height: 280px;">
    <div id="hao" class="layui-col-sm12" style="height: 300px; width: 100%"></div>
  </div>
</div>
</body>
  <script type="text/javascript">

  // 基于准备好的dom，初始化echarts实例
  var myChart = echarts.init(document.getElementById('hao'));
  // 指定图表的配置项和数据
  var option = {
    title: {
      text: '年度收入统计树状图',
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
      data:  ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
      axisTick: {
        alignWithLabel: true
      }
    }],
    yAxis: [{
      type: 'value'
    }],

  };

  $.ajax({
    url:"/settlement/getYearDetail",
    dataType:"json",
    success:function(jsonData){
      myChart.setOption({
        series: [{
          name: '收入',
          data: jsonData.data,
          itemStyle: {
            normal: {
              //好，这里就是重头戏了，定义一个list，然后根据所以取得不同的值，这样就实现了，
              color: function(params) {
                var colorList = [
                  '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                  '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                  '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
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
</script>
</html>
