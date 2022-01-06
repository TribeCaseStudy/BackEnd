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
	
	@Query(value="update seat set status_seat='vacant' ,booking_id=:NULL where booking_id=:bid",nativeQuery = true)
	void updateAllSeatStatusByBookingId(@Param("bid") int bookingId);
	
	@Query(value="update seat set booking_id=:bid,status_seat='booked' where seat_no=:sno and show_id=sid",nativeQuery = true)
	void updateSeat(@Param("bid") int bookingId,@Param("sid") int showId,@Param("sno") int seatNo);
}
