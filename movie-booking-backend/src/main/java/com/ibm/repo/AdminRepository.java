package com.ibm.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.entity.Admin;
/**
 *author :Deepshikha */
public interface AdminRepository extends JpaRepository<Admin, String>{

	@Query(value="select * from admin where email_id_admin=:email and password_admin=:pass",nativeQuery = true)
	Optional<Admin> authAdmin(@Param("email") String email,@Param("pass")String password);
}
