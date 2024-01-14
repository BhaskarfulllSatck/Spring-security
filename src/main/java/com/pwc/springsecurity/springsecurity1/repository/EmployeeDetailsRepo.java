package com.pwc.springsecurity.springsecurity1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pwc.springsecurity.springsecurity1.entity.EmployeeDetails;
@Repository
public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetails, Integer> {
	public Optional<EmployeeDetails> findByEname( String ename);

}
