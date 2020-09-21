//广告轮播图
layui.use('carousel', function () {
    var carousel = layui.carousel;
    //建造实例
    var ins = carousel.render({
        elem: '#test1'
        , width: '100%' //设置容器宽度
        , arrow: 'always' //始终显示箭头
        , autoplay: true
        , interval: 3000
    });

    var img = '';
    //请求后台广告位数据
    $.ajax({
        url: "/advertise/findAdvertiseList",
        type: "post",
        data: {},
        dataType: "json",
        beforeSend: function () {
        },
        success: function (result) {
            console.log(result);
            //遍历广告列表
            for (var i = 0; i < result.length; i++) {
                img += '<img src="..' + result[i].advertiseImg + '">';
            }
            console.log(img)
            $("#picture").html(img);//添加广告图片
            ins.reload('#test1');//重载轮播图
        },
        error: function () {
        },
        complete: function () {
        }
    })
});


