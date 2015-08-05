package com.oterman.oa.struts2.action;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oterman.oa.annotation.PrivilegeInfo;
import com.oterman.oa.domain.Department;
import com.oterman.oa.service.DepartmentService;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {
	
	@Resource(name="departmentService")
	private DepartmentService departmentSerivce;
	
	@PrivilegeInfo(privilege="部门查询")
	public String showAll(){
		List<Department> list = (List<Department>) this.departmentSerivce.queryAll();
		ServletActionContext.getContext().put("list", list);
		return listAction;
	}
	
	@PrivilegeInfo(privilege="部门修改")
	public String updateUI(){
		//获取did,根据did的值查询得到department存入对象栈中，作为回显
		Department department = this.departmentSerivce.getEleById(this.getModel().getDid());
		
		ServletActionContext.getContext().getValueStack().push(department);
		
		return "updateUI";
	}
	
	@PrivilegeInfo(privilege="部门修改")
	public String update(){
		//获取数据,保存起来
		Department model = this.getModel();
		this.departmentSerivce.updateEntry(model);
		
		return "action2action";
	}
	
	@PrivilegeInfo(privilege="部门删除")
	public String delete(){
		Department model = this.getModel();
		departmentSerivce.deleteEntry(model.getDid());
		return "action2action";
	}
	
	@PrivilegeInfo(privilege="部门增加")
	public String addUI(){
		return "addUI";
	}
	
	@PrivilegeInfo(privilege="部门增加")
	public String add(){
		Department model = this.getModel();
		this.departmentSerivce.saveEntry(model);
		return "action2action";
	}
	

}
