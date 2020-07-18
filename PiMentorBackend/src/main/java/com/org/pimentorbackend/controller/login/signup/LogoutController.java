package com.org.pimentorbackend.controller.login.signup;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LogoutController {
	
	@RequestMapping("/logout")
	public void logInUser(String userName, String passWord) {
		
	}
}
