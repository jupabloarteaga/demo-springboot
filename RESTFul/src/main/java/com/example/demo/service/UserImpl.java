package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.user.User;
import com.github.javafaker.Faker;

@Service
public class UserImpl implements IUsers {

	private static final Logger log = LoggerFactory.getLogger(UserImpl.class);

	private List<User> users = new ArrayList<>();
	private final String success = "User add successfull!";

	@Autowired
	Faker faker;

	@Autowired
	JSONObject json;

	@Autowired
	User user;

	@Override
	public List<User> user() {
		log.info("Llenando objetos user en array");
		for (int i = 1; i <= 5; i++) {
			users.add(new User(faker.name().firstName(), faker.cat().name()));
		}

		return users;
	}

	@Override
	public User findUser(String username) {
		return users.stream().filter(u -> u.getUsername().equals(username)).findAny().orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("USER %s NOT FIND", username)));
	}

	@Override
	public JSONObject toJSON() {

		json.put("status", 200);
		json.put("message", success);
		return json;
	}

	@Override
	public User addUser(User user) {
		if (users.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()))) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("User %s exist", user.getUsername()));

		}
		users.add(user);
		return user;
	}

	@Override
	public User deleteUser(String usuario) {
		User user = findUser(usuario);
		if (users.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()))) {
			users.remove(user);
		}
		return user;
	}

}
