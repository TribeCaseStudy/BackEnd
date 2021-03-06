package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.entity.Movie;
/**
 * author : Deepshikha*/
public interface MovieRepository extends JpaRepository<Movie, Integer>{

	
	@Query(value="select * from movie where des_id=:did", nativeQuery = true)
	Movie findMovieByDescriptionId(@Param("did") int descriptionId);
	
	Movie findMovieByMovieName(String movieName);
}
