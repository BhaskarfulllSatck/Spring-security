package com.pwc.springsecurity.springsecurity1.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.pwc.springsecurity.springsecurity1.entity.EmployeeDetails;

public interface EmployeeDeatilsService extends UserDetailsService{
	public String registerEmployee(EmployeeDetails employee);
}
