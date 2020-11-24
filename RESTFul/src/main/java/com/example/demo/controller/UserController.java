package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IUsers;
import com.example.demo.user.User;

@RestController
@RequestMapping("/main")
public class UserController {

	@Autowired
	IUsers user;
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@GetMapping
	public ResponseEntity<List<User>> listUsers() {
		log.info("Listando usuarios...");
		return new ResponseEntity<List<User>>(user.user(), HttpStatus.OK);
	}

	@GetMapping(value = "/{username}")
	public ResponseEntity<User> findUser(@PathVariable("username") String username) {
		log.info("Buscando usuario....");
		return new ResponseEntity<User>(user.findUser(username), HttpStatus.OK);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public String createUser(@RequestBody User user1) {
		user.addUser(user1);
		log.info("Agregando usuario {}", user1.getUsername());

		return user.toJSON().toString();

	}

	@DeleteMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteUser(@PathVariable String username) {
		log.info("eliminando usuario {}...");
		return user.toJSON().toString();
	}

}
