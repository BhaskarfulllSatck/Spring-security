package com.pwc.springsecurity.springsecurity1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Springsecurity1Application {
	@Bean
	public BCryptPasswordEncoder createPwdEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Springsecurity1Application.class, args);
		System.out.println("Welcome");
	}

}
