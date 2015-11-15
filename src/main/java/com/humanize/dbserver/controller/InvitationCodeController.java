package com.humanize.dbserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.humanize.dbserver.data.InvitationCode;
import com.humanize.dbserver.service.InvitationCodeService;

@RestController
public class InvitationCodeController {
	
	@Autowired
	InvitationCodeService invitationCodeService;
	
	@RequestMapping("/invitationCode/create")
	public ResponseEntity<InvitationCode> create(@RequestBody InvitationCode invitationCode) {
		return new ResponseEntity<InvitationCode>(invitationCodeService.create(invitationCode), HttpStatus.OK);
	}
	
	@RequestMapping("/invitationCode/update")
	public ResponseEntity<InvitationCode> update(@RequestBody InvitationCode invitationCode) {
		return new ResponseEntity<InvitationCode>(invitationCodeService.update(invitationCode), HttpStatus.OK);
	}
	
	@RequestMapping("/invitationCode/find")
	public ResponseEntity<InvitationCode> findByEmailId(@RequestParam("emailId") String emailId) {
		return new ResponseEntity<InvitationCode>(invitationCodeService.findByEmailId(emailId), HttpStatus.OK);
	}
	
	@RequestMapping("/invitationCode/delete")
	public ResponseEntity<Boolean> signup(@RequestBody InvitationCode invitationCode) {
		return new ResponseEntity<Boolean>(invitationCodeService.delete(invitationCode), HttpStatus.OK);
	}

}
