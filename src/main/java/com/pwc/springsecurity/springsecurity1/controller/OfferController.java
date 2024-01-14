package com.pwc.springsecurity.springsecurity1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class OfferController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	@GetMapping("/offer")
	public String showOffers() {
		return "offer";
	}
	
	@GetMapping("/balance")
	public String showbalance() {
		return "balance";
	}
	
	@GetMapping("/loan")
	public String showloan() {
		return "loan";
	}
	@GetMapping("/welcome")
	public String showPage() {
		return "welcome";
	}
	@GetMapping("/denied")
	public String showDeniedPage() {
		return "Accessdenied";
	}
}
