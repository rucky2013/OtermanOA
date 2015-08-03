package com.oterman.oa.domain;

import java.io.Serializable;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

public class Privilege implements Serializable {
	private Long id;
	private Long pid;
	private String name;
	private String description;
	private String type;
	private Set<Role> roles;
	
	private boolean checked;
	private String url;
	private String target;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	private String icon;
	private boolean isParent;
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public void setIsParent(boolean flag){
		this.isParent=flag;
	}
	
	public boolean isIsParent(){
		return this.isParent;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @JSON(serialize=false)  在将该对象序列化成json格式实，忽略掉该对象。
	 * @return
	 */
	@JSON(serialize=false)
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
