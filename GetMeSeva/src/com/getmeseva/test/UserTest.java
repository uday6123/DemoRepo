package com.getmeseva.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.getmeseva.bean.ComplaintInfo;
import com.getmeseva.bean.Departments;
import com.getmeseva.bean.District;
import com.getmeseva.bean.States;
import com.getmeseva.bean.UserInfo;
import com.getmeseva.db.ComplaintDBAPI;

public class UserTest {
	public static void main(String[] args) {
		
	try{
/*		District dist = new District();
		dist.setID(9);
		Departments dept = new Departments();
		dept.setID(3);
		UserInfo uInfo = new UserInfo();
		uInfo.setEmail("gorgeous.sujitha@gmail.com");
		uInfo.setMobile("9966697025");
		uInfo.setName("suji");
		ComplaintInfo cInfo = new ComplaintInfo();
		cInfo.setComplaintId("SUJI_TEST");
		cInfo.setCreateTime(null);
		cInfo.setDept(dept);
		cInfo.setDescription("DUMMY DUMMY DUMMY");
		cInfo.setDistrict(dist);
		cInfo.setStatus("OPEN");
		cInfo.setUserInfo(uInfo);
		new ComplaintDBAPI().createComplaint(cInfo);*/
		//incr
		//Session sess = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		/*Transaction t = sess.beginTransaction();
		sess.persist(cInfo);
		Query query = sess.createQuery("from States where name = :name ");
		query.setParameter("name", "Telangana");
		States st = (States) query.list().get(0);
		query = sess.createQuery("from District where state = :name ");
		query.setInteger("name", st.getID());
		List resl = query.list();*/
		/*Query query = sess.createQuery("from  ComplaintInfo where complaintId = :id ");
		query.setParameter("id", "41437682393385");
		List temp = query.list();*/
		String type ="mobile";
		String value = "8121594236";
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
			//return temp;
		}
		
		System.out.println();
		System.out.println();
//		t.commit();
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
