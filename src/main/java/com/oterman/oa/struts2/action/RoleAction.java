package com.oterman.oa.struts2.action;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.oterman.oa.domain.Role;
import com.oterman.oa.domain.User;
import com.oterman.oa.service.RoleService;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

	@Resource(name = "roleService")
	private RoleService roleService;

	private Long uid;

	// 角色对应权限的id组成的字符串；
	private String ids;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	/**
	 * 获取所有的角色，放入栈中，在修改user的角色时会调用该方法；
	 * 
	 * @return
	 */
	public String getAllRoles() {
		Collection<Role> list = roleService.getAllRolesByUid(uid);
		ActionContext.getContext().getValueStack().push(list);
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	/**
	 * 跳转到角色添加的ui上去；
	 */
	public String addUI(){
		return "addUI";
	}
	
	/**
	 * 处理角色的添加逻辑；
	 */
	public String add(){
		Role model = this.getModel();
		this.roleService.saveEntry(model);
		return "action2action";
	}
	
	/**
	 * 完成删除逻辑；
	 */
	public String delete(){
		this.roleService.deleteEntry(this.getModel().getRid());
		return "action2action";
	}
	
	/**
	 * 跳转到更新角色的页面；
	 * 需要回显数据，根据id查询出role，push到值栈中；
	 */
	public String updateUI(){
		Role role = this.roleService.getEleById(this.getModel().getRid());
		ActionContext.getContext().getValueStack().push(role);
		return "updateUI";
	}

	/**
	 * 处理更新角色的逻辑；
	 */
	public String update(){
		Role user= this.roleService.getEleById(this.getModel().getRid());
		user.setName(this.getModel().getName());
		user.setDescription(this.getModel().getDescription());
		this.roleService.updateEntry(user);
		
		return "action2action";
	}
	
	/**
	 * 列出所有的角色；
	 */
	public String listRolesUI() {
		Collection<Role> list = roleService.getAllRolesWithPrivilege();
		ActionContext.getContext().put("list", new TreeSet<Role>(list));
		return "listRoles";
	}

	public String buildRoleAndPrivilege() {
		Long rid = this.getModel().getRid();
		Long[] idsL = null;
		
		if (this.ids.length()!=0) {
			String[] ss = this.ids.split(",");
			idsL = new Long[ss.length];
			int index = 0;
			for (String s : ss) {
				idsL[index] = Long.parseLong(s);
				index++;
			}
		}

		this.roleService.buildRoleAndPrivileges(rid, idsL);
		return SUCCESS;
	}

}
