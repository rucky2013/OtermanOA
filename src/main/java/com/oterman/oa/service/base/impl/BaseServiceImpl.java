package com.oterman.oa.service.base.impl;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.oterman.oa.dao.base.BaseDao;
import com.oterman.oa.service.base.BaseService;
/**
 * BaseService的实现类，在该类中实现具体的逻辑代码
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	/**
	 * 需要得到baseDao的实现对象；
	 * 应该在具体的类中保存baoDao的引用，这样才能注入;
	 * 设置一个抽象的方法，该抽象方法返回具体的baseDao，这样我们就可以利用baseDao来做事了。
	 * 
	 */
	public abstract BaseDao<T> getBaseDao();
	
	@Transactional
	public void saveEntry(T t) {
		this.getBaseDao().saveEntry(t);
	}
	
	@Transactional
	public void updateEntry(T t) {
		this.getBaseDao().updateEntry(t);
	}

	@Transactional
	public void deleteEntry(Serializable id) {
		this.getBaseDao().deleteEntry(id);
	}

	@Transactional(readOnly=true)
	public Collection<T> queryAll() {
		
		return this.getBaseDao().queryAll();
	}

	public T getEleById(Serializable id) {
		return this.getBaseDao().getEleById(id);
	}

}
