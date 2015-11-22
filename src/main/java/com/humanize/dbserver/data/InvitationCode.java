package com.humanize.dbserver.data;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class InvitationCode {

	@Id
	private String id;

	@NotEmpty
	@Email
	@Indexed(unique = true)
	private String emailId;
	
	@NotEmpty
	private String invitationCode;
	
	public InvitationCode() {
		this.id = null;
		this.emailId = null;
		this.invitationCode = null;
	}
	
	public InvitationCode(String emailId, String invitationCode) {
		this.emailId = emailId;
		this.invitationCode = invitationCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}
}
