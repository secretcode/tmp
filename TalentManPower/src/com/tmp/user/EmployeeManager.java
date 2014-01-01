package com.tmp.user;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import com.tmp.user.Employee;
import com.tmp.user.UsersDAO;
import com.tmp.utils.DBConnection;



public class EmployeeManager {
	public static ArrayList<Employee> getEmployeeNameList(int flag){
		Connection con = null;
		System.out.println("inside manager");
		ArrayList<Employee> employees = new ArrayList<Employee>();
		try{
			System.out.println("in manager of Employee");
			con = DBConnection.getConnection();
			
			employees = UsersDAO.getEmployeeName(flag,con);
			
		}catch(Exception exp){
			exp.printStackTrace();
			System.out.println("Exception in Employee Manager " + exp);			
		}finally{
			try {
				DBConnection.freeResources(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return employees;
	}
	
}
