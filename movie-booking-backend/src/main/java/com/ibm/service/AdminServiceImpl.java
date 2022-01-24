package com.ibm.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Admin;
import com.ibm.pojo.Login;
import com.ibm.repo.AdminRepository;
/**
 * author : Apoorva*/
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository repo;
	
	@Transactional
	@Override
	public void addAdmin(Admin admin) {
		repo.save(admin);
	}

	@Override
	public Admin authenticateAdmin(Login login) {
		
		return repo.authAdmin(login.getEmail(), login.getPassword()).orElseThrow(()->new IllegalArgumentException("Invalid user or password"));
	}

}
