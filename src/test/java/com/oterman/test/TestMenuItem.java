package com.oterman.test;

import java.util.Collection;

import org.junit.Test;

import com.oterman.oa.domain.MenuItem;
import com.oterman.oa.service.MenuItemService;

public class TestMenuItem extends SpringInit{

	@Test
	public void testQueryAll(){
		MenuItemService menuItemService=(MenuItemService) this.applicationContext.getBean("menuItemService");
		Collection<MenuItem> list = menuItemService.queryAll();
		System.out.println(list.size());
	}
}
