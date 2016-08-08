package com.xiyou.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xiyou.ssh.entities.Employee;

public class EmployeeDAO {
	
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees(){
		//String hql = "select e.E_ID,e.E_NAME, e.EMAIL, e.BIRTH, e.CREATE_TIME, e.DEPT_ID from EMPLOYEE e";
		String hql = "from Employee e left outer join fetch e.dept order by e.eId";
		return getSession().createQuery(hql).list();
	}
	
	public void delete(Integer eId){
		String hql = "delete from Employee e where e.eId = ?";
		getSession().createQuery(hql).setInteger(0, eId).executeUpdate();
	}
	
	public void  saveOrUpdate(Employee employee){
		getSession().saveOrUpdate(employee);
	}
	
	public  Employee getEmployeeByeName(String eName){
		String hql = "from Employee e where e.eName = ?";
		Query query = getSession().createQuery(hql).setString(0, eName);
		return (Employee) query.uniqueResult();
	}
	
	public Employee getEmployeeById(Integer eId){
		String hql = "from Employee e where e.eId = ?";
		return (Employee) getSession().createQuery(hql).setInteger(0, eId).uniqueResult();
	}
	
}
