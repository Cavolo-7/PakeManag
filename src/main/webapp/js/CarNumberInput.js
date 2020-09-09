layui.use(['layer', 'form'], function () {

    var $ = layui.jquery
        , layer = layui.layer
        , form = layui.form;

    $('.car_input li').on('click', function () {
        document.activeElement.blur();  // 阻止弹出系统软键盘
        var _cliss = $(this).attr("class");
        var _sort = $(this).data("sort");

        $(this).addClass("input_zim").siblings().removeClass("input_zim");

        if (_sort == 1) {
            $('body').keyboard({
                defaults: 'symbol',    //键盘显示类型   English 字母  number 数字  symbol 符号
                inputClass: _cliss,        //输入框Class
            });
        } else {
            $('body').keyboard({
                defaults: 'English',    //键盘显示类型   English 字母  number 数字  symbol 符号
                inputClass: _cliss,        //输入框Class
            });
        }
    });

    $(document).on("click", '#keyboard .keyContent li', function (event) {

        $(".input_zim span").html($(this).text());
        var _sort = $(".input_zim").data("sort") + 1;
        if (_sort == 2) {
            $('body').keyboard({
                defaults: 'English',    //键盘显示类型   English 字母  number 数字  symbol 符号
            });
        }
        $("#cp" + _sort).addClass("input_zim").siblings().removeClass("input_zim");
    });

    $(document).on("click", '.del', function (event) {
        $(".input_zim span").text('');
        var _sort = $(".input_zim").data("sort") - 1;
        $("#cp" + _sort).addClass("input_zim").siblings().removeClass("input_zim");
    });

    $(document).on("click", '.xinneng', function (event) {
        $(".xinneng").remove();
        $("#cp8").show();
    });

});


function carInSubmit() {
    var carNum1 = $("#cp1").text();
    var carNum2 = $("#cp2").text();
    var carNum3 = $("#cp3").text();
    var carNum4 = $("#cp4").text();
    var carNum5 = $("#cp5").text();
    var carNum6 = $("#cp6").text();
    var carNum7 = $("#cp7").text();
    var carNum8 = $("#cp8").text();
    var carNumber = "";
    if (carNum1 != '' && carNum2 != '' && carNum3 != '' && carNum4 != '' && carNum5 != '' && carNum6 != '' && carNum7 != '' && carNum8 == '') {
        carNumber = carNum1 + carNum2 + carNum3 + carNum4 + carNum5 + carNum6 + carNum7;
        console.log(7)
        console.log(carNumber)

    }
    if (carNum1 != '' && carNum2 != '' && carNum3 != '' && carNum4 != '' && carNum5 != '' && carNum6 != '' && carNum7 != '' && carNum8 != '') {
        carNumber = carNum1 + carNum2 + carNum3 + carNum4 + carNum5 + carNum6 + carNum7 + carNum8;
        console.log(8)
        console.log(carNumber)
    }
    var path = $("#path").val();
    //1.判断非空（7位，或者8位）
    $.ajax({
            url: path + "/car/inputCarIn",
            type: "post",
            data: {
                "carNumber": carNumber,
            },
            dataType: "json",
            beforeSend: function () {
                if (carNum1 == '' || carNum2 == '' || carNum3 == '' || carNum4 == '' || carNum5 == '' || carNum6 == '' || carNum7 == '') {
                    alert("请输入正确的车牌号！")
                    return false;
                }
            },
            success: function (result) {
                console.log(result)
                xadmin.close();//关闭当前弹窗
                if (result.msg.indexOf('success') != -1) {
                    alert("车辆入场")
                    parent.location.href = path + "/car/carWelcome?carNumber=" + carNumber;//车入场信息
                } else {
                    alert("入场失败")
                }
            },
            error: function () {
            },
            complete: function () {
            }
        }
    );


}