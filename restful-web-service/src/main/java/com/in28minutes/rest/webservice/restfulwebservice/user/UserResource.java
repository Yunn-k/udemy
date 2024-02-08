package com.in28minutes.rest.webservice.restfulwebservice.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//rest API를 정의
@RestController
public class UserResource {

	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}
	
	// Get /users
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers(){
		List<User> userList = service.findAll();
		return userList;
	}
	
	@GetMapping(path="/users/{id}")
	public User retrieveAUser(@PathVariable int id) {
		return service.findOne(id);
	}
	
}
