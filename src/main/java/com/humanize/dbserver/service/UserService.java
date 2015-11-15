package com.humanize.dbserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanize.dbserver.data.InvitationCode;
import com.humanize.dbserver.data.User;

@Service
public class UserService {

	@Autowired
	UserRepositoryService repositoryService;
	
	public User create(User user) {
		return repositoryService.create(user);
	}
	
	public User update(User user) {
		return repositoryService.update(user);
	}
	
	public User findByEmailId(String emailId) {
		return repositoryService.findByEmailId(emailId);
	}
	
	// TBD: need to fix return type, check what mongo returns in successful deletion
	public boolean delete(User user) {
		repositoryService.delete(user);
		
		return true;
	}
	
	public boolean delete(String emailId) {
		repositoryService.delete(repositoryService.findByEmailId(emailId));
		
		return true;
	}
}
