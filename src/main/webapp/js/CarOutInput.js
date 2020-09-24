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


//车辆出场手动输入车牌
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

    //1.判断非空（7位，或者8位）
    $.ajax({
            url: "/car/carOut",
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
                //校验车牌
                if (!isCarNumber(carNumber)) {
                    alert("请输入正确的车牌号！");
                    return false;
                }
                $("#submitBtn").prop("disabled", "disabled");//防止数据重复提交
            },
            success: function (result) {
                console.log("res" + result)
                var url = '/jsp/CarOut.jsp?carNumber=' + result.carNumber + '&carPort=' + result.carPort + '&carType=' + result.carType + '&money=' + result.money + '&payState=' + result.payState + '&startTime=' + result.startTime + '&endTime=' + result.endTime + '&longTime=' + result.longTime + '&welcomeMsg=' + result.welcomeMsg+ '&carportId=' + result.carportId;
                xadmin.open('出场缴费', url, 600, 450);
            },
            error: function () {
            },
            complete: function () {
                $("#submitBtn").prop("disabled", false);
            }
        }
    );


}


//校验车牌号
function isCarNumber(str) {
    var flag = /^([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[a-zA-Z](([DF]((?![IO])[a-zA-Z0-9](?![IO]))[0-9]{4})|([0-9]{5}[DF]))|[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1})$/.test(str);
    return flag;
}