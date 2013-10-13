<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.tmp.user.Users" %>
     <%@ page import="com.tmp.user.UsersDAO" %>
    <%@ page import="java.util.Random" %>
    <%@ page import="com.tmp.utils.DBConnection" %>
<%@ page import="java.sql.Connection" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<% 
System.out.println("in jsppp");
Users usr=(Users)session.getAttribute("forgotPwdUser");
Random r = new Random();
char data[]={'z','e', 't', 'c', 'o', 'd', 'e','l', 'i', 'n', 'u', 'x','f', 'r', 'e', 'e', 'b', 's', 'd','u', 'b', 'u', 'n', 't', 'u','j', 'e', 'e','a','0','2','3','4','5','w'};
int index = Math.abs(r.nextInt()) % 5;
int diff= Math.abs(r.nextInt()) % 10;
if (diff<5)
	diff+=5;
String captcha="";
for (;index<data.length;index+=diff)
{
	captcha+=data[index];
}
Connection con=DBConnection.getConnection();
%>
	Dear <%=usr.getLoginName()%>,
	You requested for a new Password generation <br>
	Given below is a new combination of UserName and password through which you can login into Talent Man Power, and then reset your Password as desired<br><br>
	<br>
	<ul>
		<li>UserName : <%=usr.getLoginName() %></li><br>
		<li>Password : <%=captcha %></li><br>
		<%UsersDAO.changePassword(captcha,usr.getId(),con); %>
	</ul>
	<br>
	<br>
	Best Regards,<br>
	<br>
	TalentManpower Team<br>
	Form Preview<br>
<br><br>



</body>
</html>