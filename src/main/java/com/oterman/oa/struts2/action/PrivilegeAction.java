package com.oterman.oa.struts2.action;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.oterman.oa.domain.Privilege;
import com.oterman.oa.service.PrivilegeService;
import com.oterman.oa.service.RoleService;

@Controller("privilegeAction")
@Scope("prototype")
public class PrivilegeAction extends BaseAction<Privilege>{
	//用来获取角色的id；
	private Long rid;

	@Resource(name="privilegeService")
	private PrivilegeService privilegeService;
	
	@Resource(name="roleService")
	private RoleService  roleService;
	
	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	
	/**
	 * 获取所有的权限，在修改角色时，显示出权限树会调用这个方法；
	 * 权限树的回显：先获取所有的权限树，然后再根据rid获取对应的权限，遍历所有的集合，给rid对应的权限的checked属性设置为true；
	 * 
	 */
	public String getAllPrivileges(){
		Collection<Privilege> list = this.privilegeService.queryAll();
		Set<Privilege> list2 = this.roleService.getEleById(rid).getPrivileges();
		
		for (Privilege privilege : list) {
			for (Privilege privilege2 : list2) {
				if(privilege.getId()==privilege2.getId()){
					privilege.setChecked(true);
					break;
				}
			}
		}
		
		
		ActionContext.getContext().getValueStack().push(list);
		try {
			Thread.sleep(2000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

}
