package com.oterman.oa.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.oterman.oa.dao.base.BaseDao;


public class BaseDaoImpl<T> implements BaseDao<T> {
	
	
	//引入HibernateTemplate
	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * 获取参数化类型的参数，由于实际是由一个类继承BaseDaoImpl后new出对象，所以根据实际的对象来获取类型参数的值。
	 */
	private Class entityClass;
	public BaseDaoImpl(){
		ParameterizedType superClass=(ParameterizedType) this.getClass().getGenericSuperclass();//得到参数化的父类，即BaseDaoImpl<T>
		this.entityClass=(Class) superClass.getActualTypeArguments()[0];//得到类型参数的值 Class com.oterman.oa.domain.Person
		System.out.println(superClass);//com.oterman.oa.dao.base.impl.BaseDaoImpl<com.oterman.oa.domain.Person>
		System.out.println(superClass.getOwnerType());//null
		System.out.println(superClass.getRawType());//class com.oterman.oa.dao.base.impl.BaseDaoImpl

	}

	public void saveEntry(T t) {
		this.hibernateTemplate.save(t);
	}

	public void updateEntry(T t) {
		this.hibernateTemplate.update(t);
	}

	public void deleteEntry(Serializable id) {
		//需要得到实体类的Class，即T的值
		T t=(T) this.hibernateTemplate.get(this.entityClass, id);
		this.hibernateTemplate.delete(t);
	}

	public T getEleById(Serializable id) {
		return (T) this.hibernateTemplate.get(this.entityClass, id);
	}

	public Collection<T> queryAll() {
//		this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from "+entityClass.getSimpleName());
		return this.hibernateTemplate.find("from "+this.entityClass.getSimpleName());
	}

}