package com.getmeseva.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author uday
 *
 */

@Entity
@Table(name="COMPLAINTS")
public class ComplaintInfo {
	
	@Id
	@Column(name="COMPLAINT_ID")
	private String complaintId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="STATUS")
	private String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="DISTRICT_ID",referencedColumnName="ID")
	private District district;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="DEPARTMENT_ID",referencedColumnName="ID")
	private Departments dept;
	
	@Column(name="COMPLAINT_TIME")
	private String createTime;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="REMARKS")
	private String remarks;
	@Column(name="IMAGE_URL")
	private String imageUrl;
	@Column(name="PIN")
	private String pin;
	@Column(name="LOCATION")
	private String location;

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="USER_INFO_ID",referencedColumnName="ID")
	private UserInfo userInfo;


	/**
	 * @return the complaintId
	 */
	public String getComplaintId() {
		return complaintId;
	}


	/**
	 * @param complaintId the complaintId to set
	 */
	public void setComplaintId(String complaintId) {
		this.complaintId = complaintId;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}


	/**
	 * @return the district
	 */
	public District getDistrict() {
		return district;
	}


	/**
	 * @param district the district to set
	 */
	public void setDistrict(District district) {
		this.district = district;
	}


	/**
	 * @return the dept
	 */
	public Departments getDept() {
		return dept;
	}


	/**
	 * @param dept the dept to set
	 */
	public void setDept(Departments dept) {
		this.dept = dept;
	}


	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}


	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}


	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}


	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	/**
	 * @return the pin
	 */
	public String getPin() {
		return pin;
	}


	/**
	 * @param pin the pin to set
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}


	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}


	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}


	/**
	 * @return the userInfo
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}


	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}	

}
