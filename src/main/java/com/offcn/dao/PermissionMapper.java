package com.offcn.dao;

import com.offcn.po.Permission;
import java.util.List;

public interface PermissionMapper {  
    //通过userid获取用户权限
    List<Permission> findSysPermissionList(String userid);
    
}