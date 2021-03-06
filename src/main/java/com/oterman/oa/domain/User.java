package com.oterman.oa.domain;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable,Comparable<User>{
	private Long uid;
	private String username;
	private String password;
	private String sex;
	private String phone;
	private String email;
	
	private Department department;//部门和员工一对多
	private Set<Role> roles;//员工和角色多对多
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public int compareTo(User user) {
		return this.uid>user.getUid()?1:(this.uid==user.getUid()?0:-1);
	}
	
}
