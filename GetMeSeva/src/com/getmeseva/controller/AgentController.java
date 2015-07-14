package com.getmeseva.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AgentController {
	
	@RequestMapping("/agentLogin.do")
	public ModelAndView showLogin(){
		return new ModelAndView("login");
	}
	
	@RequestMapping("/doLogin.do")
	public ModelAndView doLogin(HttpServletRequest request,HttpServletResponse response){
		String userName = request.getParameter("user_id");
		String pwd = request.getParameter("agent_pwd");
		
		return null;
	}

}
