package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.entity.Description;

public interface DescriptionRepository extends JpaRepository<Description, Integer>{
	
	@Query(value="select des_id from description where actor=:actor and actress=:actress and director=:director and producer=:producer and writer=:writer",nativeQuery = true)
	int findDes(@Param("actor") String actor,@Param("actress") String actress,@Param("director") String director,@Param("producer") String producer,@Param("writer") String writer);

}
