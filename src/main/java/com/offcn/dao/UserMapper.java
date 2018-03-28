package com.offcn.dao;

import com.offcn.po.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {  
    //用户登录验证
    User selectByAuth(@Param("username") String username,@Param("password") String password);
      
}