package com.ibm.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.ibm.entity.ShowScreen;

public interface ShowScreenService {
	
	void addShow(ShowScreen showScreen);
	
	void updateShow(ShowScreen showScreen);
	
	List<ShowScreen> listShowsAllScreenShow(int movieId);
	
	List<ShowScreen> listShowsAllByShowDate(LocalDate showDate);
	
	ShowScreen findShowByShowTimeAndShowDateAndScreenNo(LocalDate showDate,LocalTime showTime,int screenNo);
	
	ShowScreen findShowByShowId(int showId);

}
