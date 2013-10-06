<%@ page import="com.tmp.user.*" %>
<%@ page import="com.tmp.utils.DBConnection" %>
<%@ page import="java.sql.Connection" %>

<%
			System.out.println("in login index page;");
			Connection con=null;
			Users usr;
			String usrName=null;
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
				usrName = usr.getLoginName();
				System.out.println("usrName ::"+usrName);
			}
%>
<% if(usrName!=null) { %>
Hello <%=usrName %>
<%}%>