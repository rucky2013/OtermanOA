//先要引入jquery文件
//$().ready(function(){
//    var config = {
//        url: "hello",
//        data: null,
//        setting: "xxx"
//    }
//    
//    var json = {
//        url: "jsonurl",
//        data: "xixi"
//    }
//    
//    var result = $.extend(config, json);
//	var result2=config;
//    alert(result.url);
//	alert(result==config);//true
//})

//自定义插件
//jQuery.fn.test=function(){
//	alert("这是方法对象！");
//	alert(this.text());
//}
//
//$().ready(function(){
//	$("#test").unbind("click");
//	$("#test").bind("click",function(){
//		$(this).test();
//	});
//});

//创建树
//(function(jQuery){
//	$.fn.creatTree=function(){
//		alert("创建成功！");
//	}
//})(jQuery);
//
//$().ready(function(){
//	$("#test").click(function(){
//		$(this).creatTree();
//	});
//});

//(function(#){})($)

var setting = {
    isSimpleData: true,
    treeNodeKey: "mid",
    treeNodeParentKey: "pid",
    showLine: true,
    root: {
        isRoot: true,
        nodes: []
    },
};

var config ={
	url:"",
	data:null,
}

$.fn.createTree = function(json){
    var tree = $(this);
	$.extend(config,json);
    $.post(config.url, config.data, function(data){
        $("#tree").zTree(setting, data);
    });
};




$().ready(function(){
    $("#tree").createTree({
		url:"menuItemAction_getAll.action",
	});
    
});






