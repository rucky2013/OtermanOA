$().ready(function(){
	$("#menuTree").loadTree({
		url:"privilegeAction_getMenuItemsByUid.action",
	});
});