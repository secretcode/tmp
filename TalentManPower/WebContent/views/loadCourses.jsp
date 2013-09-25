<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tmp.training.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
		<link href="../style/multi-select.css" rel="stylesheet" type="text/css">
		<link href="../style/index.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
		<script type="text/javascript" src="../scripts/jquery.multi-select.js"></script>	    
    
</head>
<body>
<select name="loadCourses" id="loadCourses" class="textbox" multiple>
		
		<%
		ArrayList<TrainingCourses> list = (ArrayList<TrainingCourses>)request.getAttribute("coursesArray");
		if(list != null){
			for(TrainingCourses s:list){
			%>
			<option value="<%=s.getCourseName()%>"><%=s.getCourseName() %></option>	
			<%}}
		%>
		
	</select>
	
	<script language="javascript" type="text/javascript">
     $(function() {
    	  $('#loadCourses').multiSelect();
     });
     </script>
</body>
</html>