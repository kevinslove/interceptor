package com.offcn.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.offcn.po.ActiveUser;
import com.offcn.service.AuthService;
import com.offcn.service.AuthServiceImp;

@Controller
public class LoginController {

	@Autowired
	AuthService authServiceImp;
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(String username,String password,HttpSession session,RedirectAttributes model){
		ActiveUser auser = null;
		try {
			auser = authServiceImp.authenticat(username, password);
			session.setAttribute("auser", auser);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		if(auser!=null){
			
			return "index";
		}else{
			session.setAttribute("msg", "帐号或者密码错误!");  
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String logout(HttpSession session,RedirectAttributes model){
		session.removeAttribute("msg");
		session.removeAttribute("auser");
		return "redirect:/";
	}
}
