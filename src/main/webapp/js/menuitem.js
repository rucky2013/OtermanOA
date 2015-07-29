var zTreePlugin;
var menuitem={
	
	loadTree:function(){
		$.get("menuItemAction_getAll.action",null,function(data){
			$("#tree").zTree(menuitem.setting,data);
		});
	},
	/**
	 * 展开事件
	 * @param {Object} event
	 * @param {Object} treeId
	 * @param {Object} treeNode
	 */
	setting:{
		isSimpleData: true,
		treeNodeKey: "mid",
		treeNodeParentKey: "pid",
		showLine: true,
		root:{ 
			isRoot:true,
			nodes:[]
		},
		callback:{
			expand:onItemExpand,//展开节点会触发该事件
		}
	},
	/**
	 * 加载跟节点
	 */
	loadRoot:function(){
		$.post("menuItemAction_getSubItems.action",{pid:0},function(data){
			zTreePlugin=$("#tree").zTree(menuitem.setting,data);
		});
	},
	
};
/**
 * 点击展开时，根据pid获取值
 * @param {Object} event
 * @param {Object} treeId 树的id
 * @param {Object} treeNode 当前节点的json对象
 */
function onItemExpand(event, treeId, treeNode){ 
		//判断节点下是否有子节点，如果没有，则获取子节点，添加到树中，
		if(!zTreePlugin.getNodeByParam("pid", treeNode.mid)){
			$.post("menuItemAction_getSubItems.action",{pid:treeNode.mid},function(data){
				zTreePlugin.addNodes(treeNode, data, "true");//添加到树中
			});
		}
	};

/**
 * 加载树
 */
$().ready(function(){
//	menuitem.loadTree();
	menuitem.loadRoot();
})


