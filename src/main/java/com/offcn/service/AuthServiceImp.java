package com.offcn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.PermissionMapper;
import com.offcn.dao.RoleMapper;
import com.offcn.dao.UserMapper;
import com.offcn.po.ActiveUser;
import com.offcn.po.User;

@Service
public class AuthServiceImp implements AuthService {

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	PermissionMapper permissionMapper;
	
	@Autowired
	RoleMapper roleMapper;

	public ActiveUser authenticat(String usercode, String password) throws Exception {
		User user = userMapper.selectByAuth(usercode, password);
		ActiveUser auser=null;	
		if(user!=null){
		auser=new ActiveUser();
		auser.setUsercode(usercode);
		auser.setUserid(user.getId()+"");			
		auser.setPermissions(permissionMapper.findSysPermissionList(usercode));
		auser.setRoles(roleMapper.findRoleList(usercode));
		}
		return auser;
	}
	
	

		

}
