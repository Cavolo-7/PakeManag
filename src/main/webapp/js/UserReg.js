
function back(node) {
    var path=$("#path").val()
    var c=confirm("确定要返回登录界面吗？")
    if (c==true){
        location.href=path+"/jsp/UserLogin.jsp"
    }
}

function reg(node) {

    alert("执行注册按钮")

    var path=$("#path").val();

    var personName=$("#personName").val();//用户名

    var personAccount=$("#personAccount").val();//账号

    var password=$("#password").val();//密码

    var passwords=$("#passwords").val();//确认密码

    var carNumber=$("#carNumber").val();//车牌号

    var sex=$('input[name="sex"]:checked').val();//性别

    var personAge=$("#personAge").val();//年龄

    var personPhone=$("#personPhone").val()//电话

    var reg=/^[0-9]+$/;
    var name=/^[\u4e00-\u9fa5]+$/;
    // var idcard=/^[1-9]\d{5}(18|19|20|(3\d))\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
    if(personName.length<=0){
        alert("用户名不能为空！")
    } else if (personAccount==""||personAccount==null){
        alert("账号不能为空")
    }else if (password==""||password==null){
        alert("密码不能为空！")
    }else if (passwords==""||passwords==null){
        alert("确认密码不能为空！")
    }else if (password!=passwords){
        alert("两次密码不同")
    }else if (carNumber==""||carNumber==null){
        alert("车牌号不能为空")
    }else if (sex==""||sex==null){
        alert("性别不能为空!")
    }else if (personAge==undefined){
        alert("年龄不能为空！")
    }else if (personPhone.length<=0){
        alert("手机号码不能为空！")
    } else if (!reg.test(personPhone)||personPhone.length<11||personPhone.length>11){
        alert("手机号格式输入错误！")
    }else {
        $.ajax({

            data:"personName="+personName+"&personAccount="+personAccount+"&password="+password+"&carNumber="+carNumber+"&sex="+sex+"&personAge="+personAge+"&personPhone="+personPhone,
            url: path + "/LogReg/regPerson",
            dataType: "text",
            type: "Post",
            success: function (data) {
                alert(data);
                if (data=="电话号码已被使用"){
                    alert("电话号码已被使用！")
                }else if (data=="注册成功"){
                    alert("注册成功！")
                }else if (data=="注册失败"){
                    alert("注册失败！")
                }
            }
        })
    }

}