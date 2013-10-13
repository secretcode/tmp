package com.tmp.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

import com.tmp.company.Company;

public class UsersDAO {

public static Users authenticateUser(String loginName,String password,Connection con) throws Exception{
		
		PreparedStatement ps=con.prepareStatement("SELECT id, login_name, password,roleId,email FROM users_login_info where login_Name='"+loginName+"' and password='"+password+"'");
		ResultSet rs=ps.executeQuery();
		Users dto=new Users();
		while(rs.next()) {
			dto.setId( rs.getInt(1) );
			dto.setLoginName( rs.getString( 2 ) );
			dto.setPassword( rs.getString( 3 ) );
			dto.setRoleId(rs.getInt(4));
			dto.setEmail(rs.getString(5));
		}		
		if(dto.getId()==0){
			System.out.println("Authentication failed");
		}
		else{
			System.out.println("Authentication successful");
			System.out.println(dto);
		}
		
		return dto;
	}
	
	public static void empSignUp(String name,String email,String password,String mobile,String address,String course,String exp,Connection con) throws Exception{
		try{
			PreparedStatement ps=con.prepareStatement("insert into users_login_info(login_name,password,roleId,email) values('"+name+"','"+password+"',1,'"+email+"')");
			ps.executeUpdate();
			PreparedStatement ps1=con.prepareStatement("SELECT id FROM users_login_info where login_name='"+name+"' and password='"+password+"'");
			ResultSet rs=ps1.executeQuery();
			int uid=0;
			while(rs.next()){
				uid=rs.getInt("id");
			}
			System.out.println("id is "+uid);
			PreparedStatement ps2=con.prepareStatement("insert into users_info(id,Name,Email,Password,Mobile,Address,Course,Experience) values("+uid+",'"+name+"','"+email+"','"+password+"','"+mobile+"','"+address+"','"+course+"','"+exp+"')");
			ps2.executeUpdate();
		}catch(Exception e){
			System.out.println("Exception in emp sign up "+e);
			e.printStackTrace();
			
		}
	}


	public static Users getUserInfo(int uid,int roleId,Connection con) throws Exception {
		PreparedStatement ps=null;
		if(roleId==1){
			ps=con.prepareStatement("select Name from users_info where id='"+uid+"'");
		}
		else if(roleId==2){
			ps=con.prepareStatement("select Name from user_company where id='"+uid+"'");
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
	
	
	public static void contactForm(ContactFrm ct,Connection con) throws Exception{
		PreparedStatement ps=con.prepareStatement("insert into contactDetails(Name,EmailId,Phone,Subject,Comment) values('"+ct.getName()+"','"+ct.getEmailId()+"','"+ct.getPhone()+"','"+ct.getSubject()+"','"+ct.getComment()+"')");
		int r=ps.executeUpdate();

	
	}
	
	
	public static Users getforgotPwdDetails(String emailId, Connection con) throws Exception{
		PreparedStatement ps=con.prepareStatement("Select * from users_login_info where email='"+emailId+"'");
		ResultSet rs=ps.executeQuery();
		Users dto=new Users();
		while(rs.next()){
			dto.setId( rs.getInt(1) );
			dto.setLoginName( rs.getString( 2 ) );
			dto.setPassword( rs.getString( 3 ) );
			dto.setRoleId(rs.getInt(4));
			dto.setEmail(rs.getString(5));
	
		}
		System.out.println(dto);
		return dto;
		
	}	
	
	public static void changePassword(String pwd, int id, Connection con) throws Exception {
		String newpwd=UserManager.encryptPasswordMDF(pwd);
		System.out.println("pwd is "+pwd+"       "+newpwd);
		PreparedStatement ps=con.prepareStatement("update users_login_info set password='"+newpwd+"' where id='"+id+"';");
		int r=ps.executeUpdate();
		ps=con.prepareStatement("update users_info set Password='"+newpwd+"' where id='"+id+"';");
		r=ps.executeUpdate();
		ps=con.prepareStatement("update user_company set Password='"+newpwd+"' where id='"+id+"';");
		r=ps.executeUpdate();
		System.out.println("passwdrd changed");
	
	}
}
