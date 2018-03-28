package com.offcn.po;

import java.io.Serializable;

public class Permission implements Serializable{
	 /**
     * 权限id
     */
    private Long id;

    /**
     * 访问url,如/user/add.action
     */
    private String url;

    /**
     * 权限名
     */
    private String permissionName;

    /**
     * 权限标识,程序中判断使用,如"user:create"
     */
    private String permissionSign;

    /**
     * 权限描述,UI界面显示使用
     */
    private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionSign() {
		return permissionSign;
	}

	public void setPermissionSign(String permissionSign) {
		this.permissionSign = permissionSign;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
