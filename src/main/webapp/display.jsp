<%@page import="java.util.List"%>
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


<%  List<Employee> list=(List)request.getAttribute("list");%>


<table border="2px">
<tr>
<th>Id</th>
<th>Name</th>
<th>Address</th>
<th>Phone</th>
<th>Email</th>
<th>Password</th>
<th>Delete</th>
<th>Update</th>
</tr>


<% for(Employee employee:list) { %>
<tr>
	<td><%= employee.getId() %></td>
	<td><%= employee.getName() %></td>
	<td><%= employee.getAddress()%></td>
	<td><%= employee.getPhone() %></td>
	<td><%= employee.getEmail()%></td>
	<td><%= employee.getPassword() %></td>
	<td><a href="delete?id=<%= employee.getId() %>"><button>delete</button></a></td>
	<td><a href="update?id=<%= employee.getId() %>"><button>update</button></a></td>
	</tr>

<% 	
}
%>


</tbody>
</table>



</body>
</html>