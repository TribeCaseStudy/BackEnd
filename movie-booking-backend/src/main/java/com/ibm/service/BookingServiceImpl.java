package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Booking;
import com.ibm.repo.BookingRepository;
import com.ibm.repo.MovieRepository;
import com.ibm.repo.UserRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository repo;
	
	@Autowired
	private MovieRepository mRepo;
	
	@Autowired
	private UserRepository uRepo;
	
	@Override
	public void bookingAdd(Booking booking, String userId,int movieId) {
	
		booking.setMovie(mRepo.getById(movieId));
		booking.setUser(uRepo.getById(userId));
		repo.save(booking);
	}

	@Override
	public List<Booking> findAllByUserId(String userId) {
		// TODO Auto-generated method stub
		return repo.findAllByUserId(userId);
	}

	@Override
	public void updateBooking(int bookingId) {
		Booking b=repo.findById(bookingId).get();
		b.setStatusBooking("cancel");
		repo.save(b);
		
	}

}
