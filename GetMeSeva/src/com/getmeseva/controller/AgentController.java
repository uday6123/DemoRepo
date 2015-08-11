package com.getmeseva.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.getmeseva.bean.Login;
import com.getmeseva.db.AdminDBApi;

@Controller
public class AgentController {
	
	@RequestMapping("/agent/login.do")
	public ModelAndView showAgentLogin(HttpServletRequest request,HttpServletResponse response){
		Boolean isLoggedIn = (Boolean) request.getSession().getAttribute("isValidSession");
		if(isLoggedIn == null ||  !isLoggedIn){
			return new ModelAndView("agent/login");
		}else{
			return new ModelAndView("agent/index");
		}
	}
	
	
	@RequestMapping("/agent/doLogin.do")
	public ModelAndView doLogin(HttpServletRequest request,HttpServletResponse response){
		Boolean isValidSession = (Boolean)request.getSession().getAttribute("isValidSession");
		if(isValidSession){
			return new ModelAndView("agent/index");
		}
		request.setAttribute("loginError", true);
		return new ModelAndView("agent/login");
	}

	@RequestMapping("/agent/createUser.do")
	public ModelAndView createUser(HttpServletRequest request,HttpServletResponse response){
		return null;
		
	}

}
