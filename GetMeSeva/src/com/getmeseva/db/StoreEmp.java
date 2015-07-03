package com.getmeseva.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;



public class StoreEmp {

	public static void main(String[] args) {
		try{
	
		SessionFactory sessFact = new AnnotationConfiguration().configure().buildSessionFactory();
		Session sess = sessFact.openSession();;
		Transaction t = sess.beginTransaction();
		Employee e = new Employee();
		e.setId(2);
		e.setFname("uday");
		e.setLname("kiran");
		Student stud = new Student();
		stud.setFather("potham");
		stud.setName("pvv");
		stud.setRollno(070210507);
		sess.persist(stud);
		sess.persist(e);
		t.commit();
		sess.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
