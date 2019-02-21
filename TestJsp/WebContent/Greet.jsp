<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file ="Header.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<b><i><%out.print("<h1> Welcome "+request.getParameter("uname")+" to GREET </h1>"); %></i></b>
		<%!int x=5; %>
		<% out.print("<br>"+ x);%>
		<%=x %>
		
		
		<br> <% String comp = application.getInitParameter("cogni"); %>
		<%=comp %>
	    
		<% String s = session.getAttribute("year").toString(); %>
		<%=s %>
		<jsp:forward page="Bean.jsp"></jsp:forward>
</body>
</html>