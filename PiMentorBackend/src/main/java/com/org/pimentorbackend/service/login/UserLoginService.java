package com.org.pimentorbackend.service.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.pimentorbackend.beans.SuccessBean;
import com.org.pimentorbackend.dao.model.User;
import com.org.pimentorbackend.dao.repository.UserRepository;
import com.org.pimentorbackend.util.PimentorConstants;

@Service
public class UserLoginService {
	@Autowired
	SuccessBean successBean;
	@Autowired
	UserRepository userRepository;
	
	public SuccessBean logInUser(User user) {
		List<User> userList = 
					userRepository.loginUser(user.getUsername(), user.getUserpassword());
		if(userList.size()>0)
			successBean.setSuccessMessage(PimentorConstants.TRUE);
		else
			successBean.setSuccessMessage(PimentorConstants.FALSE);
		return successBean;
	}
}
