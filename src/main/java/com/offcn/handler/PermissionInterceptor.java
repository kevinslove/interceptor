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

	/**
	 * 之前编写授权拦截方法
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//1\获取访问地址
		String url = request.getRequestURI();
		
		//0\获取匿名地址
		List<String> list1 = ResourcesUtil.getKeyList("anonymousURL");
		for(String obj:list1){
			if(url.indexOf(obj)>=0){
				//对比匿名地址和请求地址,如果请求地址里面包含了匿名地址,证明用户请求的地址允许匿名访问,放行
				return true;
			}
		}
		//2\加载登录验证通过以后可以公开访问的资源地址
		List<String> list = ResourcesUtil.getKeyList("commonURL");
		
		//3\判断访问地址是否是公开地址
		for(String obj:list){
			if(url.indexOf(obj)>=0){
				return true;
			}
		}
		//4\如果不是公开访问地址,判断用户是否登录过
		HttpSession session = request.getSession();
		ActiveUser auser=null;
		auser=(ActiveUser) session.getAttribute("auser");
		
		//5\判断用户访问地址是否在授权范围内
		if(auser!=null){
		List<Permission> listPermission = auser.getPermissions();
		for (Permission permission : listPermission) {
			if(permission!=null){
			String purl=permission.getUrl();
			if(url.indexOf(purl)>=0){
				return true;
			}
			}
		}
		}
		//6\以上都没有匹配上,跳转到无权限页面
		request.getRequestDispatcher("/refuse.jsp").forward(request, response);
		
		return false;
	}

}
