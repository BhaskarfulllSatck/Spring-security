package com.pwc.springsecurity.springsecurity1.entity;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
@Table(name="SECURITY_EMPLOYEE")
@Entity
public class EmployeeDetails {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer eid;
	@Column(length=25,unique=true,nullable = false)
	private String ename;
	@Column(length=128,nullable = false)
	private String email;
	@Column(length=100,nullable=false)
	private String pwd;
	
	private String status;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="SECURITY_ROLES",joinColumns = @JoinColumn(name="Employee_Id",referencedColumnName = "eid"))
	@Column(name="role")
	private Set<String>roles;
	
	
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [eid=" + eid + ", ename=" + ename + ", email=" + email + ", pwd=" + pwd + ", status="
				+ status + ", roles=" + roles + "]";
	}
	

}
