package com.tmp.ve;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class VeEmployeeDao {

	public static void addEnquiry(VeEmployee veEmployee, Connection con) {
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps=con.prepareStatement("insert into veEmployee(skillset,title,first_name,last_name,email,company,designation,street_address,city,state,postal_code,contact_no,country,website,skype_id) values	('"+veEmployee.getSkillset()+"','"+veEmployee.getTitle()+"','"+veEmployee.getFirstName()+"','"+veEmployee.getLastName()+"','"+veEmployee.getEmail()+"','"+veEmployee.getCompany()+"','"+veEmployee.getDesignation()+"','"+veEmployee.getStreetAddress()+"','"+veEmployee.getCity()+"','"+veEmployee.getState()+"','"+veEmployee.getPostalCode()+"','"+veEmployee.getContactNo()+"','"+veEmployee.getCountry()+"','"+veEmployee.getWebsite()+"','"+veEmployee.getSkypeId()+"')");
			int i=ps.executeUpdate();
			System.out.println("1 row added in ve table "+ i);
	
		}catch(Exception e){
				e.printStackTrace();
		}

		
		
	}

}