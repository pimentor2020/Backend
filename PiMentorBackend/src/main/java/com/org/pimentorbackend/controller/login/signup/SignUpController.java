package com.org.pimentorbackend.controller.login.signup;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.pimentorbackend.beans.SuccessBean;
import com.org.pimentorbackend.dao.model.User;
import com.org.pimentorbackend.service.data.UserData;
import com.org.pimentorbackend.util.UserType;

import ch.qos.logback.classic.Logger;

@RestController
@CrossOrigin
public class SignUpController {
	private static final Logger signUpLogger = (Logger) LoggerFactory.getLogger(SignUpController.class);
	
	@Autowired
	UserData userData;
	
	@PostMapping(value="signUpUser", 
			 consumes = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
	public SuccessBean createEmployee(@RequestBody User user) {
	   signUpLogger.debug("test signup user");
	   user.setUsertype(UserType.user.toString());
	   return userData.createUser(user);
	}
	
	@PostMapping(value = "signUpInterviewer",
			consumes = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
	public SuccessBean interViewerSignUp(@RequestBody User user) {
	   signUpLogger.debug("test signup interviewer");
	   user.setUsertype(UserType.interviewer.toString());
	   return userData.createUser(user);
	}
	
	@GetMapping(value = "validateAttribute/{paramName}/{paramValue}")
	public SuccessBean validate(@PathVariable String paramName, @PathVariable String paramValue) {
		signUpLogger.debug("inside validation :: "+paramName+" :: "+paramValue);	
		return userData.getAttribute(paramName, paramValue);		
	}
}
