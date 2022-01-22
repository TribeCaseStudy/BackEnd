package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.entity.Booking;
/**
 * author : Deepshikha*/
public interface BookingRepository extends JpaRepository<Booking, Integer>{

	@Query(value="select * from booking where email_id_user=:uid",nativeQuery = true)
	List<Booking> findAllByUserId(@Param("uid") String userId);
	
}
