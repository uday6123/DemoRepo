package com.getmeseva.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Student")
public class Student {

	public Student(){}
	
	@Id 
	@Column(name="ROLL_NUMBER")
	public int rollno;
	public String name;
	public String father;
	/**
	 * @return the rollno
	 */
	public int getRollno() {
		return rollno;
	}
	/**
	 * @param rollno the rollno to set
	 */
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the father
	 */
	public String getFather() {
		return father;
	}
	/**
	 * @param father the father to set
	 */
	public void setFather(String father) {
		this.father = father;
	}
	
}
