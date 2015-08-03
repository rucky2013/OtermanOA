package com.oterman.oa.struts2.action;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.oterman.oa.domain.Department;
import com.oterman.oa.domain.Role;
import com.oterman.oa.domain.User;
import com.oterman.oa.service.DepartmentService;
import com.oterman.oa.service.RoleService;
import com.oterman.oa.service.UserService;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	@Resource(name="roleService")
	private RoleService roleService;
	/**
	 * 获取表单的did以及rids属性
	 */
	private Long did;
	private Long[] rids;
	//获取选中的item的id所组成的字符串，如“1，2，3”
	private String checkedIds;
	
	public String getCheckedIds() {
		return checkedIds;
	}

	public void setCheckedIds(String checkedIds) {
		this.checkedIds = checkedIds;
	}

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public Long[] getRids() {
		return rids;
	}

	public void setRids(Long[] rids) {
		this.rids = rids;
	}

	public String showAll(){
		Collection<User> list= this.userService.queryAll();
		
		ActionContext.getContext().put("list", new TreeSet<User>(list));
		return "listAction";
	}

	/**
	 * 跳转到add.jsp页面
	 */
	public String addUI(){
		//查询department，role
		Collection<Department> dList = this.departmentService.queryAll();
		
		Collection<Role> rList = this.roleService.queryAll();
		
		ActionContext.getContext().put("dList", dList);
		ActionContext.getContext().put("rList", rList);
		
		return "addUI";
	}
	
	/**
	 * 处理表单提交
	 * @return
	 */
	public String add(){
		User model = this.getModel();
		
		this.userService.addUser(model,this.did,this.rids);
	
		return "action2action";
	}
	
	/**
	 * 跳转到更新页面，数据回显
	 */
	public String updateUI(){
		User user = this.userService.getEleById(this.getModel().getUid());
		this.did=user.getDepartment().getDid();
		
		this.rids=new Long[user.getRoles().size()];
		int index=0;
		for (Role role : user.getRoles()) {
			rids[index++]=role.getRid();
		}
		
		ActionContext.getContext().getValueStack().push(user);
		
		Collection<Department> dList = this.departmentService.queryAll();
		Collection<Role> rList = this.roleService.queryAll();
		
		ActionContext.getContext().put("dList", dList);
		ActionContext.getContext().put("rList", rList);
		
		return "updateUI";
	}
	
	/**
	 * 处理更新逻辑
	 */
	public String update(){
		//user,did,rids
		this.userService.updateUser(this.getModel(), did, rids);
		
		return "action2action";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		this.userService.deleteEntry(this.getModel().getUid());
		
		return "action2action";
	}
	
	/**
	 * 点击角色树的保存按钮时，提交选中的角色的id到该方法；
	 * @return
	 */
	public String updateUserWithRole(){
		String[] strs=this.checkedIds.split(",");
		rids=new Long[strs.length];
		for(int i=0;i<strs.length;i++){
			rids[i]=Long.parseLong(strs[i]);
		}
		Long uid=this.getModel().getUid();
		this.userService.updateUserWithRoles(uid, rids);
		
		return SUCCESS;
	}
		
}
