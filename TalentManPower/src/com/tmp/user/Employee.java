package com.tmp.user;

import java.io.Serializable;

public class Employee  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int Id=0;
	protected String Name=null;
	protected String Email=null;
	protected String Mobile=null;
	protected String Address=null;
	protected String Course=null;
	protected String Experience=null;
	
	public int getId() {
		return Id;
	}
	public String getName() {
		return Name;
	}
	public String getEmail() {
		return Email;
	}
	public String getMobile() {
		return Mobile;
	}
	public String getAddress() {
		return Address;
	}
	public String getCourse() {
		return Course;
	}
	public String getExperience() {
		return Experience;
	}
	public void setId(int id){
		this.Id=id;
	}
	public void setName(String Name){
		this.Name=Name;
	}
	public void setEmail(String Email){
		this.Email=Email;
	}
	public void setMobile(String Mobile){
		this.Mobile=Mobile;
	}
	public void setAddress(String Address){
		this.Address=Address;
	}
	public void setCourse(String Course){
		this.Course=Course;
	}
	public void setExperience(String Experience){
		this.Experience=Experience;
	}

}

