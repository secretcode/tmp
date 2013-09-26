package com.tmp.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

import com.tmp.company.Company;

public class UsersDAO {

	public static Users authenticateUser(String loginName,String password,Connection con) throws Exception{
		PreparedStatement ps=con.prepareStatement("SELECT uid, login_name, password,roleId FROM users_info where login_name='"+loginName+"' and password='"+password+"'");
		ResultSet rs=ps.executeQuery();
		Users dto=new Users();
		while(rs.next()) {
			dto.setUid( rs.getInt(1) );
			dto.setLoginName( rs.getString( 2 ) );
			dto.setPassword( rs.getString( 3 ) );
			dto.setRoleId(rs.getInt(4));
			
		}		
		if(dto!=null){
			System.out.println("Authentication successful");
			System.out.println(dto);
		}
		else{
			System.out.println("Authentication failed");
		}
		return dto;
	}
	
	public static void empSignUp(String name,String email,String password,String mobile,String address,String course,String exp,Connection con) throws Exception{
		System.out.println("in dao");
		PreparedStatement ps=con.prepareStatement("insert into users_info(Name,Email,Password,Mobile,Address,Course,Experience) values('"+name+"','"+email+"','"+password+"','"+mobile+"','"+address+"','"+course+"','"+exp+"')");
		int rs=ps.executeUpdate();
		System.out.println("inserting into users_info  "+rs);
		
	}


	public static Users getUserInfo(int uid,int roleId,Connection con) throws Exception {
		PreparedStatement ps=null;
		if(roleId==1){
			ps=con.prepareStatement("select Name from users_info where uid='"+uid+"'");
		}
		else if(roleId==2){
			ps=con.prepareStatement("select Name from company_info where uid='"+uid+"'");
		}
		ResultSet rs=ps.executeQuery();
		Users dto=new Users();
		while(rs.next()) {
			dto.setLoginName(rs.getString(1));
		}
		System.out.println(dto);
		return dto;
		}		
	
	
	public static String getResumePath(int uid,Connection con) throws Exception {
		PreparedStatement ps=con.prepareStatement("select link from resume where id="+uid+";");
		ResultSet rs=ps.executeQuery();
		String filePath=null;
		while(rs.next()) {
			filePath=rs.getString("link");
			System.out.println(filePath);
		}
		return filePath;
		
	}
	
	public static ArrayList<Employee> getEmployeeName(int flag,Connection con) throws Exception {
		String field[]=new String[4];
		field[0]=new String("'B.Tech','M.Tech','MCA','MS'");
		field[1]=new String("'MBA'");
		field[2]=new String("'CA','CS'");
		field[3]=new String("");
		String wherec=null;
		for(int i=0;i<4;i++){
			if(i==(flag-1)){
				wherec=field[i];
			}
		}
		System.out.println(wherec);
		PreparedStatement ps = con.prepareStatement("SELECT uid,Name,Email,Password,Mobile,Address,Course,Experience FROM users_info where Course in ("+wherec+");");
		ResultSet rs=ps.executeQuery();
		ArrayList<Employee> employees=new ArrayList<Employee>();
		
		while(rs.next()) {
			Employee emp = new Employee();
			emp.setId( rs.getInt("uid") );
			emp.setName( rs.getString("Name") );
			emp.setEmail( rs.getString("Email") );
			emp.setMobile( rs.getString("Mobile") );
			emp.setAddress( rs.getString("Address") );
			emp.setCourse( rs.getString("Course") );
			emp.setExperience( rs.getString("Experience") );
			employees.add( emp );
		}
		System.out.println(" arraylist size is " +employees.size());
		
		return employees;
	
	
		}
	}