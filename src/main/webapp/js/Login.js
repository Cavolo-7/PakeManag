function jqAjax() {
    var account = $("#account").val();//获取账号

    var password = $("#password").val();//获取密码

    var path = $("#path").val();
    console.log(account)
    console.log(password)
    if (account.length <= 0) {
        alert("账号输入不能为空！")
    } else if (password.length <= 0) {
        alert("密码输入不能为空！")
    } else {
        $.ajax({
            url: "/user/login",
            type: "Post",
            data: "account=" + account + "&password=" + password,
            dataType: "text",
            success: function (data) {
                if (data == "账号密码错误") {
                    alert("账号密码错误！")
                }else if (data=="账户被禁用"){
                    alert("账户被禁用,请联系管理员");
                }
                else if (data == "登录成功") {
                    alert("登录成功！")
                    location.href = "/user/userMenus";//菜单
                }
            },
            error: function () {
                alert("网络繁忙")
                // changeImg();
            },
        })
    }

}

function Ajax(node) {
        location.href="facesearch.jsp";
}


