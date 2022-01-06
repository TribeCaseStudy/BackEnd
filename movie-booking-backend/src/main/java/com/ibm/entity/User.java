package com.ibm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * emailId(Id) User_name mobile_no age password Booking[]
 */
@Entity
public class User {

	@Id
	@Column(name = "email_id_user", length = 50)
	private String emailId;
	@Column(name = "mobile_no", length = 10)
	private String mobileNo;
	@Column(name = "user_name", length = 30)
	private String userName;
	@Column(name = "password_user", length = 30)
	private String password;
	@Column(name = "age")
	private int age;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL) 
	private List<Booking> bookings = new ArrayList<Booking>();

	public User() {
		super();
	}

	public User(String emailId, String mobileNo, String userName, String password, int age) {
		super();
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.userName = userName;
		this.password = password;
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	
	

}
