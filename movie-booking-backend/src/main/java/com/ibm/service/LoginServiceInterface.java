package com.ibm.service;


import org.springframework.stereotype.Service;

import com.ibm.pojo.EMail;

@Service
public class LoginServiceInterface implements LoginInterface{

	private EMail email=new EMail();
	
	@Override
	public void userEmailConfirm(String emailId, String username) {
		email.conn(emailId,"<h1> welcome to BOX OFFICE movie booking application </h1>"
				+ "<h6>thank you for registering</h6>"+username
				+ "<h6>may you have wonferful experience</h6>");
	}

	@Override
	public void bookingConfirmed(String userId, int bookingId) {
		email.conn(userId,"<h1> your booking is done </h1>"+bookingId);
	}

	@Override
	public void bookingCancelled(String userId, int bookingId) {
		email.conn(userId,"<h1> your booking is cancelled </h1>"+bookingId);
	}

}
