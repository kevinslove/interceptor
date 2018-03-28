package com.offcn.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.offcn.po.ActiveUser;
import com.offcn.service.AuthService;
import com.offcn.util.ResourcesUtil;

public class LoginIntercepter implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}
	@Autowired
	AuthService authServiceImp;	
	/**
	 * 请求处理之前，如果返回true就继续向下执行请求给与通过，
	 * 如果返回false就拦截不给请求通过。
	 * handler这个参数是处理这个请求所在的Controller对象，
	 * request、response是请求的接受和返回对象。
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		 //加载资源访问文件
		List<String> keyList = ResourcesUtil.getKeyList("anonymousURL");
		//获取用户访问地址
		String uri= request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("url:"+requestURL.toString());
		System.out.println("uri:"+uri);
		//检查是否是公开资源
		for(String  obj:keyList){
			if(uri.indexOf(obj)>=0){
				return true;
			}
		}
		//检查是否完成了登陆
		HttpSession session=request.getSession();
		ActiveUser attribute = (ActiveUser) session.getAttribute("auser");
		if(attribute!=null){
			return true;
		}
		//以上情况都不是，用户访问地址及不是公开地址，也没有完成登陆验证，就跳转到登录页
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		return false;
	}

}
