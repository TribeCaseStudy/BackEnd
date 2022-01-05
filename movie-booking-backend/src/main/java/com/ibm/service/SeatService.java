package com.ibm.service;

import java.util.List;

import com.ibm.entity.Seat;

public interface SeatService {
	
	void addSeats(Seat seat);
	
	void updateSeat(Seat seat);
	
	List<Seat> findAllSeatsByShowId(int showId);
	
	List<Seat> findAllSeatsByBookingId(int bookingId);
	
}
