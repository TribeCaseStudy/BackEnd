package com.ibm.service;

public interface LoginInterface {
	
	void userEmailConfirm(String emailId,String username);
	
	void bookingConfirmed(String userId,int bookingId);
	
	void bookingCancelled(String userId,int bookingId);

	void seatStat(int showId,int seatId,String userId);
}
