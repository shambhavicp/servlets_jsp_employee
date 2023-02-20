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
import javax.servlet.http.HttpSession;

import com.ty.servlets_jsp_employee.dao.EmployeeDao;
import com.ty.servlets_jsp_employee.dto.Employee;

@WebServlet("/login")
public class EmployeeLoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		EmployeeDao employeeDao=new EmployeeDao();
		Employee employee=employeeDao.loginEmployeebyEmail(email);
		
		if(employee.getPassword().equals(password)) {
//			Cookie cookie=new Cookie("name", employee.getName());
//			resp.addCookie(cookie);
//			
			HttpSession httpSession=req.getSession();
			httpSession .setAttribute("name", employee.getName());
			
			List<Employee> list=employeeDao.getAllEmployee();		
			req.setAttribute("list", list);
			
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("display.jsp");
			requestDispatcher.forward(req, resp);
			
		}else {
			req.setAttribute("message", "Invalid password");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
			requestDispatcher.include(req, resp);
			
		}
	}

}
