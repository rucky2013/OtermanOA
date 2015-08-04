package com.oterman.oa.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oterman.oa.domain.Privilege;
import com.oterman.oa.domain.User;
import com.oterman.oa.service.PrivilegeService;
import com.oterman.oa.service.UserService;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction  extends BaseAction<User>{

	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="privilegeService")
	private PrivilegeService privilegeService;
	
	public String login(){
		String username=this.getModel().getUsername();
		String password=this.getModel().getPassword();
		User result=this.userService.findUserByCondition(username,password);
		if(result==null){
			//校验失败，重回登陆页面；
			this.addActionError("用户名或密码错误！");
			return "login";
		}else{
			//校验成功，将其存入session中；根据用户的uid获取用户可以操作的功能权限，存入session中；
			//获取可以操作的功能权限，也存入session中；功能权限用来做权限控制用；
			Collection<Privilege> privilegesList = this.privilegeService.getFunctionPrivilegesByUid(result);
			
			ServletActionContext.getRequest().getSession().setAttribute("privilegeList", privilegesList);
			ServletActionContext.getRequest().getSession().setAttribute("user", result);
			return "index";
		}
		
	}
	
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "login";
	}
	
}
