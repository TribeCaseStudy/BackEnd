package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.Seat;

public interface SeatRepositroy extends JpaRepository<Seat, Integer>{

}
