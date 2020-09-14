function findCar() {
    $("#info-div").css('display',"block");
    var path = $("#path").val();
    var carNumber = $("#carNumber").val();
    console.log(carNumber);

    $.ajax({
        url: path + "/car/carOut",
        type: "post",
        data: {
            "carNumber": carNumber,
        },
        dataType: "json",
        beforeSend: function () {
            var flag = verifyLicensePlateNum(carNumber);
            if (flag==false){
                return false;
            }
        },
        success: function (result) {
            $("#nowTime").text(result.endTime);
            $("#money").text(result.money+"元");
            $("#number").text(result.carNumber);
            $("#carPort").text(result.carPort);
            $("#carType").text(result.carType);
            $("#startTime").text(result.startTime);
            $("#endTime").text(result.endTime);
            $("#longTime").text(result.longTime+"分");
        },
        error: function () {
        },
        complete: function () {
        }
    })
}

// 综合处理（普通汽车+新能源）
function verifyLicensePlateNum (value) {
    const express = /^([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[a-zA-Z](([DF]((?![IO])[a-zA-Z0-9](?![IO]))[0-9]{4})|([0-9]{5}[DF]))|[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1})$/;
    const result = express.test(value);
    return result;
}


function Alipay() {

}