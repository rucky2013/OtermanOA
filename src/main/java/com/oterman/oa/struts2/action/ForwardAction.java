package com.oterman.oa.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class ForwardAction  extends  ActionSupport{
	
	private String method;

	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
	public String index(){
		return "index";
	}
	
	public String forward(){
		return this.method;
	}
	
}
