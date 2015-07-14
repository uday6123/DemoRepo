package com.getmeseva.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DISTRICT")
public class District {

	@Id
	private int ID;
	@Column(name="district_name")
	private String name;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="state_id",referencedColumnName="ID")
	private States state;
	
	
	
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
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
	 * @return the state
	 */
	public States getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(States state) {
		this.state = state;
	}
}
