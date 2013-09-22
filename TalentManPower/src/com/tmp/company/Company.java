package com.tmp.company;

import java.io.Serializable;

public class Company  implements Serializable{
	protected String comName=null;
	protected String Contact_person=null;
	protected int id;
	protected String address=null;
	protected int Contact_no;
	protected String stream;
	public String getComName() {
		return comName;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream=stream;
	}
	public String getContactPerson() {
		return Contact_person;
	}
	public int getContactNo() {
		return Contact_no;
	}
	public String getAddress() {
		return address;
	}
	public int getId() {
		return id;
	}
	public void setComName(String comName){
		this.comName=comName;
	}
	public void setContactPerson(String Contact_person){
		this.Contact_person=Contact_person;
	}
	public void setId(int id){
		this.id=id;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public void setContactNo(int contact_no){
		this.Contact_no=contact_no;
	}
	protected static final int COLUMN_ID = 1;

	/** 
	 * Index of column id
	 */
	protected static final int COLUMN_COM_NAME = 2;

	/** 
	 * Index of column com_name
	 */
	protected static final int COLUMN_CONTACT_PERSON = 3;

	/** 
	 * Index of column contact_person
	 */
	protected static final int COLUMN_ADDRESS = 4;

	/** 
	 * Index of column address
	 */
	protected static final int COLUMN_CONTACT_NO = 5;

	/** 
	 * Index of column contact_no
	 */
	

}

