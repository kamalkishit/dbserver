package com.humanize.dbserver.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.humanize.dbserver.data.InvitationCode;


public interface InvitationCodeRepository extends MongoRepository<InvitationCode, String> {
	
	public InvitationCode findByEmailId(String emailId);

}
