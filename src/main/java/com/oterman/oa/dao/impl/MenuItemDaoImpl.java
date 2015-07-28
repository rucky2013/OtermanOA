package com.oterman.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.oterman.oa.dao.MenuItemDao;
import com.oterman.oa.dao.base.impl.BaseDaoImpl;
import com.oterman.oa.domain.MenuItem;

@Repository("menuItemDao")
public class MenuItemDaoImpl extends BaseDaoImpl<MenuItem> implements MenuItemDao{

}
