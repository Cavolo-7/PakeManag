function findCar() {

    var path = $("#path").val();
    var carNumber = $("#carNumber").val();
    console.log(carNumber);

    $.ajax({
        url: path + "/car/findCarPayInfo",
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
        },
        success: function (result) {
            console.log(result)
            $("#nowTime").text(result.endTime);
            $("#money").text(result.money + "元");
            $("#number").text(result.carNumber);
            $("#carPort").text(result.carPort);
            $("#carType").text(result.carType);
            $("#startTime").text(result.startTime);
            $("#endTime").text(result.endTime);
            $("#longTime").text(result.longTime + "分");
            $("#payState").text(result.payState);

            $("#info-div").css('display', "block");

            $("#total_amount").val(result.money);
            $("#subject").val(result.carNumber);
            $("#body").val(result.carportId);
            $("#State").val(result.payState);
        },
        error: function () {
        },
        complete: function () {
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
    var path = $("#path").val();
    var total_amount = $("#total_amount").val();
    var subject = $("#subject").val();
    var body = $("#body").val();
    if (total_amount==0){
        alert("无需支付！")
        return;
    }else{
        location.href = path + "/car/Alipay?total_amount=" + total_amount + "&subject=" + subject + "&body" + body;
    }

}