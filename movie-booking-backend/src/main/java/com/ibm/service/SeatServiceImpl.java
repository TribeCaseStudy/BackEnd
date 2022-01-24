package com.ibm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Seat;
import com.ibm.repo.BookingRepository;
import com.ibm.repo.SeatRepositroy;
import com.ibm.repo.ShowScreenRepository;
/**
 * author : Ardra*/
@Service
public class SeatServiceImpl implements SeatService {

	@Autowired
	private SeatRepositroy repo;
	
	@Autowired
	private BookingRepository bookRepo;
	
	@Autowired 
	private ShowScreenRepository showRepo;
	
	@Transactional
	@Override
	public void addSeats(Seat seats, int showId) {
		seats.setShowScreens(showRepo.findById(showId).get());
		repo.save(seats);

	}

	@Transactional
	@Override
	public void updateAllSeatStatusByBookingId(int seatId,int bookingId,int showId,String stat) {
		Seat seat=repo.findById(seatId).get();
		seat.setShowScreens(showRepo.findById(showId).get());
		if(bookingId==0)
		{
			seat.setBooking(null);
		}
		else
			seat.setBooking(bookRepo.findById(bookingId).get());
		
		seat.setStatusSeat(stat);
		repo.save(seat);
	}

	@Override
	public List<Seat> findAllSeatsByShowId(int showId) {
		// TODO Auto-generated method stub
		return repo.findAllSeatsByShowId(showId);
	}

	@Override
	public List<Seat> findAllByBookingId(int bookingId) {
		// TODO Auto-generated method stub
		return repo.findAllSeatsByBookingId(bookingId);
	}

	@Override
	public int showShowId(int seatId) {
		// TODO Auto-generated method stub
		return repo.findShowId(seatId);
	}



}
