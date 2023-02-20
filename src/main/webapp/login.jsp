<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% String message=(String)request.getAttribute("message"); %>
<%  if(message!=null) { %>

<h3><%= message %></h3>

<% } %>
	
<h3>Login page</h3>
<form action="login" method="post">

Email:<input type="email" name="email" placeholder="Enter your email">
Password:<input type="password" name="password" placeholder="Enter the password">

<input type="submit" value="login"> 



</form>
</body>
</html>