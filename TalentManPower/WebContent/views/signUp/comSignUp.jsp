 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
 <%@ page import="com.tmp.company.Comp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	
<% Comp com=(Comp)session.getAttribute("companySignUp");%>
	Dear <%=com.getComUserName()%>,
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
		<td> Company Name : </td>
		<td><%=com.getComName() %>	</td>
	</tr>
	<tr>
		<td> Email: </td>
		<td><%=com.getComEmail() %>	</td>
	</tr>
	<tr>
		<td> Address: </td>
		<td><%=com.getComAddress() %>	</td>
	</tr>
	<tr>
		<td> Contact Number: </td>
		<td><%=com.getComPhone() %>	</td>
	</tr>
	<tr>
		<td>Secondary Email Id</td>
		<td><%=com.getSecondaryComEmail() %>	</td>
	</tr>
	<tr>
		<td>URL</td>
		<td><%=com.getComURL() %>	</td>
	</tr>
	
</table>
</body>
</html>