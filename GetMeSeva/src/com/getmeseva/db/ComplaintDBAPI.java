package com.getmeseva.db;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.getmeseva.bean.ComplaintInfo;
import com.getmeseva.bean.Departments;
import com.getmeseva.bean.District;

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
	 * @param state_id
	 * @return
	 */
	public List<District> getDistrictList(int state_id){
		Session sess = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Query query = sess.createQuery("from District where state = :id ");
		query.setInteger("id", state_id);
		return  (List<District>)query.list();
	}
	
	/**
	 * @return
	 */
	public List<Departments> getDeptList(){
		Session sess = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Query query = sess.createQuery("from Departments");
		return  (List<Departments>)query.list();
	}

	/**
	 * @param mInfo
	 * @param type
	 * @param value
	 */
	public List<ComplaintInfo> getComplaintInfo(String type,String value){
		try{
			Session sess = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
			String sql = "";
			if("complaint_id".equals(type)){
				sql = "from  ComplaintInfo where complaintId = :id";
			}else{
				sql = "select ci from ComplaintInfo ci , UserInfo ui where ui."+ type +"= :id and ci.userInfo = ui.userId";
			}
			Query query = sess.createQuery(sql);
			query.setParameter("id", value);	
			List<ComplaintInfo> temp = (List<ComplaintInfo>)query.list();
			if(temp != null && temp.size() >0){
				return temp;
			}
		}catch(Exception e){
			// ignore
		}
		return null;
	}
	
}
