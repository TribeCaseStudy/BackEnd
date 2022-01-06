package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

	@Query(value="select * from booking where email_id_user=:userId",nativeQuery = true)
	List<Booking> findAllByUserId(@Param("uid") String userId);
	
}
