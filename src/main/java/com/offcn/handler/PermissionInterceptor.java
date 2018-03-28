package com.offcn.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.offcn.po.ActiveUser;
import com.offcn.po.Permission;
import com.offcn.util.ResourcesUtil;

public class PermissionInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
       String url=request.getRequestURI();
       //加载匿名地址
       List<String> keyList = ResourcesUtil.getKeyList("anonymousURL");
     //循环遍历匿名访问地址集合，看当前访问地址是否在匿名地址列表，如果在，就放过
		for(String obj:keyList){
			if(url.indexOf(obj)>=0){
				return true;
			}
		}
		
		//授权登陆
		List<String> keyList2 = ResourcesUtil.getKeyList("commonURL");
		//循环遍历授权访问地址集合，看当前访问地址是否在授权地址列表，
		//如果在，就放行（因为前面先加载了登录验证拦截器，所以到当前权限验证拦截器的请求基本上都是登录OK的）
		for(String obj:keyList2){
			if(url.indexOf(obj)>=0){
				return true;
			}
		}
		
		//读取登陆session
		HttpSession session=request.getSession();
		ActiveUser attribute = (ActiveUser) session.getAttribute("auser");
		//检验用户访问地址是否在授权地址范围内
		List<Permission> permissions = attribute.getPermissions();
		for(Permission per:permissions){
			String u=per.getUrl();
			if(url.indexOf(u)>=0){
				return true;
			}
		}
		//地址未适配，跳转到无权限页
		request.getRequestDispatcher("/refuse.jsp").forward(request, response);
		return false;
	}

}
