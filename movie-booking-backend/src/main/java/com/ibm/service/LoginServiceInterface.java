package com.ibm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Booking;
import com.ibm.entity.Seat;
import com.ibm.entity.ShowScreen;
import com.ibm.pojo.EMail;
import com.ibm.repo.BookingRepository;
import com.ibm.repo.SeatRepositroy;
import com.ibm.repo.ShowScreenRepository;

@Service
public class LoginServiceInterface implements LoginInterface{

	private EMail email=new EMail();
	
	@Autowired
	private SeatRepositroy seatRepo;
	
	@Autowired
	private BookingRepository bookingRepo;
	
	@Autowired
	private ShowScreenRepository showRepo;
	
	@Override
	public void userEmailConfirm(String emailId, String username) {
		email.conn(emailId,"<h1> welcome to BOX OFFICE movie booking application </h1>"
				+ "<h6>thank you for registering</h6>"+username
				+ "<h6>may you have wonferful experience</h6>");
	}

	@Override
	public void bookingConfirmed(String userId, int bookingId) {
		email.conn(userId,"<h1> your booking is done "+bookingId+"</h1>");
	}

	@Override
	public void bookingCancelled(String userId, int bookingId) {
		email.conn(userId,"<h1> your booking is cancelled "+bookingId+" </h1>");
	}

	@Override
	public void seatStat(int showId, int seatId,String userId) {
		Seat seat=seatRepo.findById(seatId).get();
		ShowScreen show=showRepo.findById(showId).get();
		
		String content="<table>"
		+"<th><tr>SHOW DATE</tr><tr>SHOW TIME</tr><tr>SCREEN</tr><tr>SEAT NO</tr></th>"
		+"<td>"
		+"<tr>"+show.getShowDate()+"</tr>"
		+"<tr>"+show.getShowTime()+"</tr>"
		+"<tr>"+show.getScreen()+"</tr>"
		+"<tr>"+seat.getSeatNo()+"</tr>"
		+"</td>"
		+"</table>";
		
		email.conn(userId, content);
		
	}

}
