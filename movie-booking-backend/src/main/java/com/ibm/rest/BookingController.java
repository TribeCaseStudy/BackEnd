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
import com.ibm.pojo.EMail;
import com.ibm.service.BookingService;

@CrossOrigin
@RestController
public class BookingController {
	
	@Autowired 
	private BookingService service;
	
	@PostMapping(value="/booking/{userId}",consumes="application/json")
	public void saveBooking(@RequestBody Booking b,@PathVariable String userId)
	{
		service.bookingAdd(b, userId);
		EMail email=new EMail();
		email.conn(userId,"<h1> your booking is done </h1>"+b.getBookingId());
	}
	
	@GetMapping(value="/booking/all/{userId}",produces = "application/json")
	public List<Booking> findAllByUserId(@PathVariable String userId)
	{
		return service.findAllByUserId(userId);
	}
	
	@PutMapping(value="/booking/update/{bookingId}/{userId}")
	public void updateBooking(@PathVariable int bookingId,@PathVariable String userId)
	{
		service.updateBooking(bookingId);
		EMail email=new EMail();
		email.conn(userId,"<h1> your booking is cancelled </h1>"+bookingId);
	}

}
