//查找车辆信息
function findCar() {
    var carNumber = $("#carNumber").val();
    console.log(carNumber);
    $.ajax({
        url:  "/car/findCarPayInfo",
        type: "post",
        data: {
            "carNumber": carNumber,
        },
        dataType: "json",
        beforeSend: function () {
            var flag = verifyLicensePlateNum(carNumber);
            if (flag == false) {
                alert("车牌号输入错误，请重新输入！");
                return false;
            }
            $("#search").prop("disabled", "disabled");//防止数据重复提交
        },
        success: function (result) {
            console.log(result)
            $("#nowTime").text(result.endTime);//结算时间
            $("#money").text(result.money + "元");//结算金额
            $("#number").text(result.carNumber);//车牌号
            $("#carPort").text(result.carPort);//车位
            $("#carType").text(result.carType);//停车类型
            $("#startTime").text(result.startTime);//停车时间
            $("#endTime").text(result.endTime);//结束时间
            $("#longTime").text(result.longTime + "分");//停车时长
            $("#payState").text(result.payState);//支付状态

            $("#info-div").css('display', "block");//结算信息可见

            $("#total_amount").val(result.money);
            $("#subject").val(result.carNumber);
            $("#body").val(result.carportId);
            $("#State").val(result.payState);
        },
        error: function () {
        },
        complete: function () {
            $("#search").prop("disabled", false);
        }
    })
}

// 综合处理（普通汽车+新能源）
function verifyLicensePlateNum(value) {
    const express = /^([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[a-zA-Z](([DF]((?![IO])[a-zA-Z0-9](?![IO]))[0-9]{4})|([0-9]{5}[DF]))|[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1})$/;
    const result = express.test(value);
    return result;
}

//支付宝支付
function Alipay() {
    var total_amount = $("#total_amount").val();//订单金额
    if (total_amount == 0) {
        alert("半小时内免费，您无需进行支付！")
    } else {
        var subject = $("#subject").val();//订单标题
        var body = $("#body").val();//订单简介
        location.href = "/car/Alipay?total_amount=" + total_amount + "&subject=" + subject + "&body" + body;
    }
}