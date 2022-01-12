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
	public void addSeats(Seat seats, int showId) {
		
		seats.setBooking(null);
		seats.setShowScreens(showRepo.findById(showId).get());
		repo.save(seats);

	}

	@Override
	public void updateAllSeatStatusByBookingId(int bookingId) {//this is used only for making the seats unavailable as per booking_id
		
		List<Seat> seats=repo.findAllSeatsByBookingId(bookingId);
		for(Seat seat:seats)
		{
			seat.setStatusSeat("vacant");
			seat.setBooking(null);
		}
		repo.saveAll(seats);

	}

	@Override
	public void updateSeatsBookingId(int bookingId, int showId, int seatNo) {
		Seat s=repo.findByShowIdAndSeatNo(showId, seatNo);
		s.setBooking(bookRepo.getById(bookingId));
		repo.save(s);
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
