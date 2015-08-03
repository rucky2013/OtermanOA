/**
 * 定义一个插件
 */
/**
 * (function($){})($)
 *
 */
var setting = {
    isSimpleData: true,
    treeNodeKey: "id",
    treeNodeParentKey: "pid",
    showLine: true,
    root: {
        isRoot: true,
        nodes: []
    },

};

var config = {
	setting:setting,
    url: "",
    data: null,
}

/**
 * 定义jQuery对象的函数；
 * @param {Object} jsonObj
 */
$.fn.loadTree = function(jsonObj){
    var $tree = $(this);
    $.extend(config, jsonObj);//将传进来的参数替代掉config中对应的参数；
    $.post(config.url, config.data, function(data){//异步获取树的节点信息
        $tree.zTree(config.setting, data);
    });
}


