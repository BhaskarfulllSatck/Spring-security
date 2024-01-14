package com.pwc.springsecurity.springsecurity1.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pwc.springsecurity.springsecurity1.entity.EmployeeDetails;
import com.pwc.springsecurity.springsecurity1.service.EmployeeDeatilsService;

@Controller
@RequestMapping("/Employee")
public class EmployeeDetailsController {
	@Autowired
	private EmployeeDeatilsService empService;
	
	@GetMapping("/register")
	public String showEmployeeRegistration(@ModelAttribute("empInfo") EmployeeDetails employee ) {
		return "user_registration";
	}
	@PostMapping("/register")
	public String registerEmployee(Map<String,Object>map, @ModelAttribute("empInfo")EmployeeDetails employee ) {
		String result=empService.registerEmployee(employee);
		map.put("message", result);
		return "user_registration_sucess";
	}
	@GetMapping("/showLogin")
	public String showoginPage() {
		return "custom_login";
	}
	
}
