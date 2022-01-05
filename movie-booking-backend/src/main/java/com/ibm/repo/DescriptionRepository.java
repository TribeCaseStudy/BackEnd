package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.Description;

public interface DescriptionRepository extends JpaRepository<Description, Integer>{

}
