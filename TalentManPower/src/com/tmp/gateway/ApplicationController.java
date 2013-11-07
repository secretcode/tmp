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
import com.tmp.training.TrainingCourses;
import com.tmp.training.TrainingDAO;
import com.tmp.user.*;
import com.tmp.utils.DBConnection;
import java.sql.Connection;
import java.util.ArrayList;

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
		int retPath=0;
		userAction = request.getParameter("action");
		System.out.println(" in the service method .......action  " + userAction);
		Users usr=null;
		RequestDispatcher rd = null;
		String to;
		String returnPath="/views/authenticationResponse.jsp";
		String authResponse = "-1";
		HttpSession session=null;
		String captcha,code;
		switch(userAction) {
		
		case  "loginUser" :
		    System.out.println("inside login");
	        
			String email = request.getParameter("loginEmailId");
			String passwd = request.getParameter("password");
			String action = request.getParameter("action");
			System.out.println(email);
			System.out.println(passwd);
			try{
				try{	
					usr  = UserManager.authenticateUser(email, passwd);
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
			finally {}
			break;
			
			
		case "loadCourses" :
			System.out.println("loading courses..");
			ArrayList<TrainingCourses> courses=new ArrayList<TrainingCourses>();
			try {
				
				courses=TrainingDAO.getCoursesList();
			}catch(Exception h) {}
			retPath=1;
			returnPath="views/loadCourses.jsp";
			request.setAttribute("coursesArray", courses);
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
			int contact=0;
			try{
				contact= Integer.parseInt(request.getParameter("CompanyContactNo"));
			}
			catch(Exception e){
					System.out.println("invaaild contect no");
			}
			System.out.println("cname"+cname+" company email id"+cemail+" company contact no"+contact);
			try{
				companyDAO.insertCompanyCoursesList(cname, cemail, contact, courses_names);
				authResponse = "1";
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{}
			break;
			
		case "employeeSignUpJobForm" :
			
			System.out.println("inside emp sign up");	
			session=request.getSession();
			captcha = (String) session.getAttribute("captcha");
			System.out.println("session got" + captcha);
			code = (String) request.getParameter("captcha");
			System.out.println("captcha code is "+captcha);
			System.out.println("captcha Entered by the user is "+code);
			if (!captcha.equals(code)) {
				  authResponse="-1";
				  request.setAttribute("message","Please enter the correct captcha code");
				  System.out.println("enter the correct captcha");
			} 
			else
			{
				authResponse = "1";
				request.setAttribute("message","");
				to=request.getParameter("EmpEmail");
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
						UserManager.empSignUp(emp,password);
					}
					catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
						System.out.println("login name already existssss...!!\n\n\n\n\n\n\n\n\n\n\n\n\\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\try with new login_name");
						authResponse="-2";
						request.setAttribute("message","Login name already exits..!!");
						System.out.println("enter another username");
						break;
					}
					catch(Exception p){
						p.printStackTrace();
					}
				}
				finally{
						}
				String subject="Employee Signup Confirmation Message";
				request.getRequestDispatcher("views/signUp/empSignUp.jsp").forward(request,customResponse);
				String msg=String.format(customResponse.getOutput());
				System.out.println(msg);
				Mailer.send("no_reply@talentmanpower.com","T@lentMP#123",to, subject, msg);
			}
			break;
			
		case "companySignUpJobForm":
			session=request.getSession();
			captcha = (String) session.getAttribute("captcha");
			code = (String) request.getParameter("captcha");
			System.out.println("captcha code is "+captcha);
			System.out.println("captcha Entered by the user is "+code);
			if (!captcha.equals(code)) {
				  authResponse="-1";
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
					authResponse="1";
					companyDAO.insertCompany(com,comPassword);
				}catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
					System.out.println("login name already existssss...!!\n\n\n\n\n\n\n\n\n\n\n\n\\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\try with new login_name");
					authResponse="-2";
					request.setAttribute("message","Login name already exits..!!");
					System.out.println("enter another username");
					break;
				}
				catch(Exception e){
					e.printStackTrace();
				}
				finally{
				}
				to=com.getComEmail();
				String subject="Company Signup Confirmation Message";
				request.getRequestDispatcher("views/signUp/comSignUp.jsp").forward(request,customResponse);
				String msg=String.format(customResponse.getOutput());
				System.out.println(msg);
				Mailer.send("no_reply@talentmanpower.com","T@lentMP#123",to, subject, msg);
			}
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
		    	authResponse="1";
	    	request.setAttribute("message","");
	    	to=request.getParameter("email");
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
				VeEmployeeDao.addEnquiry(veEmployee);

			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
			}  
			
			String subject="Confirmation Message";
			request.getRequestDispatcher("views/ve/getStartedEmail.jsp").forward(request,customResponse);
			String msg=String.format(customResponse.getOutput());
			System.out.println(msg);
			try{
			Mailer.send("no_reply@talentmanpower.com","T@lentMP#123",to, subject, msg);
			}catch(Exception e){
					System.out.println("mail exceotion");
			};
		}	
			  System.out.println(request.getAttribute("message"));
			  break;
			
		case "veContactUsForm":
			System.out.println("virtual employee  contact us ka form mil gaya");
			to=request.getParameter("email");
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
				
				VeContactDao.insertDetails(veContact);
				authResponse = "1";

			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
					}  
			
			String subject="Confirmation Message";
			request.getRequestDispatcher("views/ve/contactUsEmail.jsp").forward(request,customResponse);
			String msg=String.format(customResponse.getOutput());
			System.out.println(msg);
			try{
			Mailer.send("no_reply@talentmanpower.com","T@lentMP#123",to, subject, msg);
			}catch(Exception e){
					System.out.println("mail exceotion");
			};	
		
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
				
				try{
					companyDAO.insertJob(uid,a1,a2,a3,a4,a5,a6,a7,a8);
					authResponse = "1";
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					
				}
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
					UsersDAO.contactForm(ct);
				}catch(Exception er) {
					er.printStackTrace();
				}
				finally{
						}
				authResponse="1";
				session=request.getSession();
				session.setAttribute("contactDetails", ct);
				 to=ct.getEmailId();
				subject="Thanx for contacting TalentManPower";
				request.getRequestDispatcher("views/signUp/contactDetails.jsp").forward(request,contactResponse);
				msg=String.format(contactResponse.getOutput());
				System.out.println(msg);
				Mailer.send("no_reply@talentmanpower.com","T@lentMP#123",to, subject, msg);
				break;

			case "forgotPwd" :
				System.out.println("in 4got pwd case");
				String em=request.getParameter("PwdemailId");
				System.out.println("email is is :"+ em);
				Users u=null;
				CharArrayWriterResponse forgotPwdResponse  = new CharArrayWriterResponse(response);
				try{
					u= UsersDAO.getforgotPwdDetails(em);
				}catch(Exception r){}
				finally{	}
				if(u!=null)
				{
					session=request.getSession();
					System.out.println("session b4");
					session.setAttribute("forgotPwdUser", u);
					System.out.println("session aftr");
					to=u.getEmail();
					subject="Request for new Password";
					System.out.println("b4 forward");
					request.getRequestDispatcher("views/signUp/forgotPwd.jsp").forward(request,forgotPwdResponse);
					System.out.println("aftr forward");
					msg=String.format(forgotPwdResponse.getOutput());
					System.out.println(msg);
					System.out.println("b4 sendn mail");
					Mailer.send("no_reply@talentmanpower.com","T@lentMP#123",to, subject, msg);
					System.out.println("aftr sendn mail");
					authResponse="1";	
				}
				break;
				
			case "changePwd" :
				System.out.println("in change pwd div");
				String newpwd=request.getParameter("newPwd");
				session=request.getSession();
				Users us=(Users)session.getAttribute("userInfo");
				try {
					
					UsersDAO.changePassword(newpwd,us.getId());
					authResponse="1";
				}catch(Exception e){}
				finally{}
				break;		
		default:
				System.out.println("this is default case msg in application controller");
			
		}
		if(retPath==0) {
		request.setAttribute("authResponse", authResponse);
		rd = request.getRequestDispatcher(returnPath);
		System.out.println("rd " + rd);
		rd.forward(request, response);
		}
	}


}
