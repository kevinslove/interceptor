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
       //����������ַ
       List<String> keyList = ResourcesUtil.getKeyList("anonymousURL");
     //ѭ�������������ʵ�ַ���ϣ�����ǰ���ʵ�ַ�Ƿ���������ַ�б�����ڣ��ͷŹ�
		for(String obj:keyList){
			if(url.indexOf(obj)>=0){
				return true;
			}
		}
		
		//��Ȩ��½
		List<String> keyList2 = ResourcesUtil.getKeyList("commonURL");
		//ѭ��������Ȩ���ʵ�ַ���ϣ�����ǰ���ʵ�ַ�Ƿ�����Ȩ��ַ�б�
		//����ڣ��ͷ��У���Ϊǰ���ȼ����˵�¼��֤�����������Ե���ǰȨ����֤����������������϶��ǵ�¼OK�ģ�
		for(String obj:keyList2){
			if(url.indexOf(obj)>=0){
				return true;
			}
		}
		
		//��ȡ��½session
		HttpSession session=request.getSession();
		ActiveUser attribute = (ActiveUser) session.getAttribute("auser");
		//�����û����ʵ�ַ�Ƿ�����Ȩ��ַ��Χ��
		List<Permission> permissions = attribute.getPermissions();
		for(Permission per:permissions){
			String u=per.getUrl();
			if(url.indexOf(u)>=0){
				return true;
			}
		}
		//��ַδ���䣬��ת����Ȩ��ҳ
		request.getRequestDispatcher("/refuse.jsp").forward(request, response);
		return false;
	}

}
