package com.oterman.oa.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.oterman.oa.domain.MenuItem;
import com.oterman.oa.service.base.BaseService;

public interface MenuItemService  extends BaseService<MenuItem>{
	public Collection<MenuItem> getMenuItemByPid(Serializable pid);

}
