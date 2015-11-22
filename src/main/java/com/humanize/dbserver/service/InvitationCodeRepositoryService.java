package com.humanize.dbserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanize.dbserver.dao.InvitationCodeRepository;
import com.humanize.dbserver.data.InvitationCode;
import com.humanize.dbserver.exception.InvitationCodeCreationException;
import com.humanize.dbserver.exception.InvitationCodeDeletionException;
import com.humanize.dbserver.exception.InvitationCodeNotFoundException;
import com.humanize.dbserver.exception.InvitationCodeUpdationException;

@Service
public class InvitationCodeRepositoryService {
	
	@Autowired
	InvitationCodeRepository repository;
	
	public InvitationCode create(InvitationCode invitationCode) throws InvitationCodeCreationException {
		invitationCode = repository.save(invitationCode);
		
		if (invitationCode == null) {
			throw new InvitationCodeCreationException(0, null);
		}
		
		return invitationCode;
	}
	
	public InvitationCode update(InvitationCode invitationCode) throws InvitationCodeUpdationException {
		invitationCode = repository.save(invitationCode);
		
		if (invitationCode == null) {
			throw new InvitationCodeUpdationException(0, null);
		}
		
		return invitationCode;
	}
	
	public InvitationCode findByEmailId(String emailId) throws InvitationCodeNotFoundException {
		InvitationCode invitationCode = repository.findByEmailId(emailId);
		
		if (invitationCode == null) {
			throw new InvitationCodeNotFoundException(0, null);
		}
		
		return invitationCode;
	}
	
	public void delete(InvitationCode invitationCode) {
		repository.delete(invitationCode);
	}
	
	public void delete(String emailId) throws InvitationCodeDeletionException {
		InvitationCode invitationCode = repository.findByEmailId(emailId);
		
		if (invitationCode == null) {
			throw new InvitationCodeDeletionException(0, null);
		}
		
		repository.delete(invitationCode);
	}

}
