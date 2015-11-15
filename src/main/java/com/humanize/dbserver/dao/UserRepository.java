package com.humanize.dbserver.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.humanize.dbserver.data.User;

public interface UserRepository extends MongoRepository<User, String> {

	public User findByEmailId(String emailId);

	public User findByUserId(String userId);
}