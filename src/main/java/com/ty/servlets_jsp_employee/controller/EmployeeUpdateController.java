package com.ty.servlets_jsp_employee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.ty.servlets_jsp_employee.dao.EmployeeDao;
import com.ty.servlets_jsp_employee.dto.Employee;

@WebServlet("/update")
public class EmployeeUpdateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		EmployeeDao employeeDao=new EmployeeDao();
		Employee employee= employeeDao.getEmployeeById(id);
		
		if(employee!=null) {
			HttpSession httpSession=req.getSession();
			String value=(String)httpSession.getAttribute("name");
			if(value!=null) {
		
			req.setAttribute("employee", employee);
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("edit.jsp");
			requestDispatcher.forward(req, resp);
			}else {
				req.setAttribute("message", "Login first to update");
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(req, resp);
				
			}
			
			
		}
	}
}
