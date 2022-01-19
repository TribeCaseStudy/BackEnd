package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Movie;
import com.ibm.repo.DescriptionRepository;
import com.ibm.repo.MovieRepository;
@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repo;
	
	@Autowired
	private DescriptionRepository des_repo;
	
	@Override
	public void addMovie(int desId, Movie movie) {
		movie.setDescription(des_repo.findById(desId).get());
		repo.save(movie);
	}

	@Override
	public void updateMovie(int desId, Movie movie) {
		movie.setDescription(des_repo.findById(desId).get());
		repo.save(movie);
	}

	@Override
	public List<Movie> deleteMovieById(int movieId) {
		// TODO Auto-generated method stub
		repo.deleteById(movieId);
		return repo.findAll();
	}

	@Override
	public List<Movie> findAllMovie() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Movie findByDescriptionId(int desId) {
		// TODO Auto-generated method stub
		return repo.findMovieByDescriptionId(desId);
	}

	@Override
	public Movie findByMovieId(int movieId) {
		// TODO Auto-generated method stub
		return repo.findById(movieId).get();
	}

	@Override
	public Movie findMovieByMovieName(String movieName) {
		// TODO Auto-generated method stub
		return repo.findMovieByMovieName(movieName);
	}

}
