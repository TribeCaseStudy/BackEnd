package com.ibm.service;

import java.util.List;

import com.ibm.entity.Seat;

public interface SeatService {
	
	List<Seat> findAllSeatsByShowId(int showId);

	void addSeats(Seat seats, int showId);
	
	List<Seat> findAllByBookingId(int bookingId);

	void updateAllSeatStatusByBookingId(Seat seat,int bookingId,int showId);
	
}
