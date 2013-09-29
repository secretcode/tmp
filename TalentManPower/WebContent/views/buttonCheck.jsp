<%@ page import="com.tmp.user.Users" %>

<%
HttpSession s=request.getSession();
Users u=(Users)s.getAttribute("userInfo");
String resp="0";
if(u==null){
	resp="0";
}
else if(u.getRoleId()==1){
	resp="1";
}
else if(u.getRoleId()==2){
	resp="2";
}
%>

<%=resp%>