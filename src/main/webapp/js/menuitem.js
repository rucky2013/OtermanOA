var menuitem={
	loadTree:function(){
		$.get("menuItemAction_getAll.action",null,function(data){
			$("#tree").zTree(menuitem.setting,data);
		});
	},
	setting:{
		isSimpleData: true,
		treeNodeKey: "mid",
		treeNodeParentKey: "pid",
		showLine: true,
		root:{ 
			isRoot:true,
			nodes:[]
		}
	}
	
};

/**
 * 加载树
 */
$().ready(function(){
	menuitem.loadTree();
})


