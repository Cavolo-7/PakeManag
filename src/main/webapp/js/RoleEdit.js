layui.use(['layer', 'tree', 'util'], function () {
    $ = layui.jquery;
    layer = layui.layer;
    var tree = layui.tree;
    var path = $("#path").val();
    var roleId = $("#roleId").val();
    $.ajax({
            url: path + "/root/rootAllot",
            type: "post",
            data: {"roleId": roleId},
            dataType: "json",
            beforeSend: function () {
            },
            success: function (result) {
                //渲染树
                tree.render({
                    elem: '#roleTree'
                    , data: [result] //数据源
                    , showCheckbox: true //显示复选框
                    , id: 'roleTree' //定义索引
                });
            },
            error: function () {
            },
            complete: function () {
            }
        });

    $("#update").on("click", function () {
        //获得选中的节点
        var checkData = tree.getChecked('roleTree');
        var checkData = JSON.stringify(checkData[0]);

        console.log(checkData)
        $.ajax({
                url: path + "/root/updateMenu",
                type: "post",
                data: {
                    "checkData": checkData,
                    "roleId": roleId,
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
            }
        );
    })


    $("#cancel").on("click", function () {
        tree.reload('roleTree');
    })

});