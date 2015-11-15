package com.humanize.dbserver.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.humanize.dbserver.dao.UserRepository;
import com.humanize.dbserver.data.User;

public class UserRepositoryService {

	@Autowired
	UserRepository repository;
	
	public User create(User user) {
		user = repository.save(user);
		
		if (user == null) {
			
		}
		
		return user;
	}
	
	public User update(User user) {
		user = repository.save(user);
		
		if (user == null) {
			
		}
		
		return user;
	}
	
	public User findByEmailId(String emailId) {
		User user = repository.findByEmailId(emailId);
		
		if (user == null) {
			
		}
		
		return user;
	}
	
	public void delete(User user) {
		repository.delete(user);
	}
}
