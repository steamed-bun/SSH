package com.xiyou.ssh.service;

import java.util.List;

import com.xiyou.ssh.dao.EmployeeDAO;
import com.xiyou.ssh.entities.Employee;

public class EmployeeService {
	
	private EmployeeDAO empDAO;
	public void setEmpDAO(EmployeeDAO empDAO) {
		this.empDAO = empDAO;
	}
	
	public List<Employee> getEmployees(){
		return empDAO.getEmployees();
	}
	
	public void delete(Integer eId){
		empDAO.delete(eId);
	}
	
	public void saveOrUpdate(Employee employee ){
		empDAO.saveOrUpdate(employee);
	}
	
	public boolean eNameIsValid(String eName){
		return empDAO.getEmployeeByeName(eName) == null;
	}
	
	public Employee getEmployeeById(Integer eId){
		return empDAO.getEmployeeById(eId);
	}
	
}
