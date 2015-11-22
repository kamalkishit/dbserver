package com.humanize.dbserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanize.dbserver.dao.VerificationCodeRepository;
import com.humanize.dbserver.data.VerificationCode;
import com.humanize.dbserver.exception.VerificationCodeCreationException;
import com.humanize.dbserver.exception.VerificationCodeDeletionException;
import com.humanize.dbserver.exception.VerificationCodeNotFoundException;
import com.humanize.dbserver.exception.VerificationCodeUpdationException;

@Service
public class VerificationCodeRepositoryService {
	
	@Autowired
	VerificationCodeRepository repository;
	
	public VerificationCode create(VerificationCode verificationCode) throws VerificationCodeCreationException {
		verificationCode = repository.save(verificationCode);
		
		if (verificationCode == null) {
			throw new VerificationCodeCreationException(0, null);
		}
		
		return verificationCode;
	}
	
	public VerificationCode update(VerificationCode verificationCode) throws VerificationCodeUpdationException {
		verificationCode = repository.save(verificationCode);
		
		if (verificationCode == null) {
			throw new VerificationCodeUpdationException(0, null);
		}
		
		return verificationCode;
	}
	
	public VerificationCode findByEmailId(String emailId) throws VerificationCodeNotFoundException {
		VerificationCode verificationCode = repository.findByEmailId(emailId);
		
		if (verificationCode == null) {
			throw new VerificationCodeNotFoundException(0, null);
		}
		
		return verificationCode;
	}
	
	public void delete(String emailId) throws VerificationCodeDeletionException {
		VerificationCode verificationCode = repository.findByEmailId(emailId);
		
		if (verificationCode == null) {
			throw new VerificationCodeDeletionException(0, null);
		}
		
		repository.delete(verificationCode);
	}
	
	public void delete(VerificationCode verificationCode) {
		repository.delete(verificationCode);
	}

}
