<%--
  Created by IntelliJ IDEA.
  User: JC
  Date: 2020/8/11
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js" charset="utf-8"></script>
    <%--    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>--%>
    <%--    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>--%>
    <%--    <script src="${pageContext.request.contextPath}/js/UserReg.js" charset="utf-8"></script>--%>
    <link href="${pageContext.request.contextPath}/css/UserReg.css" rel="stylesheet">
    <%
        String path = request.getContextPath();
    %>
</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
<div class="logDiv">
    <div class="title">注册</div>
    <form action="${pageContext.request.contextPath}/LogReg/regPerson" method="post">
        <table align="center">
            <tr>
                <td><label>用户名：</label></td>
                <td><input type="text" placeholder="请输入用户名" name="personName" id="personName"></td>
            </tr>
            <tr>
                <td><label>账号：</label></td>
                <td><input type="text" placeholder="请输入账号" name="personAccount" id="personAccount"></td>
            </tr>
            <tr>
                <td><label>密码：</label></td>
                <td><input type="password" placeholder="请输入密码" id="password" name="password"></td>
            </tr>
            <tr>
                <td><label>确认密码：</label></td>
                <td><input type="password" placeholder="请确认密码" id="passwords" name="passwords"></td>
            </tr>
            <tr>
                <td><label>车牌号：</label></td>
                <td><input type="text" placeholder="请输入车牌号" id="carNumber" name="carNumber"></td>
            </tr>
            <tr>
                <td><label>性别：</label></td>
                <td><input name="sex" type="radio" value="男">男 &nbsp; &nbsp; <input name="sex" type="radio" value="女">女
                </td>
            </tr>
            <tr>
                <td><label>年龄:</label></td>
                <td><input type="text" placeholder="请输入年龄" id="personAge" name="personAge" required=""
                           lay-verify="personAge"></td>
            </tr>
            <tr>
                <td><label>住址：</label></td>
                <td><input type="text" placeholder="请输入住址" id="address" name="address"></td>
            </tr>
            <tr>
                <td><label>手机号：</label></td>
                <td><input type="text" placeholder="请输入手机号码" id="personPhone" name="personPhone"></td>
            </tr>
            <tr>
                <td><label>验证码：</label></td>
                <td><input type="text" placeholder="输入验证码" id="code" name="code"><a id="getCode">获取验证码</a></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="button" value="注册" onclick="reg(this)"> <input type="button"
                                                                                                           value="返回"
                                                                                                           onclick="back(this)">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
<script type="text/javascript">
    var obj = document.getElementById("getCode");
    var flag = 60;
    obj.onclick = function () {
        if (flag < 60) {
            return;
        }
        var xhr = new XMLHttpRequest();
        xhr.open("get", "/userControl/textMsg?personPhone=" + document.getElementById("personPhone").value, true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
// alert(xhr.responseText);
            }
        }
        xhr.send(null);
        timer();
    }


    // 短信验证
    function reg() {
        // if (flag < 60) {
        //     return;
        // }
        var xhr = new XMLHttpRequest();
        xhr.open("get", "/userControl/textCod?code=" + document.getElementById("code").value, true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                if (xhr.responseText == 0) {
                    alert("执行注册按钮")

                    var path = $("#path").val();
                    var personName = $("#personName").val();//用户名
                    alert(personName)
                    var personAccount = $("#personAccount").val();//账号
                    alert(personAccount)
                    var password = $("#password").val();//密码
                    alert(password)
                    var passwords = $("#passwords").val();//确认密码
                    alert(passwords)
                    var carNumber = $("#carNumber").val();//车牌号
                    alert(carNumber)
                    var sex = $('input[name="sex"]:checked').val();//性别
                    alert(sex)
                    var personAge = $("#personAge").val();//年龄
                    alert(personAge)
                    var personPhone = $("#personPhone").val()//电话
                    alert(personPhone)
                    var address=$("#address").val()//住址
                    var reg = /^[0-9]+$/;
                    var name = /^[\u4e00-\u9fa5]+$/;
                    // var idcard=/^[1-9]\d{5}(18|19|20|(3\d))\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
                    if (personName.length <= 0) {
                        alert("用户名不能为空！")
                    } else if (personAccount == "" || personAccount == null) {
                        alert("账号不能为空")
                    } else if (password == "" || password == null) {
                        alert("密码不能为空！")
                    } else if (passwords == "" || passwords == null) {
                        alert("确认密码不能为空！")
                    } else if (password != passwords) {
                        alert("两次密码不同")
                    } else if (carNumber == "" || carNumber == null) {
                        alert("车牌号不能为空")
                    } else if (sex == "" || sex == null) {
                        alert("性别不能为空!")
                    } else if (personAge == undefined) {
                        alert("年龄不能为空！")
                    }else if(address==null){
                        alert("名字不能为空！")
                    }else if (personPhone.length <= 0) {
                        alert("手机号码不能为空！")
                    } else if (!reg.test(personPhone) || personPhone.length < 11 || personPhone.length > 11) {
                        alert("手机号格式输入错误！")
                    } else {
                        $.ajax({

                            data: "personName=" + personName + "&personAccount=" + personAccount + "&password=" + password + "&carNumber=" + carNumber + "&sex=" + sex + "&personAge=" + personAge + "&personPhone=" + personPhone+"&address="+address,
                            url: path + "/LogReg/regPerson",
                            dataType: "text",
                            type: "Post",
                            success: function (data) {
                                alert(data);
                                if (data == "电话号码已被使用") {
                                    alert("电话号码已被使用！")
                                } else if (data == "注册成功") {
                                    alert("注册成功！")
                                } else if (data == "注册失败") {
                                    alert("注册失败！")
                                }
                            }
                        })
                    }
                } else {
                    alert("验证码错误！")
                }
            }
        }

        xhr.send(null);
    }

    function timer() {
        flag--;
        obj.innerHTML = flag + "秒以后重新获取验证码"
        if (flag == 0) {
            obj.innerHTML = "获取验证码";
            flag = 60;
        } else {
            setTimeout("timer()", 1000);
        }

    }

    function back(node) {
        var path = $("#path").val()
        var c = confirm("确定要返回登录界面吗？")
        if (c == true) {
            location.href = path + "/jsp/UserLogin.jsp"
        }
    }
</script>
</html>
