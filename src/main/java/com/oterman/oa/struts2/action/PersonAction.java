package com.oterman.oa.struts2.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oterman.oa.domain.Person;
import com.oterman.oa.service.base.BaseService;

@Controller(value="personAction")
@Scope("prototype")
public class PersonAction extends BaseAction<Person> {

	@Resource(name="personService")
	private BaseService<Person> baseService;
	
	public String savePerson(){
		Person p=new Person();
		p.setPgender("nv");
		p.setPname("小王");
		baseService.saveEntry(p);
		return "ok";
	}
	
	
	public String listPerson(){
		//得到所有的person，放入map栈中；
		List<Person> personList=(List<Person>) baseService.queryAll();
		
		ServletActionContext.getContext().put("list", personList);
		
		return "list";
	}
	
	
}
