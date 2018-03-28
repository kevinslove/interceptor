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
	 * ������֮ǰ���������true�ͼ�������ִ���������ͨ����
	 * �������false�����ز�������ͨ����
	 * handler��������Ǵ�������������ڵ�Controller����
	 * request��response������Ľ��ܺͷ��ض���
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		 //������Դ�����ļ�
		List<String> keyList = ResourcesUtil.getKeyList("anonymousURL");
		//��ȡ�û����ʵ�ַ
		String uri= request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("url:"+requestURL.toString());
		System.out.println("uri:"+uri);
		//����Ƿ��ǹ�����Դ
		for(String  obj:keyList){
			if(uri.indexOf(obj)>=0){
				return true;
			}
		}
		//����Ƿ�����˵�½
		HttpSession session=request.getSession();
		ActiveUser attribute = (ActiveUser) session.getAttribute("auser");
		if(attribute!=null){
			return true;
		}
		//������������ǣ��û����ʵ�ַ�����ǹ�����ַ��Ҳû����ɵ�½��֤������ת����¼ҳ
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		return false;
	}

}
