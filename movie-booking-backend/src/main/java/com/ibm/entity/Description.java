package com.ibm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * description entity describes the particular movie
 * 
 * author:Jahnavi
 * version:1.0
 * since 3 Jan 2022
 */
@Entity
public class Description {

	@Id
	@GeneratedValue
	@Column(name = "des_id")
	private int descriptionId;
	@Column(length = 30)
	private String writer;
	@Column(length = 30)
	private String actor;
	@Column(length = 30)
	private String actress;
	@Column(length = 30)
	private String director;
	@Column(length = 30)
	private String producer;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "description",cascade = CascadeType.ALL)
	private Movie movie;

	// private Movie movie;
	public Description() {
		super();
	}

	public Description(int descriptionId, String writer, String actor, String actress, String director,
			String producer) {
		super();
		this.descriptionId = descriptionId;
		this.writer = writer;
		this.actor = actor;
		this.actress = actress;
		this.director = director;
		this.producer = producer;
	}

	public int getDescriptionId() {
		return descriptionId;
	}

	public void setDescriptionId(int descriptionId) {
		this.descriptionId = descriptionId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getActress() {
		return actress;
	}

	public void setActress(String actress) {
		this.actress = actress;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	

}
