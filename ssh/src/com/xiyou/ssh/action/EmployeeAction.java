package com.xiyou.ssh.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.xiyou.ssh.entities.Employee;
import com.xiyou.ssh.service.DepartementService;
import com.xiyou.ssh.service.EmployeeService;

public class EmployeeAction extends ActionSupport implements RequestAware,
		ModelDriven<Employee>, Preparable {

	private static final long serialVersionUID = 1L;

	private String eName;
	private EmployeeService empService;
	private Integer eId;
	private InputStream inputStream;
	private DepartementService departementService;
	private Employee employee;
	private Map<String, Object> request;

	public void seteName(String eName) {
		this.eName = eName;
	}
	
	public void setDepartementService(DepartementService departementService) {
		this.departementService = departementService;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public void setEmpService(EmployeeService empService) {
		this.empService = empService;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	
	public String validateName() throws UnsupportedEncodingException {

		if (empService.eNameIsValid(eName)) {
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} else {
			inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
		}
		return "ajax";
	}

	public String save() {
		if(eId == null){
			employee.setCreateTime(new Date());
		}
		empService.saveOrUpdate(employee);
		return "save";
	}

	public void prepareSave() {
		if(eId == null){
			employee = new Employee();
		}else{
			employee = empService.getEmployeeById(eId);
		}
	}

	public String add() {
		request.put("departements", departementService.add());
		return "add";
	}

	public void prepareAdd(){
		if(eId !=null){
			//这样就可以将查到的值放到值栈栈顶，就会自己回显
			employee = empService.getEmployeeById(eId);
		}
	}
	
	public String delete() {
		try {
			empService.delete(eId);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "ajax";
	}
	
	public String getEmployees() {
		request.put("employees", empService.getEmployees());
		return "getEmployees";
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public void prepare() throws Exception {
	}

	@Override
	public Employee getModel() {
		return employee;
	}

}
