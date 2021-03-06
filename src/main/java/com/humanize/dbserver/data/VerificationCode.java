package com.humanize.dbserver.data;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class VerificationCode {
	
	@Id
	private String id;

	@NotEmpty
	@Indexed(unique = true)
	private String emailId;
	
	@NotEmpty
	private String verificationCode;
	
	public VerificationCode() {
		this.id = null;
		this.emailId = null;
		this.verificationCode = null;
	}
	
	public VerificationCode(String emailId, String verificationCode) {
		this.emailId = emailId;
		this.verificationCode = verificationCode;
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

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
}
