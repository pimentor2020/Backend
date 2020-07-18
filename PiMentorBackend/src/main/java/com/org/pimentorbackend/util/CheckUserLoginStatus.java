package com.org.pimentorbackend.util;

import org.springframework.stereotype.Component;

import com.org.pimentorbackend.dao.model.User;

/*This class checks if user is already Logged in or not
 * this intends to stop multiple login for the same user*/
@Component
public class CheckUserLoginStatus {
	public boolean isUserLoggedIn(User user) {
		
		return false;
	}
}
