package com.pwc.springsecurity.springsecurity1.serviceImpl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.InvalidIsolationLevelException;

import com.pwc.springsecurity.springsecurity1.entity.EmployeeDetails;
import com.pwc.springsecurity.springsecurity1.repository.EmployeeDetailsRepo;
import com.pwc.springsecurity.springsecurity1.service.EmployeeDeatilsService;
@Service
public class EmployeeDeatilsServiceImpl implements EmployeeDeatilsService {
	@Autowired
	private EmployeeDetailsRepo empRepo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<EmployeeDetails> findByEname = empRepo.findByEname(username);
		if(findByEname.isEmpty()) {
			throw new IllegalArgumentException("user is not Found");
		}else {
			EmployeeDetails employeeDetails = findByEname.get();
			Set<GrantedAuthority> roles= new HashSet<>();
			for(String role:employeeDetails.getRoles()) {
				SimpleGrantedAuthority authority= new SimpleGrantedAuthority(role);
				roles.add(authority);
			}
			User user = new User(employeeDetails.getEname(),
					employeeDetails.getPwd(),roles);
		return user;	
		}
		
	}

	@Override
	public String registerEmployee(EmployeeDetails employee) {
		employee.setPwd(encoder.encode(employee.getPwd()));
		return empRepo.save(employee).getEid()+"Employee Register Sucessfully";
	}

}
