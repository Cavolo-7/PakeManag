//车辆出场现金支付
function payMoney() {
    var path = $("#path").val();
    var payMoney = $("#payMoney").val();//支付金额
    var money = $("#money").val();//应付金额
    var carNumber = $("#carNumber").val();//车牌号
    console.log(payMoeny + "," + money + "," + carNumber);

    $.ajax({
            url: path + "/car/payMoney",
            type: "post",
            data: {
                "payMoney": payMoney,
                "money": money,
                "carNumber": carNumber
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
                } else {
                    alert("支付失败！")
                }
                xadmin.close();//关闭当前弹窗
            },
            error: function () {
            },
            complete: function () {
            }
        }
    );
}