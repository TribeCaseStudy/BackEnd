package com.ibm.entity;

import java.time.LocalDate;
import java.time.LocalTime;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * showId(GeneratedValue) status(avail/non_avail) showTime showDate Seat[] Movie
 * Screen
 */
@Entity
@Table(name="show_screen")
public class ShowScreen {

	@Id
	@GeneratedValue
	@Column(name = "show_id")
	private int showId;
	@Column(name="screen_no")
	private int screen;
	@Column(name = "show_date")
	private LocalDate showDate;
	@Column(name = "show_time")
	private LocalTime showTime;
	@Column(name = "status_show", length = 10)
	private String statusShow;//avail or not_avail
	
	@JsonManagedReference(value="show_seat")
	@OneToMany(mappedBy="showScreens",cascade = CascadeType.ALL)
	private List<Seat> totalSeats=new ArrayList<Seat>();
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="movie_id") 
	private Movie movie;

	public ShowScreen() {
		super();
	}

	public ShowScreen(int showId, int screen, LocalDate showDate, LocalTime showTime, String statusShow) {
		super();
		this.showId = showId;
		this.screen = screen;
		this.showDate = showDate;
		this.showTime = showTime;
		this.statusShow = statusShow;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public int getScreen() {
		return screen;
	}

	public void setScreen(int screen) {
		this.screen = screen;
	}

	public LocalDate getShowDate() {
		return showDate;
	}

	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}

	public LocalTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalTime showTime) {
		this.showTime = showTime;
	}

	public String getStatusShow() {
		return statusShow;
	}

	public void setStatusShow(String statusShow) {
		this.statusShow = statusShow;
	}

	public List<Seat> getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(List<Seat> totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	

}
