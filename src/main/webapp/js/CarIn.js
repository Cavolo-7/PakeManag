layui.use(['upload'], function () {
    var $ = layui.jquery
        , upload = layui.upload;

    //车辆入场扫描车牌
    upload.render({
        elem: '#choseFile'
        , url: '/car/findCarNumber'
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
                var carNumber = arr[1];//车牌号
                var photoPath = arr[2];//车牌照片
                carInFindSuccess(carNumber, photoPath);//车牌识别成功
            } else if (res.msg == 'repeat') {
                layer.msg('该车辆已经停在停车场！');
            } else if (res.msg == 'full') {
                layer.msg('停车场车位已满！');
            } else {
                openInput();//车牌识别失败 手动输入车牌
                layer.msg('识别失败,请手动输入车牌号！');
            }
        }
        , error: function (res, index, upload) {
            layer.closeAll('loading'); //关闭loading
            layer.msg('上传失败！');
        }
    });


    //车辆出场扫描车牌
    upload.render({
        elem: '#choseOutFile'
        , url: '/car/findCarNumberOut'
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
                var carNumber = arr[1];//车牌号
                carOutFindSuccess(carNumber);//车牌识别成功
            } else if (res.msg == 'nocar') {
                layer.msg('该车辆不在停车场！');
            } else {
                openOutInput();//识别失败手动输入车牌
                layer.msg('抱歉识别失败,请手动输入车牌号');
            }
        }
        , error: function (res, index, upload) {
            layer.closeAll('loading'); //关闭loading
            layer.msg('上传失败');
        }
    });
});


//打开入场输入弹窗层
function openInput() {
    xadmin.open('输入车牌号', '/jsp/CarNumberInput.jsp', 600, 450);
}


//打开出场输入弹窗层
function openOutInput() {
    xadmin.open('输入车牌号', '/jsp/CarOutInput.jsp', 600, 450);
}


//车辆入场识别成功
function carInFindSuccess(carNumber, photoPath) {
    $.ajax({
            url: "/car/carIn",
            type: "post",
            data: {
                'carNumber': carNumber,
                'photoPath': photoPath,
            },
            dataType: "json",
            beforeSend: function () {
            },
            success: function (result) {
                console.log(result)
                var url = '/jsp/OpenCarIn.jsp?carNumber=' + result.carNumber + '&carPort=' + result.carPort + '&carType=' + result.carType + '&money=' + result.money + '&startTime=' + result.startTime + '&welcomeMsg=' + result.welcomeMsg;
                xadmin.open('车辆入场', url, 600, 450);
            },
            error: function () {
            },
            complete: function () {
            }
        }
    );
}


//车辆出场识别成功
function carOutFindSuccess(carNumber) {
    $.ajax({
            url: "/car/carOut",
            type: "post",
            data: {
                'carNumber': carNumber
            },
            dataType: "json",
            beforeSend: function () {
            },
            success: function (result) {
                console.log(result)
                var url = '/jsp/CarOut.jsp?carNumber=' + result.carNumber + '&carPort=' + result.carPort + '&carType=' + result.carType + '&money=' + result.money + '&payState=' + result.payState + '&startTime=' + result.startTime + '&endTime=' + result.endTime + '&longTime=' + result.longTime + '&welcomeMsg=' + result.welcomeMsg + '&carportId=' + result.carportId;
                xadmin.open('出场缴费', url, 600, 450);
            },
            error: function () {
            },
            complete: function () {
            }
        }
    );
}




