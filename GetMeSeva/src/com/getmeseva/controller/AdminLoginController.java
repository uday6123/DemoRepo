package com.getmeseva.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AdminLoginController {
	
	@RequestMapping("/login.do")
	public ModelAndView showAgentLogin(){
		return new ModelAndView("login");
	}
	
	
	@RequestMapping("/dologin.do")
	public ModelAndView doLogin(HttpServletRequest request,HttpServletResponse response){
		if(!"POST".equalsIgnoreCase(request.getMethod())){
			request.setAttribute("loginError", true);
			return new ModelAndView("login");
		}
		
		return new ModelAndView("requestsView");
	}

	@RequestMapping("/createUser.do")
	public ModelAndView createUser(HttpServletRequest request,HttpServletResponse response){
		return null;
		
	}

}
