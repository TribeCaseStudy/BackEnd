package com.ibm.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.User;
import com.ibm.pojo.Login;
import com.ibm.repo.UserRepository;
/**
 * author : Apoorva*/
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	
	@Transactional
	@Override
	public void addUser(User user) {
		repo.save(user);
	}

	@Override
	public User authenticateUser(Login login) {
		return repo.authUser(login.getEmail(), login.getPassword()).orElseThrow(()->new IllegalArgumentException("invalid emailid or password"));
	}

}
