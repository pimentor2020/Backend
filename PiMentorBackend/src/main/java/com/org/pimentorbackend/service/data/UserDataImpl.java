package com.org.pimentorbackend.service.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.org.pimentorbackend.beans.SuccessBean;
import com.org.pimentorbackend.dao.model.User;
import com.org.pimentorbackend.dao.repository.UserRepository;
import com.org.pimentorbackend.util.ValidationType;

@Service
public class UserDataImpl implements UserData{
	@Autowired
    private UserRepository repository;
	@Autowired
	SuccessBean bean;

	@Override
	public List<User> findAllUser() {
		return (List<User>) repository.findAll();
	}

	@Override
	public boolean isUserNamePresent() {
		return false;
	}

	@Override
	public boolean isContactNoPresent() {
		return false;
	}

	@Override
	public boolean isEmailIdPresent() {
		return false;
	}
	
	public User createOrUpdateEmployee(User entity) {
        Optional<User> employee = repository.findById(entity.getUserid());
         
        if(employee.isPresent()) 
        {
            User newEntity = employee.get();
            newEntity.setEmailid(entity.getEmailid());
            newEntity.setUsername(entity.getUsername());
            newEntity.setUserid(entity.getUserid());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);             
            return entity;
        }
    } 
	
	

	public SuccessBean createUser(User entity) {
		try {
			repository.save(entity);
			bean.setSuccessMessage(HttpStatus.OK.toString());
		} catch (Exception e) {
			bean.setSuccessMessage(HttpStatus.NOT_FOUND.toString());
		}
		return bean;
	}

	@Override
	public SuccessBean getAttribute(String attributeName, String value) {
		List<User> userList;
		if(attributeName.equals(ValidationType.emailId.toString())) {
			userList = repository.findByEmail(value);
		}else if(attributeName.equals(ValidationType.userName.toString())) {
			userList = repository.findByUserName(value);
		} else {
			userList = repository.findByContact(value);
		}
		bean.setSuccessMessage("false");
		if (userList.size()>0) {
			bean.setSuccessMessage("true");
		}
		return bean;
	}

	@Override
	public SuccessBean validateUserForLogin(String un, String pw) {
		List<User> userList = repository.loginUser(un, pw);
		if (userList.size()>0) {
			bean.setSuccessMessage(userList.get(0).getUsertype());
		}
		return bean;
	}
}
