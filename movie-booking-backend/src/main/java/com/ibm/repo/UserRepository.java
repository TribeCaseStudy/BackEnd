package com.ibm.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	@Query(value="select * from user where email_id_user=:email and password_user=:pass",nativeQuery = true)
	Optional<User> authUser(@Param("email") String email,@Param("pass") String password);

}
