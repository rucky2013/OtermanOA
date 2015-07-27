package com.oterman.oa.struts2.action;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
		Set set=new HashSet<User>(list);
		
		ActionContext.getContext().put("list", set);
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
		Long did2=this.did;
		Long[] dids=this.rids;
		
		this.userService.addUser(model,this.did,this.rids);
	
		return "action2action";
	}
		
}
