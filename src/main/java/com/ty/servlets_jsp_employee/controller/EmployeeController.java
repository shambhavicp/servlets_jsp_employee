package com.ty.servlets_jsp_employee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.servlets_jsp_employee.dao.EmployeeDao;
import com.ty.servlets_jsp_employee.dto.Employee;

@WebServlet("/save")
public class EmployeeController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String email= req.getParameter("email");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
		
		Employee employee=new Employee();
		employee.setName(name);
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setPhone(phone);
		
		EmployeeDao employeeDao=new EmployeeDao();
		Employee savedEmployee=employeeDao.savEmployee(employee);
		
		if(savedEmployee!=null) {
			
			req.setAttribute("message", "signed up successfully");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(req, resp);
			
		}
	
	}

}
