package com.example.demo.service;

import java.util.List;

import org.json.JSONObject;

import com.example.demo.user.User;

public interface IUsers {

	public List<User> user();

	public User findUser(String username);

	public JSONObject toJSON();
	
	public User addUser(User user);
	
	public User deleteUser(String user);
}
