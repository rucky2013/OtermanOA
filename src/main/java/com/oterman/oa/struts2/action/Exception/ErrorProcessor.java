package com.oterman.oa.struts2.action.Exception;

import com.opensymphony.xwork2.ActionSupport;

public class ErrorProcessor extends ActionSupport{
	private Exception exception;
	
	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(exception.getMessage());
		return SUCCESS;
	}
}
