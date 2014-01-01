package com.tmp.company;

import java.io.Serializable;

public class JobList  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String Stream=null;
	protected String Post=null;
	protected String WorkEx=null;
	protected String Description=null;
	protected String Place=null;
	protected int Salary;
	protected int NoOfEmps;
	
	public int getId() {
		return id;
	}
	public String getStream() {
		return Stream;
	}
	public String getPost() {
		return Post;
	}
	public String getWorkEx() {
		return WorkEx;
	}
	public String getDescription() {
		return Description;
	}
	public String getPlace() {
		return Place;
	}
	public int getSalay() {
		return Salary;
	}
	public int getNoOfEmps(){
		return NoOfEmps;
	}
	public void setId(int id){
		this.id=id;
	}
	public void setStream(String Stream){
		this.Stream=Stream;
	}
	public void setPost(String Post){
		this.Post=Post;
	}
	public void setWorkEx(String WorkEx){
		this.WorkEx=WorkEx;
	}
	public void setDescription(String Description){
		this.Description=Description;
	}
	public void setPlace(String Place){
		this.Place=Place;
	}
	public void setSalary(int Salary){
		this.Salary=Salary;
	}	
	public void setNoOfEmps(int NoOfEmps){
		this.NoOfEmps=NoOfEmps;
	}
	protected static final int COLUMN_ID = 1;

	/** 
	 * Index of column id
	 */
	protected static final int COLUMN_STREAM = 2;

	/** 
	 * Index of column stream
	 */
	protected static final int COLUMN_POST = 3;

	/** 
	 * Index of column Post
	 */
	protected static final int COLUMN_WORK_EX = 4;

	/** 
	 * Index of column WorkEx
	 */
	protected static final int COLUMN_DESCRIPTION = 5;

	/** 
	 * Index of column description
	 */
	protected static final int COLUMN_PLACE = 6;

	/** 
	 * Index of column Place
	 */
	protected static final int COLUMN_SALARY = 7;

	/** 
	 * Index of column salary
	 */
	protected static final int COLUMN_NO_OF_EMPS = 8;

	/** 
	 * Index of column no_of_emps
	 */
	

}

