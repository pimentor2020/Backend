package com.org.pimentorbackend.service.data;

import java.util.List;

import com.org.pimentorbackend.beans.SuccessBean;
import com.org.pimentorbackend.dao.model.User;

public interface UserData {
	List<User> findAllUser();
	boolean isUserNamePresent();
	boolean isContactNoPresent();
	boolean isEmailIdPresent();
	User createOrUpdateEmployee(User user);
	SuccessBean createUser(User user);
	SuccessBean getAttribute(String attributeName, String value);
	SuccessBean validateUserForLogin(String un, String pw);
}
