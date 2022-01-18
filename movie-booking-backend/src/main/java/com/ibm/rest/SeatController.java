package com.ibm.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Seat;
import com.ibm.pojo.EMail;
import com.ibm.service.SeatService;

@CrossOrigin
@RestController
public class SeatController {
	
	@Autowired
	private SeatService service;
	
	@PostMapping(value="/seat/{showId}",consumes = "application/json" )
	public void addSeat(@RequestBody Seat seat,@PathVariable int showId)
	{
		service.addSeats(seat, showId);
	}
	
	@GetMapping(value="/seat/sid/{showId}",produces = "application/json")
	public List<Seat> findByShowId(@PathVariable int showId)
	{
		return service.findAllSeatsByShowId(showId);
	}
	
	@GetMapping(value="/seat/bid/{bookingId}",produces = "application/json")
	public List<Seat> findByBookingId(@PathVariable int bookingId)
	{
		return service.findAllByBookingId(bookingId);
	}
	
	@PutMapping(value="/seat/{stat}/{bookingId}/{showId}/{seatId}",consumes = "application/json")
	public void updateSeatStat(@PathVariable int seatId,@PathVariable int bookingId,@PathVariable int showId,@PathVariable String stat)
	{
		service.updateAllSeatStatusByBookingId(seatId, bookingId,showId,stat);
	}
	
	@GetMapping(value="/seat/show/{seatId}",produces = "application/json")
	public int showShowId(@PathVariable int seatId)
	{
		return service.showShowId(seatId);
	}

}
