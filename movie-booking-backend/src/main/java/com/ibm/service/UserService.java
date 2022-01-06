package com.ibm.service;

import com.ibm.entity.User;
import com.ibm.pojo.Login;

public interface UserService {
	
	void addUser(User user);
	
	User authenticateUser(Login login);

}
