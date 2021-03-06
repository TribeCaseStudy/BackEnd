package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Movie;
import com.ibm.service.MovieService;
/**
 * author : Jahnavi
 * testing : Ardra*/
@CrossOrigin
@RestController
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@PostMapping(value="/movie/{desId}",consumes = "application/json")
	public void addMovie(@PathVariable int desId,@RequestBody Movie m)
	{
		service.addMovie(desId, m);
	}
	
	@PutMapping(value="/movie/update/{desId}",consumes = "application/json")
	public void updateMovie(@PathVariable int desId,@RequestBody Movie movie)
	{
		service.updateMovie(desId, movie);
	}
	
	@DeleteMapping(value="/movie/del/{movieId}",produces = "application/json")
	public List<Movie> deleteMovie(@PathVariable int movieId)
	{
		return service.deleteMovieById(movieId);
	}
	
	@GetMapping(value="/movie/all",produces = "application/json")
	public List<Movie> findAllMovie()
	{
		return service.findAllMovie();
	}
	
	@GetMapping(value="/movie/desId/{desId}",produces = "application/json")
	public Movie findByDes(@PathVariable int desId)
	{
		return service.findByDescriptionId(desId);
	}
	
	@GetMapping(value="/movie/Id/{movieId}",produces = "application/json")
	public Movie findByMovieId(@PathVariable int movieId)
	{
		return service.findByMovieId(movieId);
	}
	
	@GetMapping(value="/movie/find/{movieName}",produces = "application/json")
	public Movie findByMovieName(@PathVariable String movieName)
	{
		return service.findMovieByMovieName(movieName); 
	}

}
