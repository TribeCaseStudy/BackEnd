package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.entity.Seat;

public interface SeatRepositroy extends JpaRepository<Seat, Integer>{

	@Query(value="select * from seat where show_id=:sid",nativeQuery = true)
	List<Seat> findAllSeatsByShowId(@Param("sid") int showid);
	
	@Query(value="selct * from seat where booking_id=:bid",nativeQuery = true)
	List<Seat> findAllSeatsByBookingId(@Param("bid") int bookingId);
	
	@Query(value="select * from seat where show_id=:sid and seat_no=:sno",nativeQuery = true)
	Seat findByShowIdAndSeatNo(@Param("sid") int showId,@Param("sno") int seatNo);
}
