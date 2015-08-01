var role_privilege={
	data:{
		role:{
			rid:"",
			name:"",
		}
		
	},
	option:{
		divOption:function(){
			$("div:hidden").show();
		},
		privilegeTree:{
			zTreeObj:"",//代表树
			
			setting:{
				isSimpleData: true,
				treeNodeKey: "id",
				treeNodeParentKey: "pid",
				showLine: true,
				checkable:true,
				root:{ 
					isRoot:true,
					nodes:[]
				},
				callback:{
					change:function(){
						role_privilege.option.privilegeTree.setAllCheckedBoxState();
					}
					
				},
				
			},
			loadTree:function(){
				$.get("privilegeAction_getAllPrivileges.action",{rid:role_privilege.data.role.rid},function(data){
					role_privilege.option.privilegeTree.zTreeObj=$("#privilegeTree").zTree(role_privilege.option.privilegeTree.setting,data);
					//隐藏loading图片,显示树
					role_privilege.option.privilegeTree.exchangeLoadingAndTree(true);
					//初始化全选复选框的状态
					$("#allchecked").attr("disabled",false);
					role_privilege.option.privilegeTree.setAllCheckedBoxState();
					
				});
			},
			/**
			 * 处理全选复选框的点击：全选时，所有item都全选；
			 */
			handleAllCheckedBox:function(){
				if($(this).attr("checked")){
					role_privilege.option.privilegeTree.zTreeObj.checkAllNodes(true);
				}else{
					role_privilege.option.privilegeTree.zTreeObj.checkAllNodes(false);
				}
			},
			/**
			 * 设置权限复选框的初始状态，如果所有的item都被选中，那么全选被选中，否则不被选中；
			 */
			setAllCheckedBoxState:function(){
				//得到所有没被选中的节点
				var uncheckedNodes=role_privilege.option.privilegeTree.zTreeObj.getCheckedNodes(false);
				if(uncheckedNodes.length==0){
					$("#allchecked").attr("checked",true);
				}else{
					$("#allchecked").attr("checked",false);
					
				}
				
			},
			/**
			 * 根据状态切换loading图片与树的显示
			 */
			exchangeLoadingAndTree:function(showTreeFlag){
				if(showTreeFlag){//显示树，隐藏loading图片
					$("#privilegeTree").show();
					$("#loading").hide();
				}else{
					$("#loading").show();
					$("#privilegeTree").hide();
				};
			},
			
		},
		
	},
	init:{
		initData:function(){
			role_privilege.data.role.rid=$(this).parent().siblings("td[type='rid']").text();
			role_privilege.data.role.name=$(this).parent().siblings("td[type='name']").text();
			$("#userName").text("角色:"+role_privilege.data.role.name);
		},
		initEvent:function(){
			//给权限修改超级链接添加事件
			$("a").each(function(){
				if($(this).text()=="权限修改"){
					$(this).css("cursor","pointer");
					$(this).unbind("click");
					$(this).bind("click",function(){//出发点击权限修改事件
						//alert($(this).parent().siblings("td[type='name']").text());
						//显示隐藏的div
						role_privilege.option.divOption();
						//初始化数据，获取要修改的角色的角色的rid和name；
						role_privilege.init.initData.call(this);
						//初始化权限复选框；
						$("#allchecked").attr("disabled",true);
						$("#allchecked").attr("checked",false);
						//显示loading图片，隐藏树；
						role_privilege.option.privilegeTree.exchangeLoadingAndTree(false);
						//初始化树
						role_privilege.option.privilegeTree.loadTree();
						
					})
					
				}
			});
			//给全选的checkbox添加事件
			$("#allchecked").change(function(){
				role_privilege.option.privilegeTree.handleAllCheckedBox.call(this);
			});
			//给保存按钮添加事件
			$("#savePrivliege").click(function(){
				//获取rid，选中节点的id，组成字符串，ajax提交到后台；
				var ids=[];
				var checkedNames=[];
				var checkedNodes=role_privilege.option.privilegeTree.zTreeObj.getCheckedNodes(true);
				for(var i=0;i<checkedNodes.length;i++){
					ids.push(checkedNodes[i].id);
					checkedNames.push(checkedNodes[i].name);
				}
				
				var params={
					rid:role_privilege.data.role.rid,
					ids:ids.join(","),
					
				}				
				//同步改变table的显示
				$("input[value='"+role_privilege.data.role.rid+"']").siblings("td[type='privileges']").text(checkedNames.join(" "))
				
				$.post("roleAction_buildRoleAndPrivilege.action",params,function(data){
					alert("保存成功");
//					window.location.href="roleAction_listRolesUI.action";
				})

			
				
			})
			
		}
	}
}

$().ready(function(){
	role_privilege.init.initEvent();
})

