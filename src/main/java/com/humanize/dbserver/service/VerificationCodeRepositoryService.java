package com.humanize.dbserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanize.dbserver.dao.VerificationCodeRepository;
import com.humanize.dbserver.data.VerificationCode;

@Service
public class VerificationCodeRepositoryService {
	
	@Autowired
	VerificationCodeRepository repository;
	
	public VerificationCode create(VerificationCode verificationCode) {
		verificationCode = repository.save(verificationCode);
		
		if (verificationCode == null) {
			
		}
		
		return verificationCode;
	}
	
	public VerificationCode update(VerificationCode verificationCode) {
		verificationCode = repository.save(verificationCode);
		
		if (verificationCode == null) {
			
		}
		
		return verificationCode;
	}
	
	public VerificationCode findByEmailId(String emailId) {
		VerificationCode verificationCode = repository.findByEmailId(emailId);
		
		if (verificationCode == null) {
			
		}
		
		return verificationCode;
	}
	
	public void delete(VerificationCode verificationCode) {
		repository.delete(verificationCode);
	}

}
