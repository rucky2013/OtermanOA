package com.oterman.oa.struts2.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.oterman.oa.domain.User;

public class ForwardAction  extends  ActionSupport{
	
	private String method;

	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
	public String index(){
		//判断是否登陆，如果没有登陆的话，那么跳转到登陆页面
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user!=null){
			return "index";
		}else{
			return "login";
		}
	}
	
	public String forward(){
		return this.method;
	}
	
}
