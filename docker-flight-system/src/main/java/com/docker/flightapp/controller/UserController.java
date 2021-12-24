package com.docker.flightapp.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docker.flightapp.entity.UserEntity;
import com.docker.flightapp.model.UserDetails;
import com.docker.flightapp.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1.0")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService service;
	
	@PostMapping(value = "/create/user")
	public ResponseEntity<String> createUser(@RequestBody UserDetails requestModel) throws Exception {
		logger.info("Inside createUser method");
		service.createUser(requestModel);
		logger.info("Returning create new user response");
		return new ResponseEntity<>("New User Created Successfully...", HttpStatus.OK);
	}

	@GetMapping(value = "/search/user/data/{userId}")
	public ResponseEntity<Optional<UserEntity>> searchUserData(@PathVariable long userId) {
		logger.info("Inside searchUserData method");
		logger.info("Returning search searchUserData response");
		return new ResponseEntity<>(service.searchUserData(userId), HttpStatus.OK);
	}


}
