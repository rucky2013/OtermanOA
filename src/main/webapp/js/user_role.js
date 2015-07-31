var user_role={
	/**
	 * 保存数据
	 */
	data:{
		user:{
			username:"",
			uid:"",
		},
		
	},
	/**
	 * 保存操作
	 */
	option:{
		divOption:{
			showDiv:function(){
				$("div:hidden").show();
				
			}
		},
		/**
		 * 加载角色树
		 */
		roleTree:{
			treeObj:"",//用来接收zTree()的返回值，代表这颗角色树
			setting:{
				isSimpleData: true,
				treeNodeKey: "rid",
				treeNodeParentKey: "pid",
				showLine: true,
				root:{ 
					isRoot:true,
						nodes:[]
				},
				checkable:true,
				/**
				 * 添加事件
				 */
				callback:{
					change:function(event, treeId, treeNode){//checkbox被点击的时候出发
						//判断是否全部被选中，然后操作全选按钮
						user_role.option.roleTree.setAllCheckedState();
					},
				}
				
			},
			/**
			 * 加载树
			 */
			loadTree:function(){
				$.post("roleAction_getAllRoles.action",{uid:user_role.data.user.uid},function(data){
					user_role.option.roleTree.treeObj=$("#roleTree").zTree(user_role.option.roleTree.setting,data);
					//全选按钮变为可用
					$("#allchecked").attr("disabled",false);
					//显示树
					user_role.option.roleTree.ExchangeLoadingAndTree({loadTree:true,});
					//处理全选的复选框
					user_role.option.roleTree.setAllCheckedState();
					
				})
			},
			/**
			 * 当角色树未加载出来的时候，显示loding图片；加载出来后，隐藏loading图片；
			 */
			ExchangeLoadingAndTree:function(jsonObj){
				if(jsonObj.loadTree){//显示树，隐藏图片
					$("#roleTree").show();
					$("#loading").hide();
				}else{//显示图片，隐藏树
					$("#roleTree").hide();
					$("#loading").show();
				}
			},
			/**
			 * 处理点击全选的复选框；点击全选实，所有的节点都选中
			 */
			handleCheckAll:function(){
				if($("#allchecked").attr("checked")){//全选
					user_role.option.roleTree.treeObj.checkAllNodes(true);
				}else{//全不选
					user_role.option.roleTree.treeObj.checkAllNodes(false);
				}
			},
			/**
			 * 处理其他item的点击，如果全部被选中，则全选被选中；否则全选不被选中；
			 */
			setAllCheckedState:function(){
				//获取没有被选中的checkbox
				var uncheckedNodes=user_role.option.roleTree.treeObj.getCheckedNodes(false);
				if(uncheckedNodes.length==0){//都被选中，全选按钮也应该被选中
					$("#allchecked").attr("checked",true);
				}else{//存在没有被选中的item，故全选按钮不应该被选中；
					$("#allchecked").attr("checked",false);
				}
			},
			/**
			 * 获取选中的角色的id，然后和uid一起提交给服务器，该方法在点击保存按钮时调用；
			 */
			updateUserWithRole:function(){
				var checkedIds="";//获取所有选中的id,组成“1，2，”这样的字符串；
				var roleNames=[];//获取节点的name，同步更新到table中的列
				//得到选中的节点
				var checkedNodes=user_role.option.roleTree.treeObj.getCheckedNodes(true);
				for(var i=0;i<checkedNodes.length;i++){
					if(i==checkedNodes.length-1){
						checkedIds=checkedIds+checkedNodes[i].rid;
					}else{
						checkedIds=checkedIds+checkedNodes[i].rid+",";
					}
					roleNames.push(checkedNodes[i].name);	
				}
				
//				alert(checkedIds);
				//需要向后台提交的参数
				var params={
					uid:user_role.data.user.uid,
					checkedIds:checkedIds,
				};
				
				$.post("userAction_updateUserWithRole.action",params,function(data){
					alert("保存成功！");
				});
				
				//同步更新所属岗位这一列
				//找到需要更新的列的位置；
				var $role=$("input[value='"+user_role.data.user.uid+"']").siblings("td[type='roles']");
				$role.text(roleNames.join("  "));
				
			}
			
		},

	},
	/**
	 * 初始化操作
	 */
	init:{
		initData:function(){
			//获取当前点击链接对应的username和uid
			user_role.data.user.username=$(this).parent().siblings("td:first").text();
			user_role.data.user.uid=$(this).parent().siblings("input[type='hidden']").val();
		},
		initEvent:function(){
			
			/**
			 * 给每一个角色修改的链接添加事件,
			 * 1.显示隐藏的div
			 * 2.动态的改变用户名（先获取username,uid,后在规定的区域把username显示出来）
			 */
			$("a").each(function(){
				if(this.text=="角色修改"){
					$(this).css("cursor","pointer");
					$(this).bind("click",function(){
						//显示div
						user_role.option.divOption.showDiv();
						//获取username，uid,保存到data中；
						user_role.init.initData.call(this);
						//将用户名设置到指定的区域
						$("#userName").text("用户名:"+user_role.data.user.username);
						
						//设置全选复选框的初始状态
						$("#allchecked").attr("disabled",true);
						$("#allchecked").attr("checked",false);
						
						//树加载需要时间，故先隐藏起来
						user_role.option.roleTree.ExchangeLoadingAndTree({loadTree:false,});
						//加载角色树
						user_role.option.roleTree.loadTree();
					});
				}

			});
			
			/**
			 * 给全选添加事件
			 */
			$("#allchecked").change(function(){
				user_role.option.roleTree.handleCheckAll();
			});
			
			/**
			 * 给保存按钮添加事件
			 */
			$("#saveRole").bind("click",function(){
				user_role.option.roleTree.updateUserWithRole();
			});
			
		}
	}
	
}

$().ready(function(){
	user_role.init.initEvent();
})
