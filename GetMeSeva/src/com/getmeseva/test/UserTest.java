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

public class UserTest {
	public static void main(String[] args) {
		
	try{
		/*District dist = new District();
		dist.setID(1);
		dist.setName("Srikakulam");
		States state = new States();
		state.setID(1);
		state.setName("Andhra Pradesh");
		dist.setState(state);
		Departments dept = new Departments();
		dept.setID(1);
		dept.setName("Education");
		UserInfo uInfo = new UserInfo();
		uInfo.setEmail("uday6123@gmai.com");
		uInfo.setMobile("8121594236");
		uInfo.setName("uk");
		ComplaintInfo cInfo = new ComplaintInfo();
		cInfo.setComplaintId("TEST123");
		cInfo.setCreateTime(null);
		cInfo.setDept(dept);
		cInfo.setDescription("DUMMY DUMMY DUMMY");
		cInfo.setDistrict(dist);
		cInfo.setStatus("OPEN");
		cInfo.setUserInfo(uInfo);*/
		//incr
		Session sess = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		//Transaction t = sess.beginTransaction();
		//sess.persist(cInfo);
		Query query = sess.createQuery("from ComplaintInfo where complaintId = :id ");
		query.setParameter("id", "TEST123");
		List orderList = query.list();
		System.out.println();
//		t.commit();
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
