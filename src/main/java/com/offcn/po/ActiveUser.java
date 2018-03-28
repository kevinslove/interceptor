package com.offcn.po;

import java.io.Serializable;
import java.util.List;

public class ActiveUser implements Serializable{
	private String userid;//用户id
	private String usercode;// 用户账号	
	private List<Permission> permissions;// 权限
	private List<Role> roles;//角色   
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}
