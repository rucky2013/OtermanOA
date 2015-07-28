package com.oterman.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oterman.oa.dao.base.BaseDao;
import com.oterman.oa.domain.MenuItem;
import com.oterman.oa.service.MenuItemService;
import com.oterman.oa.service.base.impl.BaseServiceImpl;

@Service("menuItemService")
public class MenuItemServiceImpl extends BaseServiceImpl<MenuItem> implements MenuItemService{

	@Resource(name="menuItemDao")
	private BaseDao menuItemDao;
	
	@Override
	public BaseDao<MenuItem> getBaseDao() {
		return menuItemDao;
	}

}
