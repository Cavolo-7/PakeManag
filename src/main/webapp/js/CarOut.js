//确定按钮---月缴用户，白名单用户,自助缴费未超时,无需支付
function sure() {
    var carNumber = $("#carNumber").val();//车牌号
    var carportId = $("#carportId").val();//车位id
    $.ajax({
            url: "/car/carOutNoPay",
            type: "post",
            data: {
                "carNumber": carNumber,
                "carportId": carportId,
            },
            dataType: "text",
            beforeSend: function () {
            },
            success: function (result) {
                console.log(result)
                if (result == "success") {
                    alert("出场成功！")
                    xadmin.close();//关闭弹窗
                    top.location.href = '/car/noCarWelcome'//刷新主页
                } else {
                    alert("出场失败！")
                }
            },
            error: function () {
            },
            complete: function () {
            }
        }
    );
}


//确定按钮---临时车辆不满半小时,金额为 0
function zeroMoney() {
    var carNumber = $("#carNumber").val();//车牌号
    var carportId = $("#carportId").val();//车位id
    $.ajax({
            url: "/car/carOutNoPay",
            type: "post",
            data: {
                "carNumber": carNumber,
                "carportId": carportId,
            },
            dataType: "text",
            beforeSend: function () {
            },
            success: function (result) {
                console.log(result)
                if (result == "success") {
                    alert("出场成功！")
                    xadmin.close();//关闭弹窗
                    top.location.href = '/car/noCarWelcome'//刷新主页
                } else {
                    alert("出场失败！")
                }
            },
            error: function () {
            },
            complete: function () {
            }
        }
    );
}


//车辆出场现金支付
function pay() {
    var payMoney = $("#payMoney").val();//支付金额
    var money = $("#money").val();//应付金额
    var carNumber = $("#carNumber").val();//车牌号
    var carportId = $("#carportId").val();//车牌号
    $.ajax({
            url: "/car/payMoney",
            type: "post",
            data: {
                "payMoney": payMoney,
                "money": money,
                "carNumber": carNumber,
                "carportId": carportId,
            },
            dataType: "text",
            beforeSend: function () {
                if (payMoney != money) {
                    alert("支付金额应等于停车费用！")
                    return false;
                }
            },
            success: function (result) {
                console.log(result)
                if (result == "success") {
                    alert("支付成功！")
                    xadmin.close();//关闭弹窗
                    top.location.href = '/car/noCarWelcome'//刷新主页
                } else {
                    alert("支付失败！")
                }
            },
            error: function () {
            },
            complete: function () {
            }
        }
    );
}


//车辆出场支付宝支付
function Alipy() {
    var total_amount = $("#money").val();
    var subject = $("#carNumber").val();
    var body = $("#carportId").val();
    xadmin.close();
    top.location.href = "/car/carOutAlipay?total_amount=" + total_amount + "&subject=" + subject + "&body" + body;
    console.log("alipy")
}


