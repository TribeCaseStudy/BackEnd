package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Booking;
import com.ibm.service.BookingService;

@CrossOrigin
@RestController
public class BookingController {
	
	@Autowired 
	private BookingService service;
	
	@PostMapping(value="/booking/{userId}/{movieId}",consumes="application/json")
	public void saveBooking(@RequestBody Booking b,@PathVariable String userId,@PathVariable int movieId)
	{
		service.bookingAdd(b, userId, movieId);
	}
	
	@GetMapping(value="/booking/all/{userId}",produces = "application/json")
	public List<Booking> findAllByUserId(@PathVariable String userId)
	{
		return service.findAllByUserId(userId);
	}
	
	@PutMapping(value="/booking/update/{bookingId}",consumes = "application/json")
	public void updateBooking(@PathVariable int bookingId)
	{
		service.updateBooking(bookingId);
	}

}
