package com.tmp.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import com.tmp.company.Company;
import com.tmp.company.companyDAO;
import com.tmp.utils.DBConnection;


public class CompanyManager {

	public static ArrayList<Company> getCompanyNameList(){
		Connection con = null;
		System.out.println("inside manager");
		ArrayList<Company> companies = new ArrayList<Company>();
		try{
			System.out.println("in manager of company");
			con = DBConnection.getConnection();
			
			companies = companyDAO.getComapnyName(con);
			
		}catch(Exception exp){
			exp.printStackTrace();
			System.out.println("company manager " + exp);			
		}finally{
			try {
				DBConnection.freeResources(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return companies;
	}
	public static ArrayList<Company> getCompanyNameList(int flag){
		Connection con = null;
		System.out.println("inside manager");
		ArrayList<Company> companies = new ArrayList<Company>();
		try{
			System.out.println("in manager of company");
			con = DBConnection.getConnection();
			
			companies = companyDAO.getComapnyName(flag,con);
			
		}catch(Exception exp){
			exp.printStackTrace();
			System.out.println("company manager " + exp);			
		}finally{
			try {
				DBConnection.freeResources(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return companies;
	}
 
}