//车辆出场现金支付
function pay() {
    var path = $("#path").val();
    var payMoney = $("#payMoney").val();//支付金额
    var money = $("#money").val();//应付金额
    var carNumber = $("#carNumber").val();//车牌号
    var carportId = $("#carportId").val();//车牌号
    $.ajax({
            url: path + "/car/payMoney",
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
                    top.location.href = path + '/car/noCarWelcome'//刷新主页
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


//支付宝支付
function Alipy() {
    var path = $("#path").val();
    var total_amount = $("#money").val();
    var subject = $("#carNumber").val();
    var body = $("#carportId").val();
    xadmin.close();
    top.location.href = path + "/car/carOutAlipay?total_amount=" + total_amount + "&subject=" + subject + "&body" + body;
    console.log("alipy")
}

//确定按钮
function sure() {
    var path = $("#path").val();
    xadmin.close();
    top.location.href = path + '/car/noCarWelcome'//刷新主页
}