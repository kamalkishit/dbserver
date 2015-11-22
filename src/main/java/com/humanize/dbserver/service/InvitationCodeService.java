package com.humanize.dbserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanize.dbserver.data.InvitationCode;
import com.humanize.dbserver.exception.InvitationCodeCreationException;
import com.humanize.dbserver.exception.InvitationCodeDeletionException;
import com.humanize.dbserver.exception.InvitationCodeNotFoundException;
import com.humanize.dbserver.exception.InvitationCodeUpdationException;

@Service
public class InvitationCodeService {
	
	@Autowired
	InvitationCodeRepositoryService repositoryService;
	
	public InvitationCode create(InvitationCode invitationCode) throws InvitationCodeCreationException {
		return repositoryService.create(invitationCode);
	}
	
	public InvitationCode update(InvitationCode invitationCode) throws InvitationCodeUpdationException {
		return repositoryService.update(invitationCode);
	}
	
	public InvitationCode findByEmailId(String emailId) throws InvitationCodeNotFoundException {
		return repositoryService.findByEmailId(emailId);
	}
	
	// TBD: need to fix return type, check what mongo returns in successful deletion
	public boolean delete(InvitationCode invitationCode) {
		repositoryService.delete(invitationCode);
		
		return true;
	}
	
	public boolean delete(String emailId) throws InvitationCodeDeletionException {
		repositoryService.delete(emailId);
		
		return true;
	}
}
