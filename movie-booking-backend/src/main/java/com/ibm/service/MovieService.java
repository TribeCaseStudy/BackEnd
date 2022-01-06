package com.ibm.service;

import java.util.List;

import com.ibm.entity.Movie;

public interface MovieService {
	
	void addMovie(int desId,Movie movie);
	
	void updateMovie(int desId,Movie movie);
	
	List<Movie> deleteMovieById(int movieId);
	
	List<Movie> findAllMovie();
	
	Movie findByDescriptionId(int desId);
}
