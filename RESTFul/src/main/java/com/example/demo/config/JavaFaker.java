package com.example.demo.config;

import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

@Configuration
public class JavaFaker {

	@Bean
	public Faker getFaker() {
		return new Faker();
	}
	

	@Bean
	public JSONObject json() {
		return new JSONObject();
	}
	
}
	


