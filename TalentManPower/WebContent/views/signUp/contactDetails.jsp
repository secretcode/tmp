<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.tmp.user.ContactFrm" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% ContactFrm ct=(ContactFrm)session.getAttribute("contactDetails");%>
	Dear <%=ct.getName()%>,
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
		<td> Name : </td>
		<td><%=ct.getName() %>	</td>
	</tr>
	<tr>
		<td> Email Id: </td>
		<td><%=ct.getEmailId() %>	</td>
	</tr>
	<tr>
		<td> Contact Number : </td>
		<td><%=ct.getPhone() %>	</td>
	</tr>
	<tr>
		<td> Subect : </td>
		<td><%=ct.getSubject() %>	</td>
	</tr>
		
</table>

</body>
</html>