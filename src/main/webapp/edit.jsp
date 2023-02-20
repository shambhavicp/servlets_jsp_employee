<%@page import="com.ty.servlets_jsp_employee.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Employee employee=(Employee)request.getAttribute("employee"); %>

<form action="edit" method="post">

Id:<input type="number" name="id" placeholder="Enter your id" value= "<%= employee.getId() %>" readonly="readonly">
Name:<input type="text" name="name" placeholder="Enter your name" value="<%= employee.getName()%>" >
Address:<input type="text" name="address" placeholder="Enter your address" value= "<%= employee.getAddress() %>" >
Phone:<input type="tel" name="phone" placeholder="Enter your phone" value="<%= employee.getPhone() %>" >
Email:<input type="email" name="email" placeholder="Enter your email" value="<%= employee.getEmail() %>" >
Password:<input type="text" name="password" placeholder="Enter your password" value="<%= employee.getPassword() %>">

<input type="submit">
</form>

</body>
</html>