package com.humanize.dbserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.humanize.dbserver.data.VerificationCode;
import com.humanize.dbserver.service.VerificationCodeService;

@RestController
public class VerificationCodeController {
	
	@Autowired
	VerificationCodeService verificationCodeService;
	
	@RequestMapping("/invitationCode/create")
	public ResponseEntity<VerificationCode> create(@RequestBody VerificationCode verificationCode) {
		return new ResponseEntity<VerificationCode>(verificationCodeService.create(verificationCode), HttpStatus.OK);
	}
	
	@RequestMapping("/invitationCode/update")
	public ResponseEntity<VerificationCode> update(@RequestBody VerificationCode verificationCode) {
		return new ResponseEntity<VerificationCode>(verificationCodeService.update(verificationCode), HttpStatus.OK);
	}
	
	@RequestMapping("/invitationCode/find")
	public ResponseEntity<VerificationCode> findByEmailId(@RequestParam("emailId") String emailId) {
		return new ResponseEntity<VerificationCode>(verificationCodeService.findByEmailId(emailId), HttpStatus.OK);
	}
	
	@RequestMapping("/invitationCode/delete")
	public ResponseEntity<Boolean> signup(@RequestBody VerificationCode verificationCode) {
		return new ResponseEntity<Boolean>(verificationCodeService.delete(verificationCode), HttpStatus.OK);
	}
}
