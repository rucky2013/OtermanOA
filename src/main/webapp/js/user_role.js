var user_role={
	data:{
		
	},
	option:{
		divOption:{
			showDiv:function(){
				$("div:hidden").show();
			}
		}
		
	},
	init:{
		initData:function(){
			
		},
		initEvent:function(){
			
			/**
			 * 给每一个角色修改的链接添加事件
			 */
			$("a").each(function(){
				if(this.text=="角色修改"){
					$(this).bind("click",function(){
						alert("哈哈");
					});
					$(this).css("cursor","pointer");
				}

			});
			
			/**
			 * 给全选添加事件
			 */
			$("#allchecked").change(function(){
				alert($(this).attr("checked"));
			});
			
			/**
			 * 给保存按钮添加事件
			 */
			$("#saveRole").bind("click",function(){
				alert("嘻嘻")
			});
			
		}
	}
	
}

$().ready(function(){
	user_role.option.divOption.showDiv();
	user_role.init.initEvent();
})
