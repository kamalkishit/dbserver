package com.humanize.dbserver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanize.dbserver.ExceptionConfig;
import com.humanize.dbserver.data.User;
import com.humanize.dbserver.exception.UserCreationException;
import com.humanize.dbserver.exception.UserDeletionException;
import com.humanize.dbserver.exception.UserNotFoundException;
import com.humanize.dbserver.exception.UserUpdationException;

@Service
public class UserService {

	@Autowired
	UserRepositoryService repositoryService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public User create(User user) throws UserCreationException {
		return repositoryService.create(user);
	}
	
	public User update(User user) throws UserUpdationException {
		return repositoryService.update(user);
	}
	
	public User findByEmailId(String emailId) throws UserNotFoundException {
		return repositoryService.findByEmailId(emailId);
	}
	
	// TBD: need to fix return type, check what mongo returns in successful deletion
	public boolean delete(User user) {
		repositoryService.delete(user);
		
		return true;
	}
	
	public boolean delete(String emailId) throws UserDeletionException {
		try {
			repositoryService.delete(repositoryService.findByEmailId(emailId));
		} catch (Exception exception) {
			logger.error("", exception);
			throw new UserDeletionException(ExceptionConfig.USER_DELETION_ERROR_CODE, ExceptionConfig.USER_DELETION_EXCEPTION);
		}
		
		return true;
	}
}
