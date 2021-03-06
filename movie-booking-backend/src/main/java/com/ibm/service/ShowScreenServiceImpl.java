package com.ibm.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.ShowScreen;
import com.ibm.repo.MovieRepository;
import com.ibm.repo.ShowScreenRepository;
/**
 * author : Ardra*/
@Service
public class ShowScreenServiceImpl implements ShowScreenService {

	@Autowired
	private ShowScreenRepository repo;
	
	@Autowired
	private MovieRepository mRepo; 
	
	@Transactional
	@Override
	public void addShow(ShowScreen showScreen,int movieId) {
		showScreen.setMovie(mRepo.getById(movieId));
		repo.save(showScreen);
	}

	@Transactional
	@Override
	public void updateShow(ShowScreen showScreen, int movieId) {
		showScreen.setMovie(mRepo.getById(movieId));
		repo.save(showScreen);

	}

	@Override
	public List<ShowScreen> listShowsAllByShowDate(LocalDate showDate) {
		return repo.findAllByShowDate(showDate);
	}

	@Override
	public ShowScreen findShowByShowTimeAndShowDateAndScreenNo(LocalDate showDate, LocalTime showTime, int screenNo,
			String statusShow) {
		return repo.findShowByShowTimeAndShowDateAndScreenNo(showDate, showTime, screenNo, statusShow);
	}

	@Override
	public ShowScreen findShowByShowId(int showId) {
		// TODO Auto-generated method stub
		return repo.findById(showId).get();
	}

	@Override
	public List<ShowScreen> findAllByMovieId(int movieId) {
		// TODO Auto-generated method stub
		return repo.findAllByMovieId(movieId);
	}

	@Override
	public int findMovieId(int showId) {
		// TODO Auto-generated method stub
		return repo.findMovieId(showId);
	}

}
