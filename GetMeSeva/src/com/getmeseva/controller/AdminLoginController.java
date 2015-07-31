package com.getmeseva.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.getmeseva.bean.Login;
import com.getmeseva.db.AdminDBApi;

@Controller
public class AdminLoginController {
	
	@RequestMapping("/adminlogin/login.do")
	public ModelAndView showAgentLogin(){
		return new ModelAndView("adminlogin/login");
	}
	
	
	@RequestMapping("/adminlogin/doLogin.do")
	public ModelAndView doLogin(HttpServletRequest request,HttpServletResponse response){
		Boolean isValidSession = (Boolean)request.getSession().getAttribute("isValidSession");
		if(isValidSession){
			return new ModelAndView("adminlogin/index");
		}
		request.setAttribute("loginError", true);
		return new ModelAndView("adminlogin/login");
	}

	@RequestMapping("/adminlogin/createUser.do")
	public ModelAndView createUser(HttpServletRequest request,HttpServletResponse response){
		return null;
		
	}

}
