<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bean</title>
</head>
<body bgcolor="orange">
		<jsp:useBean id="book" class="com.model.Book" scope="session"></jsp:useBean>
		<jsp:setProperty property="id" name="book" value="10"/>
		<jsp:setProperty property="title" name="book" value="Cantervile Ghost"/>
		<jsp:setProperty property="author" name="book" value="Anonymous"/>
		<jsp:setProperty property="price" name="book" value="1000000"/>
		
		Details are: <jsp:getProperty property="id" name="book"/>
					 <jsp:getProperty property="title" name="book"/>
					 <jsp:getProperty property="author" name="book"/>
					 <jsp:getProperty property="price" name="book"/>
					 
		<% String s = session.getAttribute("year").toString(); %>
		<%=s %>
		<c:set var="balance" scope="session" value="${s}"/>			 
		<c:if test="${balance>1}">
		<p>your salary is :<c:out value="${balance}"/></p>
		</c:if>
	<h1>	<c:out value="${balance} "></c:out></h1>	
	<c:out value="${s}"></c:out>		 
	
					 
</body>
</html>
