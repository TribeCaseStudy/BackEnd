package com.ibm.service;

import java.util.List;

import com.ibm.entity.Booking;

public interface BookingService {
	
	void bookingAdd(Booking booking,String userId);
	
	void updateBooking(int bookingId);
	
	List<Booking> findAllByUserId(String userId);

}
