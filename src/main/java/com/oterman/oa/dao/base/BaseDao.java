package com.oterman.oa.dao.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;


/**
 * 各个实体的公共接口
 */
public interface BaseDao<T> {
	public void saveEntry(T t);
	public void updateEntry(T t);
	public void deleteEntry(Serializable id);
	public Collection<T> queryAll();
	public T getEleById(Serializable id);
	public Collection<T> createQuery(String hql);
	
	public T queryByCondition(Map<String, Object > map);

}
