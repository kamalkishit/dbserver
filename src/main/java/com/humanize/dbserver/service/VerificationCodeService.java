package com.humanize.dbserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanize.dbserver.data.VerificationCode;
import com.humanize.dbserver.exception.VerificationCodeCreationException;
import com.humanize.dbserver.exception.VerificationCodeDeletionException;
import com.humanize.dbserver.exception.VerificationCodeNotFoundException;
import com.humanize.dbserver.exception.VerificationCodeUpdationException;

@Service
public class VerificationCodeService {
	
	@Autowired
	VerificationCodeRepositoryService repositoryService;
	
	public VerificationCode create(VerificationCode verificationCode) throws VerificationCodeCreationException {
		return repositoryService.create(verificationCode);
	}
	
	public VerificationCode update(VerificationCode verificationCode) throws VerificationCodeUpdationException {
		return repositoryService.update(verificationCode);
	}
	
	public VerificationCode findByEmailId(String emailId) throws VerificationCodeNotFoundException {
		return repositoryService.findByEmailId(emailId);
	}
	
	// TBD: need to fix return type, check what mongo returns in successful deletion
	public boolean delete(VerificationCode verificationCode) {
		repositoryService.delete(verificationCode);
		
		return true;
	}
	
	public boolean delete(String emailId) throws VerificationCodeDeletionException {
		repositoryService.delete(emailId);
		
		return true;
	}
}
