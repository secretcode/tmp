package com.tmp.user;

public class ContactFrm {
	private String name;
	private String emailId;
	private String phone;
	private String subject;
	private String comment;
	
	public String getName() {
		return name;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getPhone() {
		return phone;
	}

	public String getSubject() {
		return subject;
	}

	public String getComment() {
		return comment;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setEmailId(String emailId) {
		this.emailId=emailId;
	}
	
	public void setPhone(String phone) {
		this.phone=phone;
	}
	
	public void setSubject(String subject) {
		this.subject=subject;
	}
	
	public void setComment(String comment) {
		this.comment=comment;
	}

}
