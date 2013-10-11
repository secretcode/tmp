package com.tmp.ve;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class VeContactDao {

	public static void insertDetails(VeContact veContact, Connection con) {
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps=con.prepareStatement("insert into ve_contactus (roles,work_domain,experience,tenure,shift_time,full_part_time,start_time,technical_proficiency,outsourcing,outsourcing_details,business_entity,business_domain,time_of_operation,annual_turnover) values	('"+veContact.getRoles()+"','"+veContact.getWorkDomain()+"','"+veContact.getExperience()+"','"+veContact.getTenure()+"','"+veContact.getShiftTime()+"','"+
					veContact.getFullPartTime()+"','"+veContact.getStartTime()+"','"+veContact.getTechnicalProficiency()+"','"+veContact.getOutsourcing()+"','"+veContact.getOutsourcingDetails()+"','"+veContact.getBusinessEntity()+"','"+veContact.getBusinessDomain()+"','"+
					veContact.getTimeofOperation()+"','"+veContact.getAnnualTurnover()+"')");
			int i=ps.executeUpdate();
			System.out.println("1 row added in ve contact table "+ i);
	
		}catch(Exception e){
				e.printStackTrace();
		}

		
		
	}
}
