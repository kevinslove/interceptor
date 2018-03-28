package com.offcn.dao;

import com.offcn.po.Role;
import java.util.List;

public interface RoleMapper {   
    List<Role> findRoleList(String userid);    
}