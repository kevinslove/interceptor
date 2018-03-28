package com.offcn.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.offcn.po.ActiveUser;
import com.offcn.util.ResourcesUtil;

public class LogingInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}
	/**
	 * 请求处理之前的拦截方法
	 */

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//1\加载允许匿名访问的资源地址
		List<String> list = ResourcesUtil.getKeyList("anonymousURL");
		//2\获取用户请求的地址
		String url=request.getRequestURI();
		for(String obj:list){
			if(url.indexOf(obj)>=0){
				//对比匿名地址和请求地址,如果请求地址里面包含了匿名地址,证明用户请求的地址允许匿名访问,放行
				return true;
			}
			
		//3\检查是否存在登录的session
			HttpSession session = request.getSession();
			ActiveUser auser=null;
			auser=(ActiveUser) session.getAttribute("auser");
			//如果session里面能够获取到登录信息,表示用户已经登录过,直接放行
			if(auser!=null){
				return true;
			}
			
		//4\以上2种情况都不是 用户访问及不是匿名地址,也没有登陆过,直接转向到登录界面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		return false;
	}

}
