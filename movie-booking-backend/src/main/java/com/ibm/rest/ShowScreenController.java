package com.ibm.rest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.ShowScreen;
import com.ibm.service.ShowScreenService;

@CrossOrigin
@RestController
public class ShowScreenController {
	
	@Autowired
	private ShowScreenService service;
	
	@PostMapping(value="/show/{movieId}",consumes = "application/json")
	public void addShow(@RequestBody ShowScreen s,@PathVariable int movieId)
	{
		service.addShow(s, movieId);
	}
	
	@PutMapping(value="/show/update/{movieId}",consumes = "application/json")
	public void updateShow(@RequestBody ShowScreen showScreen,@PathVariable int movieId)
	{
		service.updateShow(showScreen, movieId);
	}

	@GetMapping(value="/show/bydate/{showDate}",produces = "application/json") 
	public List<ShowScreen> listShowsAllByDate(@PathVariable LocalDate showDate)
	{
		return service.listShowsAllByShowDate(showDate);
	}
	
	@GetMapping(value="/show/check/{date}/{time}/{sno}/{stat}",produces = "application/json")
	public ShowScreen findByDateAndTime(@PathVariable LocalDate date,@PathVariable LocalTime time,@PathVariable int sno,@PathVariable String stat)
	{
		return service.findShowByShowTimeAndShowDateAndScreenNo(date, time, sno, stat);
	}
	
	@GetMapping(value="/show/sid/{showId}",produces = "application/json")
	public ShowScreen findById(@PathVariable int showId)
	{
		return service.findShowByShowId(showId);
	}
	
	@GetMapping(value="/show/mid/{movieId}",produces = "application/json")
	public List<ShowScreen> findByMovieid(@PathVariable int movieId)
	{
		return service.findAllByMovieId(movieId);
	}
	
	@GetMapping(value="/show/movie/{showId}",produces = "application/json")
	public int findMovieId(@PathVariable int showId)
	{
		return service.findMovieId(showId);
	}
}
