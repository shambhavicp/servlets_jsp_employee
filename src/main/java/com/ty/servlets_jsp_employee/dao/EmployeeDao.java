package com.ty.servlets_jsp_employee.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.servlets_jsp_employee.dto.Employee;

public class EmployeeDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	public Employee savEmployee(Employee employee) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}
	
	public Employee loginEmployeebyEmail(String email) {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select e from Employee e where e.email=?1");
		query.setParameter(1, email);
		Employee employee=(Employee)query.getSingleResult();
		return employee;
	}
	
	public List<Employee> getAllEmployee(){
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select e from Employee e");
		List<Employee> list=query.getResultList();
		return list;
	}
	public boolean deleteEmployee(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Employee employee=entityManager.find(Employee.class, id);
		if(employee!=null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}
	
	public Employee getEmployeeById(int id) {
		return getEntityManager().find(Employee.class, id);
	}
	
	
	public Employee updateEmployee(Employee employee) {
		
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();
			return employee;
		}
		
	
	
}
