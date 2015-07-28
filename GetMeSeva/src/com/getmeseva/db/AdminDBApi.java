package com.getmeseva.db;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.getmeseva.bean.Login;

public class AdminDBApi {
	
	/**
	 * @return
	 */
	public Login doLogin(Login login){
		Session sess = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Query query = sess.createQuery("from Login where userName= :id and password = :pwd");
		query.setString("id", login.getUserName());
		query.setString("pwd", login.getPassword());
		List loginList = (List)query.list();
		if(loginList != null && loginList.size() > 0){
			return (Login) loginList.get(0);
		}
		return null;
	}
	
	/**
	 * @return
	 */
	public boolean createUser(Login login){
		try{
			Session sess = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
			Transaction t = sess.beginTransaction();
			sess.persist(login);
			t.commit();
			return true;
		}catch(Exception e ){
			e.printStackTrace();
		}
		return false;
	}

}
