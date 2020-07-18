package com.org.pimentorbackend.controller.checkdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.pimentorbackend.dao.model.User;
import com.org.pimentorbackend.service.data.UserData;

@RestController
@CrossOrigin
public class GetUserDetailsController {
	
	@Autowired
	UserData userData;
	
	@GetMapping(value="/getAllUsers")
	public List<User> getUserdata(){
		return userData.findAllUser();
	}

}
