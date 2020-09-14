layui.use(['upload'], function () {
    var $ = layui.jquery
        , upload = layui.upload;
    var path = $("#path").val();

    upload.render({
        elem: '#choseFile'
        , url: path + '/car/findCarNumber'
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
                var photoPath = arr[2];
                carInFindSuccess(carNumber, photoPath);
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


    //车辆出场车牌识别
    upload.render({
        elem: '#choseOutFile'
        , url: path + '/car/findCarNumber'
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
                carOutFindSuccess(carNumber);
            } else {
                openOutInput();
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
    var path = $("#path").val();
    xadmin.open('输入车牌号', path + '/jsp/CarNumberInput.jsp', 600, 450);
}

//打开出场输入弹窗层
function openOutInput() {
    var path = $("#path").val();
    xadmin.open('输入车牌号', path + '/jsp/CarOutInput.jsp', 600, 450);
}


//车辆入场识别成功
function carInFindSuccess(carNumber, photoPath) {
    var path = $("#path").val();
    $.ajax({
            url: path + "/car/carIn",
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
                var url = path + '/jsp/CarOut.jsp?carNumber=' + result.carNumber + '&carPort=' + result.carPort + '&carType=' + result.carType + '&money=' + result.money + '&startTime=' + result.startTime + '&welcomeMsg=' + result.welcomeMsg;
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
    var path = $("#path").val();
    $.ajax({
            url: path + "/car/carOut",
            type: "post",
            data: {
                'carNumber': carNumber
            },
            dataType: "json",
            beforeSend: function () {
            },
            success: function (result) {
                console.log(result)
                if (result.carNumber != null) {
                    var url = path + '/jsp/CarOut.jsp?carNumber=' + result.carNumber + '&carPort=' + result.carPort + '&carType=' + result.carType + '&money=' + result.money + '&payState=' + result.payState + '&startTime=' + result.startTime + '&endTime=' + result.endTime + '&longTime=' + result.longTime + '&welcomeMsg=' + result.welcomeMsg+ '&carportId=' + result.carportId;
                    xadmin.open('出场缴费', url, 600, 450);
                } else {
                    layer.msg('该车辆不在此停车场！');
                }
            },
            error: function () {
            },
            complete: function () {
            }
        }
    );
}




