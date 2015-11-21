package com.humanize.dbserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.humanize.dbserver.data.User;
import com.humanize.dbserver.exception.UserCreationException;
import com.humanize.dbserver.exception.UserDeletionException;
import com.humanize.dbserver.exception.UserNotFoundException;
import com.humanize.dbserver.exception.UserUpdationException;
import com.humanize.dbserver.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/users/create")
	public ResponseEntity<User> create(@RequestBody User user) throws UserCreationException {
		return new ResponseEntity<User>(userService.create(user), HttpStatus.OK);
	}
	
	@RequestMapping("/users/update")
	public ResponseEntity<User> update(@RequestBody User user) throws UserUpdationException {
		return new ResponseEntity<User>(userService.update(user), HttpStatus.OK);
	}
	
	@RequestMapping("/users/find")
	public ResponseEntity<User> findByEmailId(@RequestParam("emailId") String emailId) throws UserNotFoundException {
		return new ResponseEntity<User>(userService.findByEmailId(emailId), HttpStatus.OK);
	}
	
	@RequestMapping("/users/delete")
	public ResponseEntity<Boolean> delete(@RequestBody User user) throws UserDeletionException {
		return new ResponseEntity<Boolean>(userService.delete(user), HttpStatus.OK);
	}

}
