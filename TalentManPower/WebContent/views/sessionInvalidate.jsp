<%
	HttpSession s=request.getSession();
	System.out.println("session destroyed");
	s.invalidate();
%>