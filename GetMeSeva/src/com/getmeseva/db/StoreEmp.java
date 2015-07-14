package com.getmeseva.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;




public class StoreEmp {

	public static void main(String[] args) {
		try{
	
		SessionFactory sessFact = new AnnotationConfiguration().configure().buildSessionFactory();
		Session sess = sessFact.openSession();;
		Transaction t = sess.beginTransaction();
		Employee e = new Employee();
		e.setId(3);
		e.setFname("rahul");
		e.setLname("nall");
		Student stud = new Student();
		stud.setFather("uday");
		stud.setName("meduri");
		stud.setRollno(728);
		sess.persist(stud);
		sess.persist(e);
		t.commit();
		sess.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
