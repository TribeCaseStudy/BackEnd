package com.ibm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Admin entity is the admin table in sql database
 * 
 * author:Ruksana
 * version:1.0
 * since 3 Jan 2022
 */
@Entity
public class Admin {

	@Id
	@Column(name="email_id_admin",length=50)
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
