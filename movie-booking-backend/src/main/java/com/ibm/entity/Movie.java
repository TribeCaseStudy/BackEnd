package com.ibm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * movie entity describes the movie details about genre, id, title and language
 * 
 * 
 * author:Ruksana
 * version:1.0
 * since 3 Jan 2022
 */
@Entity
public class Movie {

	@Id
	@GeneratedValue
	@Column(name="movie_id")
	private int movieId;
	@Column(name="movie_type",length=10)
	private String types;
	@Column(name="movie_name",length = 30)
	private String movieName;
	@Column(length=15)
	private String language;
	
//	@JsonManagedReference
//	@OneToOne(mappedBy = "movie",cascade = CascadeType.ALL)
//	private Booking booking;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name="des_id")
	private Description description;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "movie",cascade = CascadeType.ALL ) 
	private List<ShowScreen> shows=new ArrayList<ShowScreen>(); 

	public Movie() {
		super();
	}

	public Movie(int movieId, String types, String movie_name, String language) {
		super();
		this.movieId = movieId;
		this.types = types;
		this.movieName = movie_name;
		this.language = language;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getMovie_name() {
		return movieName;
	}

	public void setMovie_name(String movie_name) {
		this.movieName = movie_name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

//	public Booking getBooking() {
//		return booking;
//	}

//	public void setBooking(Booking booking) {
//		this.booking = booking;
//	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public List<ShowScreen> getShows() {
		return shows;
	}

	public void setShows(List<ShowScreen> shows) {
		this.shows = shows;
	}

	
}
