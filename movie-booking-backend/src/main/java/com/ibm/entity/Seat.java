package com.ibm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * seadtId(GeneratedValue) Booking Seat_no Status(occupied/empty) ShowScreen
 */
@Entity
public class Seat {

	@Id
	@GeneratedValue
	@Column(name = "seat_id")
	private int seatId;
	@Column(name="seat_no")
	private int seatNo;
	@Column(name = "status_seat", length = 10)
	private String statusSeat;//vacant or occupied
	
	@JsonBackReference(value="show_seat")
	@ManyToOne
	@JoinColumn(name="show_id")
	private ShowScreen showScreens;
	
	@JsonBackReference(value="book_seat")
	@ManyToOne
	@JoinColumn(name="booking_id") 
	private Booking booking; 

	public Seat() {
		super();
	}

	public Seat(int seatId, int seatNo, String statusSeat) {
		super();
		this.seatId = seatId;
		this.seatNo = seatNo;
		this.statusSeat = statusSeat;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public String getStatusSeat() {
		return statusSeat;
	}

	public void setStatusSeat(String status) {
		this.statusSeat = status;
	}

	public ShowScreen getShowScreens() {
		return showScreens;
	}

	public void setShowScreens(ShowScreen showScreens) {
		this.showScreens = showScreens;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	

}
