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

    //选完文件后不自动上传
    var uploadInst = upload.render({
        elem: '#choseFile'
        , url: path + '/car/carIn'
        , auto: true
        , accept: 'images'
        , bindAction: '#upload'
        , choose: function (obj) {
            //将每次选择的文件追加到文件队列
            files = obj.pushFile();
            //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
            obj.preview(function (index, file, result) {
                var name = file.name;//文件名wenjian
                var size = file.size;//文件大小
                console.log(name)
                console.log(size)
            });
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
                console.log(carNumber)

                location.href=path + "/car/carWelcome?carNumber="+carNumber;

            } else {
                layer.msg('识别失败');
            }
            delete files[index]; //删除列表中对应的文件，一般在某个事件中使用
            // uploadInst.reload();//重载
        }
        , error: function (res, index, upload) {
            layer.closeAll('loading'); //关闭loading
            layer.msg('上传失败');
            delete files[index]; //删除列表中对应的文件，一般在某个事件中使用
            // uploadInst.reload();//重载
        }
    });

});
