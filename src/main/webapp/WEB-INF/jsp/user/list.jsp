<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" href="zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="js/jquery-ztree-2.5.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/user_role.js"></script>


<html>
<head>
<title>用户列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/css/images/title_arrow.gif" />
				用户管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">

			<!-- 表头-->
			<thead>
				<tr align=center valign=middle id=TableTitle>
					<td width="100">用户名</td>
					<td width="100">所属部门</td>
					<td>所属岗位</td>
					<td>相关操作</td>
				</tr>
			</thead>

			<!--显示数据列表-->
			<tbody id="TableData" class="dataContainer" datakey="userList">
				<s:iterator value="#list">
					<tr align=center valign=middle id=TableTitle>
						<s:hidden name="uid"></s:hidden>
						<td width="100"><s:property value="username" /></td>
						<td width="100"><s:property value="department.name" /></td>
						<td type="roles"><s:iterator value="roles">
								<s:property value="name" />
							</s:iterator>
						</td>
						<td><s:a action="userAction_delete.action?uid=%{uid}">删除</s:a>
							<s:a action="userAction_updateUI.action?uid=%{uid}">修改</s:a> 
							<a>角色修改</a>
					</tr>
				</s:iterator>

			</tbody>
		</table>


		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div id="TableTail_inside">
				<a href="userAction_addUI.action"><img
					src="${pageContext.request.contextPath}/css/images/createNew.png" />
				</a>
			</div>
		</div>


		<div class="ItemBlock_Title1" id="userTitle" style="display: none;">
			<!-- 信息说明 -->
			<div class="ItemBlock_Title1">
				<img border="0" width="4" height="7"
					src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" />
				<s:label id="userName"></s:label>
			</div>
			<div class="ItemBlock_Title1" id="privilegeTitle"
				style="display: none;">
				<div class="ItemBlock_Title1">
					<img border="0" width="4" height="7"
						src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" />选择角色
				</div>
			</div>

			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder" style="display: none;"
				id="privilegeContent">
				<div class="ItemBlock">
					<table cellpadding="0" cellspacing="0" class="mainForm">
						<!--表头-->
						<thead>
							<tr align="LEFT" valign="MIDDLE" id="TableTitle">
								<td width="300px" style="padding-left: 7px;">
									<!-- 如果把全选元素的id指定为selectAll，并且有函数selectAll()，就会有错。因为有一种用法：可以直接用id引用元素 -->
									<input type="checkbox" id="allchecked"  disabled="true" /> <label
									for="cbSelectAll">全选</label></td>
							</tr>
						</thead>

						<!--显示数据列表-->
						<tbody id="TableData">
							<tr class="TableDetail1">
								<!-- 显示权限树 -->
								<td>
									<ul id='roleTree' class="tree"></ul>
									<!-- 当权限树还未加载出来的时候，显示正在加载的图片 -->
									<img  id="loading" src="${pageContext.request.contextPath }/css/images/loading.gif">
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<image id="saveRole"
					src="${pageContext.request.contextPath}/css/images/save.png" />
			</div>

		</div>
</div>
</body>
</html>
