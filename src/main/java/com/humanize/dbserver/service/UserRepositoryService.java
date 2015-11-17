package com.humanize.dbserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanize.dbserver.ExceptionConfig;
import com.humanize.dbserver.dao.UserRepository;
import com.humanize.dbserver.data.User;
import com.humanize.dbserver.exception.UserCreationException;
import com.humanize.dbserver.exception.UserNotFoundException;
import com.humanize.dbserver.exception.UserUpdationException;

@Service
public class UserRepositoryService {

	@Autowired
	UserRepository repository;
	
	public User create(User user) {
		user = repository.save(user);
		
		if (user == null) {
			throw new UserCreationException(ExceptionConfig.USER_CREATION_ERROR_CODE, ExceptionConfig.USER_CREATION_EXCEPTION);
		}
		
		return user;
	}
	
	public User update(User user) {
		user = repository.save(user);
		
		if (user == null) {
			throw new UserUpdationException(ExceptionConfig.USER_UPDATION_ERROR_CODE, ExceptionConfig.USER_UPDATION_EXCEPTION);
		}
		
		return user;
	}
	
	public User findByEmailId(String emailId) {
		User user = repository.findByEmailId(emailId);
		
		if (user == null) {
			throw new UserNotFoundException(ExceptionConfig.USER_NOT_FOUND_ERROR_CODE, ExceptionConfig.USER_NOT_FOUND_EXCEPTION);
		}
		
		return user;
	}
	
	public void delete(User user) {
		repository.delete(user);
	}
}
