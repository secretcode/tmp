package com.tmp.gateway;



import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmp.company.companyDAO;
import com.tmp.user.*;
import com.tmp.utils.DBConnection;
import com.tmp.training.TrainingCourses;
import com.tmp.training.TrainingDAO;

import java.util.ArrayList;
import java.sql.Connection;

import com.tmp.ve.VeEmployee;
import com.tmp.ve.VeEmployeeDao;
import com.tmp.email.*;

public class ApplicationController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	 public void init(ServletConfig config) throws ServletException{
		 super.init(config);
		 System.out.println("Inside init method of application controller servlet");
	 }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userAction = "";
		userAction = request.getParameter("action");
		System.out.println(" in the service method .......action  " + userAction);
		Users usr=null;
		RequestDispatcher rd = null;
		Connection con = null;
		String returnPath=null;
		String authResponse = "-1";
		HttpSession session;
		switch(userAction) {
		
		case  "loginUser" :
		    System.out.println("inside login");
	        
			String loginName = request.getParameter("Username");
			String passwd = request.getParameter("Password");
			String action = request.getParameter("action");
			System.out.println(loginName);
			System.out.println(passwd);
			authResponse = "-1";
			returnPath="/views/authenticationResponse.jsp";
			if(loginName == null || passwd == null) {
				action = "";
				returnPath = "/";
			}
			try{
				try{	
					try{
						con = DBConnection.getConnection();
					}catch(Exception exp){
						System.out.println("Exception occured in loginuser action od application controller"+exp);
						exp.printStackTrace();
					}
					usr  = UserManager.authenticateUser(loginName, passwd,con);
					if(usr!=null) {
						int uid=usr.getId();
						System.out.println("uid of the user is::"+uid);
						if(uid>=1){
							authResponse = "1";
						}
					}
				}catch(Exception exp){
						exp.printStackTrace();
				}
				System.out.println("b4 creating session");
				session = request.getSession(true);
				session.setAttribute("userInfo",usr);
			}			
			finally{
				try{
					DBConnection.freeResources(con);
				}catch(Exception e) {};
			}
			System.out.println(" value of returnpath is "+ returnPath);
			System.out.println("authresponse ::"+ authResponse);
			request.setAttribute("authResponse", authResponse);
			rd = request.getRequestDispatcher(returnPath);
			System.out.println("rd " + rd);
			rd.forward(request, response);
			break;
			
		case "userInfo" :
			System.out.println("in login index page;");
			returnPath = "/";
			session = request.getSession(true);
			Users user = (Users)session.getAttribute("userInfo");
			if(user!=null){
				int uid=user.getId();
				int roleId=user.getRoleId();
				try {
					con=DBConnection.getConnection();
				}catch(Exception e) {
					System.out.println("Exception occured in getting the connection in userInfo case");
				}
				usr  = UserManager.getUserInfo(uid,roleId,con);
				returnPath="views/dashBoard.jsp";
				request.setAttribute("usrName", usr.getLoginName());
			}
			rd = request.getRequestDispatcher(returnPath);
			System.out.println("rd " + rd);
			rd.forward(request, response);
			break;
		case "trainCompanyForm":
			System.out.println("insidaa application controller");
			String cname = request.getParameter("CompanyName");
			System.out.println("set company name");
			String cemail = request.getParameter("CompanyEmail");
			System.out.println("set email");
			String[] courses_names=request.getParameterValues("loadCourses");
			//System.out.println("emp course ::"+str.length + "  "+ str[0]+"  "+str[1]+"  "+str[2]);
			returnPath="/";
			int contact=0;
			try{
				contact= Integer.parseInt(request.getParameter("CompanyContactNo"));
			}
			catch(Exception e){
					System.out.println("invaaild contect no");
			}
			System.out.println("cname"+cname+" company email id"+cemail+" company contact no"+contact);
			String authResponse1 = "-1";
			try{
				try{
					con = DBConnection.getConnection();
				}catch(Exception exp){
					exp.printStackTrace();
				}
				companyDAO.insertCompanyList(cname, cemail, contact, courses_names, con);

				HttpSession session1 = request.getSession(true);
				authResponse1 = "1";
				returnPath="views/authenticationResponse.jsp";
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				try {
				DBConnection.freeResources(con);
				}catch(Exception e) {};
			}
			
			request.setAttribute("authResponse", authResponse1);
			rd = request.getRequestDispatcher(returnPath);
			System.out.println("rd " + rd);

			rd.forward(request, response);
			break;
			
		case "employeeSignUpJobForm" :
			System.out.println("inside emp sign up");		        
			String name = request.getParameter("EmpName");
			String email = request.getParameter("EmpEmail");
			String passwrd = request.getParameter("EmpPassword");
			String password=UserManager.encryptPasswordMDF(passwrd);
			String mobile = request.getParameter("EmpMobile");
			String address = request.getParameter("Empaddress");
			String course = request.getParameter("EmpCourse");
			String exp = request.getParameter("EmpExperience");
			try {
				try{
					try{
						con = DBConnection.getConnection();
					}catch(Exception xp){
							xp.printStackTrace();
					}
					UserManager.empSignUp(name,email,password,mobile,address,course,exp,con);
				}catch(Exception p){
					p.printStackTrace();
				}
				HttpSession session3 = request.getSession(true);
				authResponse = "1";
				returnPath="views/authenticationResponse.jsp";
			}					
			finally{
				try {
					DBConnection.freeResources(con);
				}catch(Exception e) {};
			}
						
			request.setAttribute("authResponse", authResponse);
			rd = request.getRequestDispatcher(returnPath);
						
			System.out.println("rd " + rd);

			rd.forward(request, response);
			break;
			
		case "companySignUpJobForm":
			System.out.println("Company Sign Up in application controller");
			String comUserName = request.getParameter("ComUserName");
			String Passwd = request.getParameter("ComPassword");
			String comPassword=UserManager.encryptPasswordMDF(Passwd);
			String comEmail = request.getParameter("ComEmail");
			String secondaryComEmail = request.getParameter("SecondaryComEmail");
			String comName = request.getParameter("ComName");
			String contactPerson = request.getParameter("ContactPerson");
			String contactPersonDesignation = request.getParameter("ContactPersonDesignation");
			String comStrength = request.getParameter("ComStrength");
			String comType = request.getParameter("ComType");
			String comProfile = request.getParameter("ComProfile");
			String comAddress = request.getParameter("ComAddress");
			String comCity = request.getParameter("ComCity");
			String comState = request.getParameter("ComState");
			String comCountry = request.getParameter("ComCountry");
			String cZip = request.getParameter("ComZip");
			String cPhone = request.getParameter("ComPhone");
			String cMobile = request.getParameter("ComMobile");
			int comZip=0,comPhone=0,comMobile=0;
			try{
				comZip=Integer.parseInt(cZip);
				comMobile=Integer.parseInt(cMobile);
				comPhone=Integer.parseInt(cPhone);
			}
			catch(Exception e){
				System.out.println("Conversion error in application controller of company sign up");
				e.printStackTrace();
			}
			String comFax = request.getParameter("ComFax");
			String comURL = request.getParameter("ComURL");			
			System.out.println(comUserName+" "+comPassword+" "+comEmail+" "+secondaryComEmail+" "+comName+" "+contactPerson+" "+contactPersonDesignation+" "+comStrength+" "+comType+" "+comProfile+" "+comAddress+" "+comCity+" "+comState+" "+comCountry+" "+comZip+" "+comPhone+" "+comMobile+" "+comFax+" "+comURL);
			String authResponse111 = "-1";
			try{
				try{
					con = DBConnection.getConnection();
				}catch(Exception t){
					t.printStackTrace();
				}
				companyDAO.insertCompany(comUserName,comPassword,comEmail,secondaryComEmail,comName,contactPerson,contactPersonDesignation,comStrength,comType,comProfile,comAddress,comCity,comState,comCountry,comZip,comPhone,comMobile,comFax,comURL,con);
				HttpSession session1 = request.getSession(true);
				authResponse111 = "1";
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				try {
				DBConnection.freeResources(con);
				}catch(Exception e) {};
			}

			returnPath="views/authenticationResponse.jsp";
			request.setAttribute("authResponse", authResponse111);
			rd = request.getRequestDispatcher(returnPath);
		
			System.out.println("rd " + rd);

			rd.forward(request, response);

			break;
			case "veForm":
			System.out.println("virtual employee ka form mil gaya");
			session = request.getSession();
			String captcha = (String) session.getAttribute("captcha");
			  String code = (String) request.getParameter("captcha");
			  
			    if (!captcha.equals(code)) {
				  request.setAttribute("message","Please enter the correct captcha code");
				  System.out.println("enter the correct captcha");
			    } else {
			    	request.setAttribute("message","");
			    	String to=request.getParameter("email");
			    	CharArrayWriterResponse customResponse  = new CharArrayWriterResponse(response);
			VeEmployee veEmployee=new VeEmployee();
			veEmployee.setSkillset(request.getParameter("skillsets"));
			veEmployee.setTitle(request.getParameter("salutation"));
			veEmployee.setFirstName(request.getParameter("name1"));
			veEmployee.setLastName(request.getParameter("lname1"));
			veEmployee.setEmail(to);
			veEmployee.setCompany(request.getParameter("company"));
			veEmployee.setDesignation(request.getParameter("designation_within_the_company"));
			veEmployee.setStreetAddress(request.getParameter("street"));
			veEmployee.setCity(request.getParameter("city"));
			veEmployee.setState(request.getParameter("state"));
			veEmployee.setPostalCode(request.getParameter("pincode"));
			veEmployee.setContactNo(request.getParameter("phone"));
			veEmployee.setCountry(request.getParameter("country"));
			veEmployee.setWebsite(request.getParameter("website"));
			veEmployee.setSkypeId(request.getParameter("skypeid"));
			try{	
				try{
					con = DBConnection.getConnection();
				}catch(Exception e){
					e.printStackTrace();
				}
				VeEmployeeDao.addEnquiry(veEmployee,con);
				authResponse = "1";

				}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				try {
				DBConnection.freeResources(con);
				}catch(Exception e) {};
			}  
			
			String subject="Confirmation Message";
			request.getRequestDispatcher("views/ve/getStartedEmail.jsp").forward(request,customResponse);
			String msg=String.format(customResponse.getOutput());
			System.out.println(msg);
			
			Mailer.send("vegetstarted@talentmanpower.com","vegetstarted@123",to, subject, msg);
		}	
			returnPath="views/confirmation.jsp";
			request.setAttribute("authResponse", authResponse);
			rd = request.getRequestDispatcher(returnPath);
		
			System.out.println("rd " + rd+"request is "+request+"  response is "+response);

			rd.forward(request, response);

			break;
			
			case "AddCompanyJobForm":
				System.out.println("AddCompanyJobForm in application controller");
				String a1 = request.getParameter("addJobCategoryValue");
				String a2 = request.getParameter("addJobStreamValue");
				String a3 = request.getParameter("Post");
				String a4 = request.getParameter("WorkExperienceRequired");
				String a5 = request.getParameter("JobDescription");
				String a6 = request.getParameter("WorkPlace");
				System.out.println("dfghhdsjk");
				int a7=0,a8=0;
				returnPath="/views/authenticationResponse.jsp";
				try{
					a7= Integer.parseInt(request.getParameter("Salary"));
					a8= Integer.parseInt(request.getParameter("EMP_Required"));
				}catch(Exception e){
					e.printStackTrace();
				}
				HttpSession session1=request.getSession();
				Users ur=(Users)session1.getAttribute("userInfo");
				int uid=ur.getId();
				System.out.println(a1+" "+a2+" "+a3+" "+a4+" "+a5+" "+a6+" "+a7+" "+a8+ " "+uid);
				
				String authResponse11 = "-1";
				Connection con11 = null;
				String returnPath11=null;
				try{
					try{
						con11 = DBConnection.getConnection();
					}catch(Exception exp1){
						exp1.printStackTrace();
					}
					companyDAO.insertJob(uid,a1,a2,a3,a4,a5,a6,a7,a8,con11);

					
					authResponse11 = "1";
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					try {
					DBConnection.freeResources(con11);
					}catch(Exception e) {};
				}
				
				request.setAttribute("authResponse", authResponse11);
				rd = request.getRequestDispatcher(returnPath);
			
				System.out.println("rd " + rd);

				rd.forward(request, response);

				break;
			
		default:
				System.out.println("this is default case msg in application controller");
			
		}
		
	}


}
