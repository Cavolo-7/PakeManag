function jqAjax() {

    var personAccount = $("#personAccount").val();//获取账号

    var personPassword = $("#personPassword").val();//获取密码

    var vCode = $("#vCode").val();//获取验证码

    // var reg = /^[0-9]+$/;//正则表达式
    var  person = {"personAccount": personAccount, "personPassword": personPassword};
    var path = $("#path").val();
    if (personAccount.length <= 0) {
        alert("账号输入不能为空！")
    } else if (personPassword.length <= 0) {
        alert("密码输入不能为空！")
    } else {
        $.ajax({
            url: path + "/LogReg/loginPerson",
            type: "Post",
            data: "personAccount=" + personAccount + "&personPassword=" + personPassword + "&vCode=" + vCode,
            dataType: "text",
            success: function (data) {
                if (data == "验证码错误") {
                    alert("验证码错误！")
                    changeImg()
                } else if (data == "账号密码错误") {
                    alert("账号密码错误！")
                    changeImg();
                } else if (data == "登录成功") {
                    alert("登录成功！")
                    // location.href = "/" ;
                }
            },
            error: function () {
                alert("网络繁忙")
                changeImg();
            },
        })
    }

}

function changeImg() {

    var path = $("#path").val();//获取路径
    $("#vCodeImg").attr("src",path+"/verifyCodeServlet?date="+new Date());
}

function fhui(node) {
    var path = $("#path").val()
    var c = confirm("确定要返回吗？")
    if (c == true) {
        location.href = path + "/jsp/Massing.jsp"
    }
}


function updateUser(node) {
    var path=$("#path").val()
    var userId=$("#userId").val()
    var password=$("#password").val()
    var sex=$("#sex").val()
    var userTel=$("#userTel").val()
    var email=$("#email").val()
    $.ajax({
        url: path + "/userIf/updateUserx",
        data: {userId:userId, password:password,sex:sex,userTel:userTel,email:email},
        success: function (data) {
            if (data == "修改成功") {
                alert("修改成功！")
            } else if (data=="修改失败"){
               alert("修改失败！")
            }
        },
        end:function () {
            $("#searchUserifAccount").click()
        }
    })
}