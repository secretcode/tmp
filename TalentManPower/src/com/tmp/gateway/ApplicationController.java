package com.tmp.gateway;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmp.company.Comp;
import com.tmp.company.companyDAO;
import com.tmp.user.*;
import com.tmp.utils.DBConnection;
import java.sql.Connection;

import com.tmp.ve.*;
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
		HttpSession session=null;
		String captcha,code;
		switch(userAction) {
		
		case  "loginUser" :
		    System.out.println("inside login");
	        
			String loginName = request.getParameter("Username");
			String passwd = request.getParameter("password");
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
							System.out.println("setting authresponse value ");
							authResponse="1";
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
			session = request.getSession();
			String captcha3 = (String) session.getAttribute("captcha");
			String code3 = (String) request.getParameter("captcha");
			System.out.println("captcha code is "+captcha3);
			System.out.println("captcha Entered by the user is "+code3);
			if (!captcha3.equals(code3)) {
				  request.setAttribute("message","Please enter the correct captcha code");
				  System.out.println("enter the correct captcha");
			} 
			else
			{
				request.setAttribute("message","");
		    	String to=request.getParameter("EmpEmail");
		    	CharArrayWriterResponse customResponse  = new CharArrayWriterResponse(response);
		    	Employee emp=new Employee();
				emp.setName(request.getParameter("EmpName"));
				emp.setEmail(request.getParameter("EmpEmail"));
				String passwrd = request.getParameter("EmpPassword");
				String password=UserManager.encryptPasswordMDF(passwrd);
				emp.setMobile(request.getParameter("EmpMobile"));
				emp.setAddress(request.getParameter("Empaddress"));
				emp.setCourse(request.getParameter("EmpCourse"));
				emp.setExperience(request.getParameter("EmpExperience"));
				session.setAttribute("employeeSignUp",emp);
				try {
					try{
						try{
							con = DBConnection.getConnection();
						}
						catch(Exception xp){
							xp.printStackTrace();
						}
						UserManager.empSignUp(emp,password,con);
					}catch(Exception p){
						p.printStackTrace();
					}
				}
				finally{
					try {
						DBConnection.freeResources(con);
					}catch(Exception e) {};
				}
				String subject="Employee Signup Confirmation Message";
				request.getRequestDispatcher("views/signUp/empSignUp.jsp").forward(request,customResponse);
				String msg=String.format(customResponse.getOutput());
				System.out.println(msg);
				Mailer.send("vegetstarted@talentmanpower.com","vegetstarted@123",to, subject, msg);

			}
			HttpSession session3 = request.getSession(true);
			authResponse = "1";
			returnPath="views/authenticationResponse.jsp";		
			request.setAttribute("authResponse", authResponse);
			rd = request.getRequestDispatcher(returnPath);
			System.out.println("rd " + rd);
			rd.forward(request, response);
			break;
		case "companySignUpJobForm":
			session = request.getSession();
			String captcha2 = (String) session.getAttribute("captcha");
			String code2 = (String) request.getParameter("captcha");
			System.out.println("captcha code is "+captcha2);
			System.out.println("captcha Entered by the user is "+code2);
			String authResponse111 = "-1";
			if (!captcha2.equals(code2)) {
				  request.setAttribute("message","Please enter the correct captcha code");
				  System.out.println("enter the correct captcha");
			} 
			else
			{	
				request.setAttribute("message","");
		    	
		    	CharArrayWriterResponse customResponse  = new CharArrayWriterResponse(response);
		    	Comp com=new Comp();
				System.out.println("Company Sign Up in application controller");
				com.setComUserName(request.getParameter("ComUserName"));
				String Passwd = request.getParameter("ComPassword");
				String comPassword=UserManager.encryptPasswordMDF(Passwd);
				com.setComEmail(request.getParameter("ComEmail"));
				com.setSecondaryComEmail(request.getParameter("SecondaryComEmail"));
				com.setComName(request.getParameter("ComName"));
				com.setContactPerson(request.getParameter("ContactPerson"));
				com.setContactPersonDesignation(request.getParameter("ContactPersonDesignation"));
				com.setComStrength(request.getParameter("ComStrength"));
				com.setComType(request.getParameter("ComType"));
				com.setComProfile(request.getParameter("ComProfile"));
				com.setComAddress(request.getParameter("ComAddress"));
				com.setComCity(request.getParameter("ComCity"));
				com.setComState(request.getParameter("ComState"));
				com.setComCountry(request.getParameter("ComCountry"));
				String cZip=request.getParameter("ComZip");
				String cPhone=request.getParameter("ComPhone");
				String cMobile=request.getParameter("ComMobile");
				int comZip=0,comPhone=0,comMobile=0;
				try{
					com.setComZip(Integer.parseInt(cZip));
					com.setComMobile(Integer.parseInt(cMobile));
					com.setComPhone(Integer.parseInt(cPhone));
				}
				catch(Exception e){
					System.out.println("Conversion error in application controller of company sign up");
					e.printStackTrace();
				}
				com.setComFax(request.getParameter("ComFax"));
				com.setComURL(request.getParameter("ComURL"));			
				session.setAttribute("companySignUp",com);
				try{
					try{
						con = DBConnection.getConnection();
					}catch(Exception t){
						t.printStackTrace();
					}
					companyDAO.insertCompany(com,comPassword,con);
					HttpSession session1 = request.getSession(true);
					
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					try {
						DBConnection.freeResources(con);
					}catch(Exception e) {};
				}
				String to=com.getComEmail();
				String subject="Company Signup Confirmation Message";
				request.getRequestDispatcher("views/signUp/comSignUp.jsp").forward(request,customResponse);
				String msg=String.format(customResponse.getOutput());
				System.out.println(msg);
				Mailer.send("vegetstarted@talentmanpower.com","vegetstarted@123",to, subject, msg);
			}
			authResponse111 = "1";
			returnPath="views/authenticationResponse.jsp";
			request.setAttribute("authResponse", authResponse111);
			rd = request.getRequestDispatcher(returnPath);
		
			System.out.println("rd " + rd);

			rd.forward(request, response);

			break;

			
		case "veForm":
			System.out.println("virtual employee ka form mil gaya");
			session = request.getSession();
			captcha = (String) session.getAttribute("captcha");
			code = (String) request.getParameter("captcha");
			System.out.println("captcha="+captcha+"code="+code);
		    if (!captcha.equals(code)) {
			  request.setAttribute("message","Please enter the correct captcha code");
		    }
		    else {
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
			session.setAttribute("employee",veEmployee);
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
			try{
			Mailer.send("vegetstarted@talentmanpower.com","vegetstarted@123",to, subject, msg);
			}catch(Exception e){
					System.out.println("mail exceotion");
			};
		}	
			  System.out.println(request.getAttribute("message"));
			returnPath="views/confirmation.jsp";
			request.setAttribute("authResponse", authResponse);
			rd = request.getRequestDispatcher(returnPath);
		
			System.out.println("rd " + rd+"request is "+request+"  response is "+response);

			rd.forward(request, response);

			break;
			
		case "veContactUsForm":
			System.out.println("virtual employee  contact us ka form mil gaya");
			session = request.getSession();
			String to=request.getParameter("email");
	    	CharArrayWriterResponse customResponse  = new CharArrayWriterResponse(response);
	    	VeContact veContact=new VeContact();
			veContact.setRoles(request.getParameter("roles_responsibilities"));
			veContact.setWorkDomain(request.getParameter("project_work_domain"));
			veContact.setExperience(request.getParameter("years_of_experience_required"));
			veContact.setTenure(request.getParameter("tenure_of_employment"));
			veContact.setShiftTime(request.getParameter("shift_timings"));
			veContact.setFullPartTime(request.getParameter("full_time_part_time"));
			veContact.setStartTime(request.getParameter("employee_to_start"));
			veContact.setTechnicalProficiency(request.getParameter("technically_proficient"));
			veContact.setOutsourcing(request.getParameter("outsourced_before"));
			veContact.setOutsourcingDetails(request.getParameter("outsourced_details"));
			veContact.setBusinessEntity(request.getParameter("business_entity_information"));
			veContact.setBusinessDomain(request.getParameter("business_domain_area_of_operation"));
			veContact.setTimeofOperation(request.getParameter("in_operations_since"));
			veContact.setAnnualTurnover(request.getParameter("company_annual_turnover"));
			session.setAttribute("veContact",veContact);
			try{	
				try{
					con = DBConnection.getConnection();
				}catch(Exception e){
					e.printStackTrace();
				}
				VeContactDao.insertDetails(veContact,con);
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
			request.getRequestDispatcher("views/ve/contactUsEmail.jsp").forward(request,customResponse);
			String msg=String.format(customResponse.getOutput());
			System.out.println(msg);
			try{
			Mailer.send("vegetstarted@talentmanpower.com","vegetstarted@123",to, subject, msg);
			}catch(Exception e){
					System.out.println("mail exceotion");
			};	
			request.setAttribute("authResponse", authResponse);
			rd = request.getRequestDispatcher(returnPath);
		
			System.out.println("rd " + rd+"request is "+request+"  response is "+response);

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
				
				
			case "contactUsForm" :
				ContactFrm ct=new ContactFrm();
				System.out.println("contact us form");
				ct.setName(request.getParameter("contactName"));
				ct.setEmailId(request.getParameter("contactEmail"));
				ct.setPhone(request.getParameter("contactPhone"));
				ct.setSubject(request.getParameter("contactSubject"));
				ct.setComment(request.getParameter("contactDescription"));
				CharArrayWriterResponse contactResponse  = new CharArrayWriterResponse(response);
				try {
					con=DBConnection.getConnection();
					UsersDAO.contactForm(ct,con);
				}catch(Exception er) {
					er.printStackTrace();
				}
				finally{
					try {
					DBConnection.freeResources(con);
					}catch(Exception r) {}
				}
				authResponse="1";
				session=request.getSession();
				session.setAttribute("contactDetails", ct);
				 to=ct.getEmailId();
				subject="Thanx for contacting TalentManPower";
				request.getRequestDispatcher("views/signUp/contactDetails.jsp").forward(request,contactResponse);
				msg=String.format(contactResponse.getOutput());
				System.out.println(msg);
				Mailer.send("vegetstarted@talentmanpower.com","vegetstarted@123",to, subject, msg);
			
				request.setAttribute("authResponse", authResponse);
				returnPath="/views/authenticationResponse.jsp";
				rd = request.getRequestDispatcher(returnPath);
				
				System.out.println("rd " + rd);

				rd.forward(request, response);

				break;

				
				
				
		default:
				System.out.println("this is default case msg in application controller");
			
		}
		
	}


}
