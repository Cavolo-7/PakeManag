window.onload = function () {
    setInterval(function () {
        var date = new Date();
        var year = date.getFullYear(); //获取当前年份
        var mon = date.getMonth() + 1; //获取当前月份
        var da = date.getDate(); //获取当前日
        var day = date.getDay(); //获取当前星期几
        var h = date.getHours(); //获取小时
        var m = date.getMinutes(); //获取分钟
        var s = date.getSeconds(); //获取秒
        var d = document.getElementById('Date');
        d.innerHTML = year + '年' + mon + '月' + da + '日' + '星期' + day + ' ' + h + ':' + m + ':' + s;
    }, 1000);
}


layui.use(['upload'], function () {
    var $ = layui.jquery
        , upload = layui.upload;
    var path = $("#path").val();
    var files;

    upload.render({
        elem: '#choseFile'
        , url: path + '/car/carIn'
        , auto: true
        , accept: 'images'
        , bindAction: '#upload'
        , choose: function (obj) {
        }
        , before: function () {
            layer.load(); //上传loading
        }
        , done: function (res, index, upload) {
            layer.closeAll('loading'); //关闭loading
            if (res.msg.indexOf('success') != -1) {
                layer.msg('识别成功');
                var arr = res.msg.split("&");
                var carNumber = arr[1];
                location.href = path + "/car/carWelcome?carNumber=" + carNumber;//车入场信息
            } else {
                openInput();
                layer.msg('抱歉识别失败,请手动输入车牌号');
            }
        }
        , error: function (res, index, upload) {
            layer.closeAll('loading'); //关闭loading
            layer.msg('上传失败');
        }
    });


    //选完文件后不自动上传
    upload.render({
        elem: '#choseOutFile'
        , url: path + '/car/carOut'
        , auto: true
        , accept: 'images'
        , bindAction: '#upload'
        , choose: function (obj) {
        }
        , before: function () {
            layer.load(); //上传loading
        }
        , done: function (res, index, upload) {
            layer.closeAll('loading'); //关闭loading
            if (res.msg.indexOf('success') != -1) {
                layer.msg('识别成功');
                var arr = res.msg.split("&");
                var money = arr[1];
                var minute = arr[2];
                var carNumber = arr[3];
                xadmin.open('出场缴费', path + '/jsp/CarOut.jsp?money=' + money + "&minute=" + minute + "&carNumber=" + carNumber, 600, 400);//打开编辑弹出层并传参数
            } else {
                openInput();
                layer.msg('抱歉识别失败,请手动输入车牌号');
            }
        }
        , error: function (res, index, upload) {
            layer.closeAll('loading'); //关闭loading
            layer.msg('上传失败');
        }
    });
});

function openInput() {
    var path = $("#path").val();
    xadmin.open('输入车牌号', path + '/jsp/CarNumberInput.jsp', 600, 400);//打开编辑弹出层并传参数
}



