<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% out.print("Welcome to JSP"); %>
	<%!int x=5; %>
	
	  <form class="modal-content animate" action="Greet.jsp">

   		 <div class="container">
      		 <label for="uname"><b>Username</b></label>
    	 	 <input type="text" placeholder="Enter Username" name="uname" required>

      		<label for="psw"><b>Password</b></label>
    	  	<input type="password" placeholder="Enter Password" name="psw" required>

      		<button type="submit">Login</button>
    	</div>
 	 </form>
	<% session.setAttribute("year",x); %>
</body>
</html>