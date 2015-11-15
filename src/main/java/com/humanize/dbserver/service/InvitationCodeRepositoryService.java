package com.humanize.dbserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanize.dbserver.dao.InvitationCodeRepository;
import com.humanize.dbserver.data.InvitationCode;

@Service
public class InvitationCodeRepositoryService {
	
	@Autowired
	InvitationCodeRepository repository;
	
	public InvitationCode create(InvitationCode invitationCode) {
		invitationCode = repository.save(invitationCode);
		
		if (invitationCode == null) {
			
		}
		
		return invitationCode;
	}
	
	public InvitationCode update(InvitationCode invitationCode) {
		invitationCode = repository.save(invitationCode);
		
		if (invitationCode == null) {
			
		}
		
		return invitationCode;
	}
	
	public InvitationCode findByEmailId(String emailId) {
		InvitationCode invitationCode = repository.findByEmailId(emailId);
		
		if (invitationCode == null) {
			
		}
		
		return invitationCode;
	}
	
	public void delete(InvitationCode invitationCode) {
		repository.delete(invitationCode);
	}

}
