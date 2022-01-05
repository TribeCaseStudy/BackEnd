package com.ibm.service;

import java.util.List;

import com.ibm.entity.Seat;

public interface SeatService {
	
	void addSeats(Seat seat,int showId);//booking_id=null by default
	
	void updateAllSeatStatusByBookingId(int bookingId,String status);
	
	void updateSeat(int bookingId,int seatId,int seatNo);
	
	List<Seat> findAllSeatsByShowId(int showId);
	
	List<Seat> findAllSeatsByBookingId(int bookingId);
	
}
