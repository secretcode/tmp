package com.tmp.training;

public class TrainingCourses {
	protected  int id;
	protected String CourseName;
	protected String FieldName;
	
	public String getFieldName() {
		return FieldName;
	}
	public String getCourseName() {
		return CourseName;
	}

	public int getId() {
		return id;
	}
	
	public void setFieldName(String field) {
		FieldName=field;
	}
	
	public void setCourseName(String course) {
		CourseName=course;
	}
	
	public void setId(int uid) {
		id=uid;
	}
	

}
