package com.oterman.oa.dao;

import java.util.Collection;

import com.oterman.oa.dao.base.BaseDao;
import com.oterman.oa.domain.Privilege;
import com.oterman.oa.domain.User;

/**
 * 操作Person实体的数据库接口，实现BaseDao，可以在这里写操作book的特有的方法；
 *
 */
public interface PrivilegeDao extends BaseDao<Privilege> {

	/**
	 * 根据用户的id，查找该用户下的所有的菜单节点；
	 */
	Collection<Privilege> getMenuItemsByUid(User user);
	
}
