package com.ibm.repo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.entity.ShowScreen;

public interface ShowScreenRepository extends JpaRepository<ShowScreen, Integer>{

	@Query(value = "select * from show_screen where show_date=:date and show_time=:time and screen_no=:sno and status_show=:stat",nativeQuery = true)
	ShowScreen findShowByShowTimeAndShowDateAndScreenNo(@Param("date") LocalDate showDate,@Param("time") LocalTime showTime,@Param("sno") int screenNo,@Param("stat") String statusShow);
	
	@Query(value = "select * from show_screen where movie_id=:mid",nativeQuery = true)
	List<ShowScreen> findAllByMovieId(@Param("mid") int movieId);
	
	List<ShowScreen> findAllByShowDate(LocalDate showDate);
	
	@Query(value="select movie_id from show_screen where show_id=:sid",nativeQuery = true)
	int findMovieId(@Param("sid") int showId);
}
