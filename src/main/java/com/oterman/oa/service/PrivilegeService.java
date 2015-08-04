package com.oterman.oa.service;

import java.util.Collection;

import com.oterman.oa.domain.Privilege;
import com.oterman.oa.domain.User;
import com.oterman.oa.service.base.BaseService;

public interface PrivilegeService extends BaseService<Privilege> {

	/**
	 * 根据用户的id，查询该用户能够访问到的所有菜单节点；
	 * @param uid
	 */
	Collection<Privilege> getMenuItemsByUid(User user);
	
	/**
	 * 获取用户所具有的功能权限；
	 */
	Collection<Privilege> getFunctionPrivilegesByUid(User user);
	
}
