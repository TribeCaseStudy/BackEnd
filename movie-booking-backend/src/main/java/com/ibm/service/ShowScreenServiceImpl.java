package com.ibm.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.ibm.entity.ShowScreen;

public class ShowScreenServiceImpl implements ShowScreenService {

	@Override
	public void addShow(ShowScreen showScreen) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateShow(ShowScreen showScreen) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ShowScreen> listShowsAllByShowDate(LocalDate showDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean findShowByShowTimeAndShowDateAndScreenNo(LocalDate showDate, LocalTime showTime, int screenNo,
			String statusShow) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShowScreen findShowByShowId(int showId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShowScreen> findAllByMovieId(int movieId) {
		// TODO Auto-generated method stub
		return null;
	}

}
