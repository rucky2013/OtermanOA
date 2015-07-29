package com.oterman.oa.dao;

import java.io.Serializable;
import java.util.Collection;

import com.oterman.oa.dao.base.BaseDao;
import com.oterman.oa.domain.MenuItem;

public interface MenuItemDao  extends BaseDao<MenuItem>{
	
	public Collection<MenuItem> getMenuItemByPid(Serializable pid);

}
