package com.ibm.rest;

/**
 * author : Jahnavi
 * testing : Ardra*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.entity.User;
import com.ibm.pojo.EMail;
import com.ibm.pojo.Login;
import com.ibm.service.LoginServiceInterface;
import com.ibm.service.UserService;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private LoginServiceInterface email;
	
	@PostMapping(value="/user",consumes = "application/json")
	public void addUser(@RequestBody User user)
	{
		service.addUser(user);
		email.userEmailConfirm(user.getEmailId(), user.getUserName());
	}
	
	@GetMapping(value="/user/{email}/{password}",produces = "application/json")
	public ResponseEntity<?> validateUser(@PathVariable String email,@PathVariable String password)
	{
		Login login=new Login(email,password);
		try {
			User user=service.authenticateUser(login);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<String>("Invalid Email Id or Password",HttpStatus.NOT_FOUND);
		}
	}

}
