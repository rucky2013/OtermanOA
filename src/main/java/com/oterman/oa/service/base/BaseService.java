package com.oterman.oa.service.base;

import java.io.Serializable;
import java.util.Collection;
/**
 * service的公共接口
 * @param <T> 代表具体的实体类
 */
public interface BaseService<T> {
	public void saveEntry(T t);
	public void updateEntry(T t);
	public void deleteEntry(Serializable id);
	public Collection<T> queryAll();
	public T getEleById(Serializable id);
	
	public Collection<T> createQuery(String hql);
	
}
