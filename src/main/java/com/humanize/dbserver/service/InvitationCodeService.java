package com.humanize.dbserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanize.dbserver.data.InvitationCode;

@Service
public class InvitationCodeService {
	
	@Autowired
	InvitationCodeRepositoryService repositoryService;
	
	public InvitationCode create(InvitationCode invitationCode) {
		return repositoryService.create(invitationCode);
	}
	
	public InvitationCode update(InvitationCode invitationCode) {
		return repositoryService.update(invitationCode);
	}
	
	public InvitationCode findByEmailId(String emailId) {
		return repositoryService.findByEmailId(emailId);
	}
	
	// TBD: need to fix return type, check what mongo returns in successful deletion
	public boolean delete(InvitationCode invitationCode) {
		repositoryService.delete(invitationCode);
		
		return true;
	}
	
	public boolean delete(String emailId) {
		repositoryService.delete(repositoryService.findByEmailId(emailId));
		
		return true;
	}
}
