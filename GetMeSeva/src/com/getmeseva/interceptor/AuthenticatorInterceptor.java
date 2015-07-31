/**
 * 
 */
package com.getmeseva.interceptor;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.getmeseva.bean.Login;
import com.getmeseva.db.AdminDBApi;



/**
 * @author uday
 *
 */
public class AuthenticatorInterceptor extends HandlerInterceptorAdapter  {
	
	private Logger log = Logger.getLogger(AuthenticatorInterceptor.class.getName());

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		boolean  isValidSession = false;
		String action = request.getParameter("action");
		if(action != null && action.equals("doLogin")){ // Login operation.
			HttpSession session = request.getSession(false);
			if(session != null && session.getAttribute("isValidSession") != null && (boolean)session.getAttribute("isValidSession")){
				return super.preHandle(request, response, handler);
			}else{
				String userName = request.getParameter("username");
				String password = request.getParameter("password");
				Login login = new Login();
				login.setUserName(userName);
				login.setPassword(password);
				if( new AdminDBApi().doLogin(login) != null){
					 Calendar cal = Calendar.getInstance(); // creates calendar
					 cal.setTime(new Date()); // sets calendar time/date
					 cal.add(Calendar.MINUTE, 20); // adds one hour
					 String val = cal.getTime().getTime()+""; 
					 Cookie login_info = new Cookie("login_info", val);
					login_info.setPath("/");
					response.addCookie(login_info);
					log.info("New session:" + login_info);
					isValidSession = true;
					request.getSession(false).setAttribute("isValidSession", isValidSession);
				}
			}
		}else if(action != null && action.equals("doLogout")){
			request.getSession().setAttribute("isValidSession", false);
			Cookie login_cook = getCookieByName("login_info", request);
			if(login_cook != null){
				login_cook.setValue(null);
				response.addCookie(login_cook);
			}
		}else{
			Cookie login_cook = getCookieByName("login_info", request);
			if(login_cook != null){
				String sessionId = login_cook.getValue();
				if(new Date().before(new Date(Long.parseLong(sessionId)))){
					request.getSession().setAttribute("isValidSession", true);
				}else{
					login_cook.setMaxAge(0);
					response.addCookie(login_cook);
					request.getSession().setAttribute("isValidSession", false);
				}
			}else{
				request.getSession().setAttribute("isValidSession", false);
			}
		}
		return super.preHandle(request, response, handler);
	}
	
	private Cookie getCookieByName(String name, HttpServletRequest request){
		String value = null;
	   	Cookie cookie = null;
	   	Cookie[] cookies = null;
	   	cookies = request.getCookies();
	    if(cookies != null)
	    {
	    	for (int i = 0; i < cookies.length; i++){
	        	cookie = cookies[i];
		        if(name.equals(cookie.getName()))
		        {
		        	return cookie;
		        }
	        }
	     }
	    return null;
	}

}
