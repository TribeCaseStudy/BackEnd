package com.ibm.service;

import com.ibm.entity.Admin;
import com.ibm.pojo.Login;

public interface AdminService {
	
	void addAdmin(Admin admin);
	
	Admin authenticateAdmin(Login login);
}
