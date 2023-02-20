package com.ty.servlets_jsp_employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.servlets_jsp_employee.dao.EmployeeDao;
import com.ty.servlets_jsp_employee.dto.Employee;

@WebServlet("/delete")
public class EmployeeDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		EmployeeDao employeeDao=new EmployeeDao();
		boolean result=employeeDao.deleteEmployee(id);
	
		if(result) {
			List<Employee> list=employeeDao.getAllEmployee();
			req.setAttribute("list", list);
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("display.jsp");
			requestDispatcher.forward(req, resp);
		}
		
		
	}

}
