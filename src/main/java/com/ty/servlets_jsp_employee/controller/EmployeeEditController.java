package com.ty.servlets_jsp_employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.servlets_jsp_employee.dao.EmployeeDao;
import com.ty.servlets_jsp_employee.dto.Employee;

@WebServlet("/edit")
public class EmployeeEditController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phone= Long.parseLong(req.getParameter("phone"));

		Employee employee=new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setPhone(phone);
		
		
		EmployeeDao employeeDao=new EmployeeDao();
		Employee updatedEmployee=employeeDao.updateEmployee(employee);
		
		if(updatedEmployee!=null) {
			
			List<Employee> list=employeeDao.getAllEmployee();
			req.setAttribute("list", list);
			
			Cookie[] cookies=req.getCookies();
			String value=null;
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("name")) {
				value=cookie.getValue();
				}
			}
			req.setAttribute("name", value);
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("display.jsp");
			requestDispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(req, resp);
		
		}
		

	}

}
