﻿$(function () {
    getMenus();

    $("#treeDemo").on("click", ".addBtn", function () {
        // 将当前节点的 id ,作为新节点的 pid 保存到全局变量中
        window.pid = this.id;

        // 打开模态框
        $("#menuAddModal").modal("show");
        // layer.msg("Here:" + this.id);
    })
});

function getMenus() {
    // 1. 准备生成树形结构的数据
    $.ajax({
        url: "menu/get/whole/tree.json",
        type: "post",
        dataType: "json",
        success: function (response) {
            const result = response.result;
            if ("SUCCESS" === result) {
                // 1. 创建 JSON 对象用于存储 zTree 的设置
                let setting = {
                    data: {
                        key: {
                            name: "menuName",
                            url: "invalid"
                        }
                    },
                    view: {
                        addDiyDom: addDiyDom,
                        addHoverDom: addHoverDom,
                        removeHoverDom: removeHoverDom,
                    },
                };
                // 2. 准备生成树形结构的 JSON 数据
                let zNodes = response.data;
                // 3. 初始化树形结构
                $.fn.zTree.init($("#treeDemo"), setting, zNodes);

            } else {
                layer.msg(response.message);
            }
        },
        error: function (response) {
            layer.msg(response.status + "" + response.statusText);
        }
    });
}

// 修改默认图标 通过设置 class 属性
function addDiyDom(treeId, treeNode) {
    // zTree 生成 id 的规则
    // icon: treeDemo_7_ico ==> tree Node.tId + "_ico"

    const iconObj = treeNode.tId + "_ico";
    $("#" + iconObj).removeClass().addClass(treeNode.icon);
}

// 鼠标移入时添加 按钮组
function addHoverDom(treeId, treeNode) {
    // 按钮组标签结构: <span><a><i></i></a><a><i></i></a></span>
    const btnGroupId = treeNode.tId + "_btnGrp";

    // 由于移入事件一次移入会多次触发, 所以需要判断是否已经添加了 按钮组
    // 判断是否已经添加了按钮组
    if ($("#" + btnGroupId).length > 0) {
        return;
    }

    // 准备按钮的 HTML 标签
    const addBtn = "<a id=" + treeNode.id + "_add class='addBtn btn btn-info dropdown-toggle btn-xs' style='margin-left:10px; padding-top:0px;' title='新增'>&nbsp;<i class='fa fa-fw fa-plus rbg '></i></a>";
    const editBtn = "<a id=" + treeNode.id + "_edit class='editBtn btn btn-info dropdown-toggle btn-xs' style='margin-left:10px; padding-top:0px;' title='修改'>&nbsp;<i class='fa fa-fw fa-edit rbg '></i></a>";
    const removeBtn = "<a id=" + treeNode.id + "_remove class='removeBtn btn btn-info dropdown-toggle btn-xs' style='margin-left:10px; padding-top:0px;' title='删除'>&nbsp;<i class='fa fa-fw fa-times rbg '></i></a>";

    // 获取当前节点的级别数据
    const level = treeNode.level;

    // 声明变量存储拼装好的按钮代码
    let btnHTML = " ";

    // 判断当前节点的级别
    // level 0 根目录(根节点): 新增
    if (level === 0) {
        btnHTML = addBtn;
    }
    // level 1 一级目录(分支节点): 新增, 修改, 删除
    if (level === 1) {
        btnHTML = addBtn + "&nbsp;" + editBtn;

        // 需要判断是否有子节点, 没有子节点才可以删除
        const length = treeNode.children.length;
        if (length === 0) {
            btnHTML += "&nbsp;" + removeBtn;
        }
    }

    // level 2 二级目录(叶子节点): 修改, 删除
    if (level === 2) {
        btnHTML = editBtn + "&nbsp;" + removeBtn;
    }

    // 将按钮组添加到超链接后面
    const anchorId = treeNode.tId + "_a";
    $("#" + anchorId).after("<span id='" + btnGroupId + "'>" + btnHTML + "</span>");
}

// 鼠标移出时删除 按钮组
function removeHoverDom(treeId, treeNode) {
    // 获取拼接按钮组的 id
    const btnGroupId = treeNode.tId + "_btnGrp";
    // 根据 id 删除对应的元素
    $("#" + btnGroupId).remove();
}

