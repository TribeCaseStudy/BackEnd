package com.ibm.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.ibm.entity.ShowScreen;

public interface ShowScreenService {
	
	/**first check the presence of data by using the following:
	 * Boolean findShowByShowTimeAndShowDateAndScreenNo(LocalDate showDate,LocalTime showTime,int screenNo,String statusShow);
	 * if its false then add */
	void addShow(ShowScreen showScreen);//movieId is null initially
	
	void updateShow(ShowScreen showScreen);
	
	List<ShowScreen> listShowsAllByShowDate(LocalDate showDate);
	
	Boolean findShowByShowTimeAndShowDateAndScreenNo(LocalDate showDate,LocalTime showTime,int screenNo,String statusShow);
	
	ShowScreen findShowByShowId(int showId);
	
	List<ShowScreen> findAllByMovieId(int movieId);

}
