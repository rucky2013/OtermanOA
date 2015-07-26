package com.oterman.oa.struts2.action;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oterman.oa.domain.Department;
import com.oterman.oa.service.DepartmentService;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {
	
	@Resource(name="departmentService")
	private DepartmentService departmentSerivce;
	
	public String showAll(){
		List<Department> list = (List<Department>) this.departmentSerivce.queryAll();
		ServletActionContext.getContext().put("list", list);
		return listAction;
	}
	
	
	public String updateUI(){
		//获取did,根据did的值查询得到department存入对象栈中，作为回显
		Department department = this.departmentSerivce.getEleById(this.getModel().getDid());
		
		ServletActionContext.getContext().getValueStack().push(department);
		
		return "updateUI";
	}
	
	public String update(){
		//获取数据,保存起来
		Department model = this.getModel();
		this.departmentSerivce.updateEntry(model);
		
		return "action2action";
	}
	
	public String delete(){
		Department model = this.getModel();
		departmentSerivce.deleteEntry(model.getDid());
		return "action2action";
	}
	
	public String addUI(){
		
		return "addUI";
	}
	
	public String add(){
		Department model = this.getModel();
		this.departmentSerivce.saveEntry(model);
		return "action2action";
	}
	

}
