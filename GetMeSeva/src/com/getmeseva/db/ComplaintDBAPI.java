package com.getmeseva.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.getmeseva.bean.ComplaintInfo;
import com.getmeseva.bean.UserInfo;

/**
 * @author uday
 *
 */
public class ComplaintDBAPI {
	
	/**
	 * @param cInfo
	 * @param uInfo
	 * @param mInfo
	 * @return
	 */
	public boolean createComplaint(ComplaintInfo cInfo){
		
	try{	
		Session sess = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Transaction t = sess.beginTransaction();
		sess.persist(cInfo);
		t.commit();
		return true;
	}catch(Exception e){
		e.printStackTrace();
	}
		return false;
	}

	/**
	 * @param mInfo
	 * @param type
	 * @param value
	 */
	public Map<String,Object> getComplaintInfo(MysqlDatabaseInfo mInfo,String type,String value){
		try{
		/*	Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://"+mInfo.getDbHost()+":"+mInfo.getDbPort()+"/"+mInfo.getDbName(), mInfo.getUserName(), mInfo.getPassword());
			String query = "";
			if("CID".equalsIgnoreCase(type)){
			  query = "SELECT * FROM USERDETAILS UD,COMPLAINTS CMP WHERE CMP.COMPLAINT_ID = '"+value+"' AND CMP.COMPLAINT_ID = UD.COMPLAINT_ID" ;
			}else if("MOBILE".equalsIgnoreCase("")){
				query = "SELECT * FROM USERDETAILS UD,COMPLAINTS CMP WHERE UD.MOBILE = '"+value+"' AND CMP.COMPLAINT_ID = UD.COMPLAINT_ID";
			}else{
				query = "SELECT * FROM USERDETAILS UD,COMPLAINTS CMP WHERE UD.EMAIL = '"+value+"' AND CMP.COMPLAINT_ID = UD.COMPLAINT_ID";
			}
			PreparedStatement selectStatement = con.prepareStatement(query);
			ResultSet rs = selectStatement.executeQuery();
			ComplaintInfo cInfo = null;
			UserInfo uInfo = null;
			if(rs.isBeforeFirst()){
				List<ComplaintInfo> compList = new ArrayList<ComplaintInfo>();
				List<UserInfo> userList = new ArrayList<UserInfo>();
				Map<String,Object> map = new HashMap<String,Object>();
				while(rs.next()){
					cInfo = new ComplaintInfo();
					uInfo = new UserInfo();
					cInfo.setComplaintId(rs.getString("COMPLAINT_ID"));
					cInfo.setCreateTime(rs.getTimestamp("COMPLAINT_TIME").toString());
					cInfo.setDept(rs.getString("DEPARTMENT"));
					cInfo.setDescription(rs.getString("DESCRIPTION"));
					cInfo.setDistrict(rs.getString("DISTRICT"));
					cInfo.setImageUrl(rs.getString("IMAGE_URL"));
					cInfo.setLocation(rs.getString("LOCATION"));
					cInfo.setPin(rs.getString("PIN"));
					cInfo.setRemarks(rs.getString("REMARKS"));
					cInfo.setState(rs.getString("STATE"));
					cInfo.setStatus(rs.getString("STATUS"));
					compList.add(cInfo);
					uInfo.setComplaintId(rs.getString("COMPLAINT_ID"));
					uInfo.setMobile(rs.getString("MOBILE"));
					uInfo.setEmail(rs.getString("EMAIL"));
					uInfo.setName(rs.getString("NAME"));
					userList.add(uInfo);
				}
				map.put("complaintList", compList);
				map.put("userList", userList);
				return map;
			}*/
		}catch(Exception e){
			// ignore
		}
		return null;
	}
	
}
