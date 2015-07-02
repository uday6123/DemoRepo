package com.getmeseva.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class StoreEmp {

	public static void main(String[] args) {
		try{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessFact = cfg.buildSessionFactory();
		Session sess = sessFact.openSession();;
		Transaction t = sess.beginTransaction();
		Employee e = new Employee();
		e.setId(1);
		e.setFname("uday");
		e.setLname("kiran");
		sess.persist(e);
		t.commit();
		sess.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
