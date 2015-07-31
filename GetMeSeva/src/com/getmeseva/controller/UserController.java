package com.getmeseva.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.getmeseva.bean.ComplaintInfo;
import com.getmeseva.bean.Departments;
import com.getmeseva.bean.District;
import com.getmeseva.bean.JsonView;
import com.getmeseva.bean.UserInfo;
import com.getmeseva.db.ComplaintDBAPI;

@Controller
public class UserController {
	
	/*@Value("${MYSQL_DB_HOST}")
	private String dbHost;
	
	@Value("${MYSQL_DB_PORT}")
	private String dbPort;
	
	@Value("${MYSQL_DB_USER}")
	private String userName;
	
	@Value("${MYSQL_DB_PWD}")
	private String password;
	
	@Value("${MYSQL_DB_NAME}")
	private String dbName;*/
	
	
	@RequestMapping("/user/showStatusForm.do")
	public ModelAndView showStatusForm(){
		return new ModelAndView("user/statusForm");
	}
	
	@RequestMapping("/user/getStatus.do")
	public ModelAndView getComplaintStatus(HttpServletRequest request,HttpServletResponse response){
		String searchType = request.getParameter("search_type");
		String searchValue = request.getParameter("search_key");
		ComplaintDBAPI dbApi = new ComplaintDBAPI();
		List<ComplaintInfo> complaintsList = dbApi.getComplaintInfo(searchType, searchValue);
		if(complaintsList == null || complaintsList.size() == 0){
			request.setAttribute("noData", true);
		}else{
			request.setAttribute("complaintsList",complaintsList);
		}
		return new ModelAndView("user/ViewComplaint");
	}
	
	@RequestMapping("/user/showRegisterForm.do")
	public ModelAndView showRegisterForm(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("deptList", new ComplaintDBAPI().getDeptList());
		return new ModelAndView("user/registerForm");
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @return
	 * 
	 * Populates districts list based on the state selected :)
	 * Returns JSON response to UI
	 */
	@RequestMapping("/user/getDistrictList.do")
	public ModelAndView getDistrictList(HttpServletRequest request,HttpServletResponse response){
		String stateId = request.getParameter("state_id");
		List<District> distList = new ComplaintDBAPI().getDistrictList(Integer.parseInt(stateId));
		HashMap<String,Object> model = new HashMap<String,Object>();
		model.put("result",distList);
		return new ModelAndView(new JsonView(),model );
	}
	
	
	@RequestMapping("/user/showComplaintForm.do")
	public ModelAndView showComplaintForm(HttpServletRequest request,HttpServletResponse response){
		Map<String,String> model = new HashMap<String,String>();
		model.put("selectedState",request.getParameter("state"));
		model.put("dist",request.getParameter("district"));
		model.put("dept",request.getParameter("deptList"));
		return new ModelAndView("user/comlaintForm",model);
	}
	
	@RequestMapping("/user/registerComlaint.do")
	public ModelAndView registerComplaint(HttpServletRequest request,HttpServletResponse response){
		District dist = new District();
		dist.setID(Integer.parseInt(request.getParameter("dist")));
		Departments dept = new Departments();
		dept.setID(Integer.parseInt(request.getParameter("dept")));
		UserInfo uInfo = new UserInfo();
		uInfo.setEmail(request.getParameter("email"));
		uInfo.setMobile(request.getParameter("mobile"));
		uInfo.setName(request.getParameter("name"));
		ComplaintInfo cInfo = new ComplaintInfo();
		cInfo.setComplaintId((dept.getID()+"")+System.currentTimeMillis());
		cInfo.setCreateTime(null);
		cInfo.setDept(dept);
		cInfo.setDescription(request.getParameter("req_desc").trim());
		cInfo.setDistrict(dist);
		cInfo.setStatus("OPEN");
		cInfo.setUserInfo(uInfo);
		new ComplaintDBAPI().createComplaint(cInfo);
		request.setAttribute("complaintId", cInfo.getComplaintId());
		return new ModelAndView("user/complaintSuccess");
	}
	
	/**
	 * @return
	 */
/*	private MysqlDatabaseInfo populateDBInfo(){
		MysqlDatabaseInfo mInfo  = new MysqlDatabaseInfo();
		mInfo.setDbHost(dbHost);
		mInfo.setDbPort(dbPort);
		mInfo.setDbName(dbName);
		mInfo.setUserName(userName);
		mInfo.setPassword(password);
		return mInfo;
	}
*/
}
