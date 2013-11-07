package com.tmp.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.tmp.company.Company;
import com.tmp.utils.DBConnection;
public class companyDAO {
	protected static final Logger logger = Logger.getLogger( companyDAO.class );

	protected static final int COLUMN_ID = 1;

	/** 
	 * Index of column id
	 */
	protected static final int COLUMN_COM_NAME = 2;

	/** 
	 * Index of column com_name
	 */
	protected static final int COLUMN_CONTACT_PERSON = 3;

	/** 
	 * Index of column contact_person
	 */
	protected static final int COLUMN_ADDRESS = 4;

	/** 
	 * Index of column address
	 */
	protected static final int COLUMN_CONTACT_NO = 5;

	/** 
	 * Index of column 
	 * 
	 * 
	 * 
	 * contact_no
	 */
	public static void insertCompanyCoursesList(String cname,String cemail,int contact,String[] courses) throws Exception{
		PreparedStatement ps;
		Connection con=DBConnection.getConnection();
		int r;
		try{
			for(int i=0;i<courses.length;i++){
				ps=con.prepareStatement("insert into company_courses_list(company_name,company_email,company_contact_no,course_name) values('"+cname+"','"+cemail+"',"+contact+" ,'"+courses[i]+"')");
				r=ps.executeUpdate();
				System.out.println("1 row added in company_list table"+i);
			}
			DBConnection.freeResources(con);
		}catch(Exception e){
				e.printStackTrace();
		}
	}
	public static void insertCompany(Comp com,String comPassword) throws Exception{
		PreparedStatement ps;
		Connection con=DBConnection.getConnection();
		try{
			ps=con.prepareStatement("insert into users_login_info(login_name,email,password,roleId) values('"+com.getComUserName()+"','"+com.getComEmail()+"','"+comPassword+"',2)");
			ps.executeUpdate();
			ps=con.prepareStatement("SELECT id FROM users_login_info where login_name='"+com.getComUserName()+"' and password='"+comPassword+"'");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				ps=con.prepareStatement("insert into user_company(id,Name,Password,Email,secondaryEmail,compName,contactPerson,contactPersonDesignation,Strength,Type,Profile,Address,City,State,Country,Zip,Phone,Mobile,Fax,URL) values("+id+",'"+com.getComUserName()+"','"+comPassword+"','"+com.getComEmail()+"','"+com.getSecondaryComEmail()+"','"+com.getComName()+"','"+com.getContactPerson()+"','"+com.getContactPersonDesignation()+"','"+com.getComStrength()+"','"+com.getComType()+"','"+com.getComProfile()+"','"+com.getComAddress()+"','"+com.getComCity()+"','"+com.getComState()+"','"+com.getComCountry()+"',"+com.getComZip()+","+com.getComPhone()+","+com.getComMobile()+",'"+com.getComFax()+"','"+com.getComURL()+"')");
				ps.executeUpdate();
			}
			System.out.println("1 row added in User_company");
			DBConnection.freeResources(con);
		}catch(Exception e){
				e.printStackTrace();
		}
	}


	public static void insertJob(int id,String category,String stream,String post,String workEx,String desc,String place,int salary,int noOfEmp) throws Exception{
		try{
			Connection con=DBConnection.getConnection();
			String tableName[]=new String[4];
			tableName[0]=new String("account");
			tableName[1]=new String("engg");
			tableName[2]=new String("management");
			tableName[3]=new String("sales");
			String table=null;
			for(int i=0;i<4;i++){
				if(category.equalsIgnoreCase(tableName[i])){
					table=tableName[i];
				}
			}
			
			PreparedStatement ps=con.prepareStatement("insert into "+table+"_job(compId,stream,post,workExp,description,place,salary,no_of_emps) values('"+id+"', '"+stream+"','"+post+"','"+workEx+"','"+desc+"','"+place+"',"+salary+","+noOfEmp+")");
			ps.executeUpdate();
			System.out.println("1 row added in "+table+"_job table");
			DBConnection.freeResources(con);
		}catch(Exception e){
				e.printStackTrace();
		}
	}
	public static ArrayList<Company> getComapnyName(Connection con) throws Exception {
		
		PreparedStatement ps=con.prepareStatement("SELECT id,com_name,contact_person,address,contact_no FROM company");
		ResultSet rs=ps.executeQuery();
		ArrayList<Company> conceptInfo=new ArrayList<Company>();
		
		while(rs.next()) {
			Company dto = new Company();
			dto.setId( rs.getInt( COLUMN_ID ) );
			dto.setComName( rs.getString( COLUMN_COM_NAME ) );
			dto.setContactPerson( rs.getString( COLUMN_CONTACT_PERSON ) );
			dto.setAddress( rs.getString( COLUMN_ADDRESS ) );
			dto.setContactNo( rs.getInt( COLUMN_CONTACT_NO ) );
			conceptInfo.add( dto );
		}
		System.out.println(" arraylist size is " +conceptInfo.size());
		
		return conceptInfo;
		
	}
	public static ArrayList<Company> getComapnyName(int flag,Connection con) throws Exception {
		System.out.println("in company DAO");
		PreparedStatement ps,ps1,ps2,ps3,ps4;
		ResultSet rs=null,rs1=null,rs2=null,rs3=null;
		ArrayList<Company> conceptInfo=new ArrayList<Company>();
		if(flag==0) {
			ps=con.prepareStatement("SELECT id,com_name,contact_person,address,contact_no FROM account_company");
			rs=ps.executeQuery();
			ps1=con.prepareStatement("SELECT id,com_name,contact_person,address,contact_no FROM management_company");
			rs1=ps1.executeQuery();
			ps2=con.prepareStatement("SELECT id,com_name,contact_person,address,contact_no FROM management_company");
			rs2=ps2.executeQuery();
			ps3=con.prepareStatement("SELECT id,com_name,contact_person,address,contact_no FROM engg_company");
			rs3=ps3.executeQuery();
			

			while(rs.next()) {
				Company dto = new Company();
				dto.setId( rs.getInt( COLUMN_ID ) );
				dto.setComName( rs.getString( COLUMN_COM_NAME ) );
				dto.setContactPerson( rs.getString( COLUMN_CONTACT_PERSON ) );
				dto.setAddress( rs.getString( COLUMN_ADDRESS ) );
				dto.setContactNo( rs.getInt( COLUMN_CONTACT_NO ) );
				conceptInfo.add( dto );
			}
			
			while(rs1.next()) {
				Company dto = new Company();
				dto.setId( rs1.getInt( COLUMN_ID ) );
				dto.setComName( rs1.getString( COLUMN_COM_NAME ) );
				dto.setContactPerson( rs1.getString( COLUMN_CONTACT_PERSON ) );
				dto.setAddress( rs1.getString( COLUMN_ADDRESS ) );
				dto.setContactNo( rs1.getInt( COLUMN_CONTACT_NO ) );
				conceptInfo.add( dto );
			}
		
			while(rs2.next()) {
				Company dto = new Company();
				dto.setId( rs2.getInt( COLUMN_ID ) );
				dto.setComName( rs2.getString( COLUMN_COM_NAME ) );
				dto.setContactPerson( rs2.getString( COLUMN_CONTACT_PERSON ) );
				dto.setAddress( rs2.getString( COLUMN_ADDRESS ) );
				dto.setContactNo( rs2.getInt( COLUMN_CONTACT_NO ) );
				conceptInfo.add( dto );
			}
		
			while(rs3.next()) {
				Company dto = new Company();
				dto.setId( rs3.getInt( COLUMN_ID ) );
				dto.setComName( rs3.getString( COLUMN_COM_NAME ) );
				dto.setContactPerson( rs3.getString( COLUMN_CONTACT_PERSON ) );
				dto.setAddress( rs3.getString( COLUMN_ADDRESS ) );
				dto.setContactNo( rs3.getInt( COLUMN_CONTACT_NO ) );
				conceptInfo.add( dto );
			}
		
		return conceptInfo;
			
		}
		if(flag==1) {
			ps=con.prepareStatement("SELECT id,com_name,contact_person,address,contact_no FROM account_company");
			rs=ps.executeQuery();
		}
		else if(flag==2) {
			ps=con.prepareStatement("SELECT id,com_name,contact_person,address,contact_no FROM management_company");
			rs=ps.executeQuery();
		}
		else if(flag==3) {
			ps=con.prepareStatement("SELECT id,com_name,contact_person,address,contact_no FROM engg_company");
			rs=ps.executeQuery();
		}
		else if(flag==4) {
			ps=con.prepareStatement("SELECT id,com_name,contact_person,address,contact_no FROM sales_company");
			rs=ps.executeQuery();
		}
			
		while(rs.next()) {
			Company dto = new Company();
			dto.setId( rs.getInt( COLUMN_ID ) );
			dto.setComName( rs.getString( COLUMN_COM_NAME ) );
			dto.setContactPerson( rs.getString( COLUMN_CONTACT_PERSON ) );
			dto.setAddress( rs.getString( COLUMN_ADDRESS ) );
			dto.setContactNo( rs.getInt( COLUMN_CONTACT_NO ) );
			conceptInfo.add( dto );
		}
		
		
		System.out.println(" arraylist size is " +conceptInfo.size());
		
		return conceptInfo;
		
		
	}
}
