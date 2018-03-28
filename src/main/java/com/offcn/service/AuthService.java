package com.offcn.service;
import org.springframework.stereotype.Service;
import com.offcn.po.ActiveUser;
@Service
public interface AuthService {
	
	public ActiveUser authenticat(String usercode, String password)
			throws Exception;
	
}
