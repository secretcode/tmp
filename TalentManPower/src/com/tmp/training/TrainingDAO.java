package com.tmp.training;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.PreparedStatement;

import com.tmp.utils.DBConnection;

public class TrainingDAO {
	public static ArrayList<TrainingCourses> getTrainingList(Connection con) throws Exception{
		PreparedStatement ps=con.prepareStatement("select * from training_info;");
		ResultSet rs=ps.executeQuery();
		ArrayList<TrainingCourses> result=new ArrayList<TrainingCourses>();
		while(rs.next()) {
			TrainingCourses dto=new TrainingCourses();
			dto.setId(rs.getInt(1));
			dto.setFieldName(rs.getString(2));
			dto.setCourseName(rs.getString(3));
			result.add(dto);
		}
		
		return result;
			
		}
	
	public static ArrayList<TrainingCourses> getCoursesList() throws Exception {
		Connection con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from training_info");
		ResultSet rs=ps.executeQuery();
		ArrayList<TrainingCourses> result=new ArrayList<TrainingCourses>();
		while(rs.next()) {
			TrainingCourses dto=new TrainingCourses();
			dto.setId(rs.getInt(1));
			dto.setFieldName(rs.getString(2));
			dto.setCourseName(rs.getString(3));
			result.add(dto);
		}
		DBConnection.freeResources(con);
		return result;
		
	}
		
	}

