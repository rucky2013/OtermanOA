package com.oterman.oa.struts2.action;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

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
	
	/**
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
	*/
	
	/**
	 * 使用shiro来完成认证；
	 * 
	 * 
	 * A Subject represents state and security operations for a single
	 * application user. These operations include authentication (login/logout),
	 * authorization (access control), and session access. It is Shiro's primary
	 * mechanism for single-user security functionality.
	 * 
	 * 
	 */
	public String login(){
		//得到主体
		Subject subject = SecurityUtils.getSubject();
		//封装令牌
		UsernamePasswordToken token=new UsernamePasswordToken(this.getModel().getUsername(), this.getModel().getPassword());
		
		try{
			subject.login(token);
		}catch(UnknownAccountException e){
			e.printStackTrace();
			this.addActionError("该用户名不存在");
			return "login";
		}catch(AuthenticationException e){
			e.printStackTrace();
			this.addActionError("密码不对");
			return "login";
		}
		return "index";
		
	}
	
	
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "login";
	}
	
}
