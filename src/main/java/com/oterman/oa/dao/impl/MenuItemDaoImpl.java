package com.oterman.oa.dao.impl;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.oterman.oa.dao.MenuItemDao;
import com.oterman.oa.dao.base.impl.BaseDaoImpl;
import com.oterman.oa.domain.MenuItem;

@Repository("menuItemDao")
public class MenuItemDaoImpl extends BaseDaoImpl<MenuItem> implements MenuItemDao{

	public Collection<MenuItem> getMenuItemByPid(Serializable pid) {
		return this.hibernateTemplate.find("from MenuItem where pid=?",pid);
	}

}
