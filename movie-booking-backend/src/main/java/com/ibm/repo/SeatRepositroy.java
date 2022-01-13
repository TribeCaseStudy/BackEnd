package com.ibm.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.entity.Seat;

public interface SeatRepositroy extends JpaRepository<Seat, Integer>{

	@Query(value="select * from seat where show_id=:sid",nativeQuery = true)
	List<Seat> findAllSeatsByShowId(@Param("sid") int showid);
	
	@Query(value="select * from seat where booking_id=:bid",nativeQuery = true)
	List<Seat> findAllSeatsByBookingId(@Param("bid") int bookingid);
	
	@Transactional
	@Modifying 
	@Query(value="update seat set booking_id=:bid where seat_id=:sid",nativeQuery = true)
	Seat updateSeatStat(@Param("bid") int bookingid,@Param("sid") int seatid);
}
