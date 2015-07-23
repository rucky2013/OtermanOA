package com.oterman.oa.struts2.action;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *抽取Action的公共部分 
 */
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	
	protected T t=null;//模型，即要将请求来的参数封封装成的bean
	public BaseAction() {
		//得到T的class形式
		ParameterizedType pt=(ParameterizedType) this.getClass().getGenericSuperclass();
		Class modelClass=(Class) pt.getActualTypeArguments()[0];
		try {
			this.t=(T) modelClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public T getModel() {
		return t;
	}
	
}
