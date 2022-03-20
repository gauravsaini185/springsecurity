package com.springsecuritycrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	
	@GetMapping("/dologin")
	public String login() {
		return "loginPage";
	}
	
}
