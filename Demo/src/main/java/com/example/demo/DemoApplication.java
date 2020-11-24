package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.component.IDatosPersona;
import com.example.demo.service.IPersonaService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	Logger log = LoggerFactory.getLogger(DemoApplication.class);
	@Autowired
	private IPersonaService service;
	
	@Autowired
	private IDatosPersona dpersona;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.registrar("Juan");
		dpersona.datos("Mis datos son");
	}
	
	

}
