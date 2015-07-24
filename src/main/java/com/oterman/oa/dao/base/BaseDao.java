package com.oterman.oa.dao.base;

import java.io.Serializable;
import java.util.Collection;

/**
 * 各个实体的公共接口
 */
public interface BaseDao<T> {
	public void saveEntry(T t);
	public void updateEntry(T t);
	public void deleteEntry(Serializable id);
	public Collection<T> queryAll();
	public T getEleById(Serializable id);

}
