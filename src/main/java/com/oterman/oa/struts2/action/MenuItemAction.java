package com.oterman.oa.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.oterman.oa.domain.MenuItem;
import com.oterman.oa.service.MenuItemService;

@Controller("menuItemAction")
@Scope("prototype")
public class MenuItemAction extends BaseAction<MenuItem>{
	
	@Resource(name="menuItemService")
	private MenuItemService menuItemService;
	
	private String pid;

	public String  getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	public String getAll(){
		Collection<MenuItem> list = this.menuItemService.queryAll();
		ActionContext.getContext().getValueStack().push(list);
		return SUCCESS;
	}
	
	public String getSubItems(){
		Collection<MenuItem> list = this.menuItemService.getMenuItemByPid(this.getModel().getPid());
		ActionContext.getContext().getValueStack().push(list);
		return SUCCESS;
	}
}


