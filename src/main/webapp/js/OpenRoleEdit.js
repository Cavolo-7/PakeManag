layui.use(['layer', 'tree', 'util'], function () {
    $ = layui.jquery;
    layer = layui.layer;
    var tree = layui.tree;
    var path = $("#path").val();
    var value = $("#value").val();

    $.ajax({
            url: path + "/root/rootAllot",
            type: "post",
            data: {
                "value": value,
            },
            dataType: "json",
            beforeSend: function () {
            },
            success: function (result) {
                console.log(result)
                tree.render({
                    elem: '#roleTree'
                    , data: [result]
                    , showCheckbox: true
                    , id: 'roleTree'
                })
            },
            error: function () {
            },
            complete: function () {
            }
        }
    );

    $("#update").on("click", function () {
        layer.confirm('确定要修改嘛？', function (index) {
                layer.close(index);//关闭(confirm)
                var data = tree.getChecked('roleTree');//获得选中的节点
                console.log("data："+data)
                var checkData;
                if (data != null) {
                    checkData = JSON.stringify(data[0]);
                }

                $.ajax({
                    url: path + "/root/updateMenu",
                    type: "post",
                    data: {
                        "checkData": checkData,
                        "value": value,
                    },
                    dataType: "text",
                    beforeSend: function () {
                    },
                    success: function (result) {
                        if (result == "success") {
                            alert("修改成功！")
                        } else {
                            alert("修改失败！")
                        }
                    },
                    error: function () {
                    },
                    complete: function () {
                    }
                });
            }
        )
    })


    $("#cancel").on("click", function () {
        layer.confirm('您将取消修改，是否确定？', function (index) {
            layer.close(index);//关闭特定层(confirm)
            $.ajax({
                    url: path + "/root/rootAllot",
                    type: "post",
                    data: {
                        "value": value,
                    },
                    dataType: "json",
                    beforeSend: function () {
                    },
                    success: function (result) {
                        console.log(result)
                        tree.render({
                            elem: '#roleTree'
                            , data: [result]
                            , showCheckbox: true
                            , id: 'roleTree'
                        })
                    },
                    error: function () {
                    },
                    complete: function () {
                    }
                }
            );
        })
    })

});