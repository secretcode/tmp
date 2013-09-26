 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
 <%@ page import="com.tmp.ve.VeEmployee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	
<% VeEmployee veEmployee=(VeEmployee)session.getAttribute("employee");%>
	Dear <%=veEmployee.getFirstName()%>,
	Thank you for Getting Started with TalentManPower.com. A client account manager will be contacting you shortly to:<br>
	<br>
	<ul>
		<li>Explain our business model.</li><br>
		<li>Answer any of your questions.</li><br>
		<li>Ask any questions we may have regarding your job vacancy/project.</li><br>
	</ul>
	<br>
	<br>
	Additionally, if you have any questions or would like any updates please do not hesitate to call us at any time on the numbers below<br>
	<br>
	<br>
	Best Regards,<br>
	<br>
	TalentManpower Team<br>
	Form Preview<br>
<br><br>

<table border ="2" style="width:800px;background-color:#DCF7DC;">
	<tr> TalentManPower.com - Get Started Form </tr>
	<tr> General Information</tr>
	<tr>
		<td> Salutation: </td>
		<td><%=veEmployee.getTitle() %>	</td>
	</tr>
	<tr>
		<td> Name : </td>
		<td><%=veEmployee.getFirstName() %>	</td>
	</tr>
	<tr>
		<td> Email: </td>
		<td><%=veEmployee.getEmail() %>	</td>
	</tr>
	<tr>
		<td> Skype Id: </td>
		<td><%=veEmployee.getSkypeId() %>	</td>
	</tr>
	<tr>
		<td> Contact Number: </td>
		<td><%=veEmployee.getContactNo() %>	</td>
	</tr>
	<tr> Employee Job Description</tr>
	<tr>
		<td>Skill Set</td>
		<td><%=veEmployee.getSkillset() %>	</td>
	</tr>
	<tr> Company information</tr>
	<tr>
		<td> Company Name </td>
		<td><%=veEmployee.getCompany() %>	</td>
	</tr>
	<tr>
		<td> Website: </td>
		<td><%=veEmployee.getWebsite() %>	</td>
	</tr>
	<tr> Business Address</tr>
	<tr>
		<td>Building No/ Street: </td>
		<td><%=veEmployee.getStreetAddress() %>	</td>
	</tr>
	<tr>
		<td> Town/city : </td>
		<td><%=veEmployee.getCity() %>	</td>
	</tr>
	<tr>
		<td> State :</td>
		<td><%=veEmployee.getState() %>	</td>
	</tr>
	<tr>
		<td> Country :</td>
		<td><%=veEmployee.getCountry() %>	</td>
	</tr>
	<tr>
		<td> Zip Code : </td>
		<td><%=veEmployee.getPostalCode() %>	</td>
	</tr>
</table>
</body>
</html>