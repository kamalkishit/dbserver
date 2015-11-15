package com.humanize.dbserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanize.dbserver.data.VerificationCode;

@Service
public class VerificationCodeService {
	
	@Autowired
	VerificationCodeRepositoryService repositoryService;
	
	public VerificationCode create(VerificationCode verificationCode) {
		return repositoryService.create(verificationCode);
	}
	
	public VerificationCode update(VerificationCode verificationCode) {
		return repositoryService.update(verificationCode);
	}
	
	public VerificationCode findByEmailId(String emailId) {
		return repositoryService.findByEmailId(emailId);
	}
	
	// TBD: need to fix return type, check what mongo returns in successful deletion
	public boolean delete(VerificationCode verificationCode) {
		repositoryService.delete(verificationCode);
		
		return true;
	}
	
	public boolean delete(String emailId) {
		repositoryService.delete(repositoryService.findByEmailId(emailId));
		
		return true;
	}
}
