$(function () {
    $("#tc").click(function () {
        var f=confirm("确定要退出系统");
        if (f==true){
            var path=$("#path").val();
            location.href=path+"/quitServlet?methodName=quit";
        }
    })
});