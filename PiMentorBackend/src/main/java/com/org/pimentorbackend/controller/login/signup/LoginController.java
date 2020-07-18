package com.org.pimentorbackend.controller.login.signup;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.pimentorbackend.beans.SuccessBean;
import com.org.pimentorbackend.dao.model.User;
import com.org.pimentorbackend.service.login.UserLoginService;

import ch.qos.logback.classic.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	@Autowired
	UserLoginService userLoginService;
	
	private static final Logger loginLogger = (Logger) LoggerFactory.getLogger(LoginController.class);
	@PostMapping(value = "userlogin")
	public SuccessBean logInUser(@RequestBody User userdata) {
		loginLogger.debug("inside login");
		return userLoginService.logInUser(userdata);
	}
	
	
}
