package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Seat;
import com.ibm.repo.BookingRepository;
import com.ibm.repo.SeatRepositroy;
import com.ibm.repo.ShowScreenRepository;
@Service
public class SeatServiceImpl implements SeatService {

	@Autowired
	private SeatRepositroy repo;
	
	@Autowired
	private BookingRepository bookRepo;
	
	@Autowired 
	private ShowScreenRepository showRepo;
	
	@Override
	public void addSeats(Seat seat, int showId) {
		seat.setBooking(null);
		seat.setShowScreens(showRepo.findById(showId).get());
		repo.save(seat);

	}

	@Override
	public void updateAllSeatStatusByBookingId(int bookingId) {//this is used only for making the seats unavailable as per booking_id
		repo.updateAllSeatStatusByBookingId(bookingId);

	}

	@Override
	public void updateSeatsBookingId(int bookingId, int showId, int seatNo) {
		repo.updateSeat(bookingId, showId, seatNo);

	}

	@Override
	public List<Seat> findAllSeatsByShowId(int showId) {
		// TODO Auto-generated method stub
		return repo.findAllSeatsByShowId(showId);
	}

	@Override
	public List<Seat> findAllSeatsByBookingId(int bookingId) {
		// TODO Auto-generated method stub
		return repo.findAllSeatsByBookingId(bookingId);
	}

}
