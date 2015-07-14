package com.getmeseva.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MANDAL")
public class Mandal {

	@Id
	private int ID;
	@Column(name="mandal_name")
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="district_id",referencedColumnName="ID")
	private District dist;

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
	 * @return the dist
	 */
	public District getDist() {
		return dist;
	}

	/**
	 * @param dist the dist to set
	 */
	public void setDist(District dist) {
		this.dist = dist;
	}
	

}
