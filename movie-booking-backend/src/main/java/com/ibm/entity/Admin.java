package com.ibm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * emailId(Id) 
 * password
 */
@Entity
public class Admin {

	@Id
	@Column(name="email_id_adimn",length=50)
	private String emailId;
	@Column(name="password_admin",length=30)
	private String password;

	public Admin() {
		super();
	}

	public Admin(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
