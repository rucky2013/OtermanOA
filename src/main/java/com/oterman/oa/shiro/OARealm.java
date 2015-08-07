package com.oterman.oa.shiro;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.oterman.oa.domain.Privilege;
import com.oterman.oa.domain.User;
import com.oterman.oa.service.PrivilegeService;
import com.oterman.oa.service.UserService;

public class OARealm extends AuthorizingRealm{

	@Resource(name="userService")
	UserService userService;
	
	@Resource(name="privilegeService")
	PrivilegeService privilegeService;
	
	/**
	 * 完成授权，访问某个方法是否具有某种权限；
	 * 
	 * 根据用户，查询出用户的权限，将权限赋予给用户；
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		
		//根据用户把用户具有的权限都查出来；
		Collection<Privilege> funcPrivileges = this.privilegeService.getFunctionPrivilegesByUid(user);
		Collection<String> privileges=new ArrayList<String>();
		
		for (Privilege privilege : funcPrivileges) {
			privileges.add(privilege.getName());
		}
		
		info.addStringPermissions(privileges);
		//url级别控制，见spring配置文件
		info.addStringPermission("queryRole");
		return info;
	}

	/**
	 * 完成认证，例如登陆的认证；
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		//得到有用户名和密码的token
		UsernamePasswordToken upt=(UsernamePasswordToken) token;
		String username=upt.getUsername();
		
		//根据用户名查找用户
		User user=this.userService.findUserByUsername(username);
		if(user==null){
			return null;
		}
		//把用户信息封装成返回值返回；
		//将当前用户保存到session中；
		SecurityUtils.getSubject().getSession().setAttribute("user", user);
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user,user.getPassword(),getName());
		
		return info;
	}

}
