package com.tmp.training;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tmp.company.Company;
import com.tmp.company.companyDAO;
import com.tmp.utils.DBConnection;

public class TrainingManager {
	public static ArrayList<TrainingCourses> getTrainingList() {
		Connection con = null;
		System.out.println("inside manager");
		ArrayList<TrainingCourses> courses = new ArrayList<TrainingCourses>();
		try{
			System.out.println("in manager of training");
			con = DBConnection.getConnection();
			
			courses = TrainingDAO.getTrainingList(con);
			
		}catch(Exception exp){
			exp.printStackTrace();
			System.out.println("training manager " + exp);			
		}finally{
			try {
				DBConnection.freeResources(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return courses;
	
	}
}
