package com.getmeseva.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;













import com.getmeseva.bean.ComplaintInfo;
import com.getmeseva.bean.UserInfo;
import com.getmeseva.db.ComplaintDBAPI;
import com.getmeseva.db.MysqlDatabaseInfo;

@Controller
public class UserController {
	
	@Value("${MYSQL_DB_HOST}")
	private String dbHost;
	
	@Value("${MYSQL_DB_PORT}")
	private String dbPort;
	
	@Value("${MYSQL_DB_USER}")
	private String userName;
	
	@Value("${MYSQL_DB_PWD}")
	private String password;
	
	@Value("${MYSQL_DB_NAME}")
	private String dbName;
	
	
	@RequestMapping("/showStatusForm.do")
	public ModelAndView showStatusForm(){
		return new ModelAndView("statusForm");
	}
	
	@RequestMapping("/getStatus.do")
	public ModelAndView getComplaintStatus(HttpServletRequest request,HttpServletResponse response){
		String searchType = request.getParameter("search_type");
		String searchValue = request.getParameter("search_key");
		ComplaintDBAPI dbApi = new ComplaintDBAPI();
		Map<String, Object> infoMap = dbApi.getComplaintInfo(populateDBInfo(), searchType, searchValue);
		List<ComplaintInfo> compList  = (List<ComplaintInfo>) infoMap.get("complaintList");
		Collections.sort(compList,new Comparator<ComplaintInfo>() {

			@Override
			public int compare(ComplaintInfo o1,ComplaintInfo o2) {
				return o1.getComplaintId().compareTo(o2.getComplaintId());
			}
		});
		List<UserInfo> userList  = (List<UserInfo>) infoMap.get("userList");
		Collections.sort(userList,new Comparator<UserInfo>() {

			@Override
			public int compare(UserInfo o1,UserInfo o2) {
				return o1.getComplaintId().compareTo(o2.getComplaintId());
			}
		});
		request.setAttribute("complaintList", compList);
		request.setAttribute("userList", userList);
		return new ModelAndView("ViewComplaint");
	}
	
	@RequestMapping("/showRegisterForm.do")
	public ModelAndView showRegisterForm(HttpServletRequest request,HttpServletResponse response){
		List<String> distList = new ArrayList<String>();
		distList.add("Srikakulam");
		distList.add("East Godavari");
		distList.add("West Godavari");
		distList.add("Visakhapatnam");
		request.setAttribute("districtList", distList);
		return new ModelAndView("registerForm");
	}
	
	
	@RequestMapping("/showComplaintForm.do")
	public ModelAndView showComplaintForm(HttpServletRequest request,HttpServletResponse response){
		
		return new ModelAndView("comlaintForm");
	}
	
	@RequestMapping("/registerComlaint.do")
	public ModelAndView registerComplaint(HttpServletRequest request,HttpServletResponse response){
		//populate all the complaintInfo and Userinfo
				ComplaintInfo cInfo = new ComplaintInfo();
				cInfo.setDept("REVENUE");
				cInfo.setDescription(request.getParameter("req_desc"));
				/*cInfo.setDistrict(request.getParameter("selectedDist"));
				cInfo.setState(request.getParameter("selectedState"));*/
				cInfo.setDistrict("SRIKAKULAM");
				cInfo.setState("AP");
				cInfo.setStatus("Open");
				
				UserInfo uInfo = new UserInfo();
				uInfo.setMobile(request.getParameter("mobile"));
				uInfo.setEmail(request.getParameter("email"));
				uInfo.setName(request.getParameter("name"));
				request.setAttribute("complaintId", "CID1333");
				ComplaintDBAPI api =new ComplaintDBAPI();
				
				api.createComplaint(cInfo, uInfo,populateDBInfo());
		return new ModelAndView("complaintSuccess");
	}
	
	/**
	 * @return
	 */
	private MysqlDatabaseInfo populateDBInfo(){
		MysqlDatabaseInfo mInfo  = new MysqlDatabaseInfo();
		mInfo.setDbHost(dbHost);
		mInfo.setDbPort(dbPort);
		mInfo.setDbName(dbName);
		mInfo.setUserName(userName);
		mInfo.setPassword(password);
		return mInfo;
	}

}
