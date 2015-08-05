package com.oterman.oa.interceptor;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.oterman.oa.annotation.PrivilegeInfo;
import com.oterman.oa.domain.Privilege;
import com.oterman.oa.domain.User;

public class PrivilegeInterceptor implements Interceptor {

	public void destroy() {

	}

	public void init() {

	}

	public String intercept(ActionInvocation invocation) throws Exception {
		/**
		 * 1.获取用户的功能权限； 2.获取用户要操作action方法上的权限 3.检查用户所具有的功能权限是否包含方法上所标注的权限
		 * 4.具有权限，放行；不具有权限，跳转到错误的页面；
		 */
		List<Privilege> privilegeList = (List<Privilege>) ServletActionContext
				.getRequest().getSession().getAttribute("privilegeList");
		// 要调用的action的方法的名字；
		String methodName = invocation.getProxy().getMethod();

		Class actionClass = invocation.getAction().getClass();

		// 得到方法，检查方法上是否有注解；
		Method invokedMethod = actionClass.getMethod(methodName, null);
		PrivilegeInfo annotation = invokedMethod.getAnnotation(PrivilegeInfo.class);
		String neededPrivilegeName=null;
		if(annotation!=null){
			neededPrivilegeName= annotation.privilege();//得到权限名；
		}
		
		//检查方法需要的权限是否在用户具有的权限的集合中；
		boolean flag=false;
		for (Privilege privilege : privilegeList) {
			if(privilege.getName().equals(neededPrivilegeName)){
				flag=true;
				break;
			}
		}
		
		//检查用户是否为admin，为admin的话放行；
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if("admin".equals(user.getUsername())){
			flag=true;
		}
		
		if(flag){
			return invocation.invoke();
		}else{
			ActionContext.getContext().getValueStack().push("不好意思，你不具备"+neededPrivilegeName+"权限，请联系超级管理员。");
			return "error";
		}
		
	}

}
