package com.xiyou.ssh.entities;

import java.util.Date;

public class Employee {

	private Integer eId;
	// ���ܴ�ǰ���޸�
	private String eName;
	private String email;
	private Date birth;
	// һ���������Ͳ��ܱ��޸�
	private Date createTime;
	// ������һ�Ĺ�����ϵ
	private Departement dept;

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Departement getDept() {
		return dept;
	}

	public void setDept(Departement dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", email=" + email
				+ ", birth=" + birth + ", createTime=" + createTime + ", dept="
				+ dept.getDeptId() + "]";
	}

	
	
}
