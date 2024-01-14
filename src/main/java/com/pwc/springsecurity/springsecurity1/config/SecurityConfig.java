package com.pwc.springsecurity.springsecurity1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.pwc.springsecurity.springsecurity1.service.EmployeeDeatilsService;
@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	@Autowired
	private EmployeeDeatilsService empService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@Override
	public  void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(empService).passwordEncoder(encoder);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/bank/").permitAll()
		.antMatchers("/Employee/register","/Employee/showLogin").permitAll()
		.antMatchers("/bank/offer").authenticated()
		.antMatchers("/bank/balance").hasAnyAuthority("ASSOTIATE","MANAGER")
		.antMatchers("/bank/loan").hasAuthority("MANAGER")
		.anyRequest().authenticated()
		.and().formLogin().defaultSuccessUrl("/bank/",true).loginPage("/Employee/showLogin").loginProcessingUrl("/login")
		.failureUrl("/Employee/showLogin?error")
		.and().rememberMe()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/bank/signout")).logoutSuccessUrl("/Employee/showLogin?logout")
		.and().exceptionHandling().accessDeniedPage("/bank/denied")
		.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
	}

}
