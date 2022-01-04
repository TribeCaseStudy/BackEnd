package com.ibm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * seadtId(GeneratedValue) Booking Seat_no Status(occupied/empty) ShowScreen
 */
@Entity
public class Seat {

	@Id
	@GeneratedValue
	@Column(name = "seat_id")
	private int seatId;
	private int seatNo;
	@Column(name = "status_seat", length = 10)
	private String statusSeat;
	
	@ManyToOne
	@JoinColumn(name="show_id")
	private ShowScreen showScreens;
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

}
