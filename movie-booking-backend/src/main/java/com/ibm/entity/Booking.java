package com.ibm.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * booking entity here is used to store booking details of a particular user
 * 
 * author: Ardra
 * version:1.0
 * since 3 Jan 2022
 */
@Entity
public class Booking {

	@Id
	@GeneratedValue
	@Column(name = "booking_id")
	private int bookingId;
	@Column(name = "status_booking", length = 10)
	private String statusBooking;//cancel or book
	@Column(name = "booking_date")
	private LocalDate bookingDate;
	@Column(name="booking_cancel")
	private LocalDate cancelDate;

//	@JsonBackReference
//	@OneToOne
//	@JoinColumn(name="movie_id")
//	private Movie movie;
	
	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(LocalDate cancelDate) {
		this.cancelDate = cancelDate;
	}

	@JsonManagedReference(value="book_seat")
	@OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
	private List<Seat> seats = new ArrayList<Seat>();
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="email_id_user")
	private User user;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getStatusBooking() {
		return statusBooking;
	}

	public void setStatusBooking(String statusBooking) {
		this.statusBooking = statusBooking;
	}

	public Booking(int bookingId, String statusBooking) {
		super();
		this.bookingId = bookingId;
		this.statusBooking = statusBooking;
	}

	public Booking() {
		super();
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
