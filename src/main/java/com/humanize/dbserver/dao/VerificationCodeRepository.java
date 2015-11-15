package com.humanize.dbserver.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.humanize.dbserver.data.VerificationCode;


public interface VerificationCodeRepository extends MongoRepository<VerificationCode, String> {
	
	public VerificationCode findByEmailId(String emailId);

}
