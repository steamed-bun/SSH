package com.xiyou.ssh.service;

import java.util.List;

import com.xiyou.ssh.dao.DepartementDAO;
import com.xiyou.ssh.entities.Departement;

public class DepartementService {

	private DepartementDAO departementDAO;

	public void setDepartementDAO(DepartementDAO departementDAO) {
		this.departementDAO = departementDAO;
	}
	
	public  List<Departement> add(){
		return departementDAO.add();
	}
	
}
