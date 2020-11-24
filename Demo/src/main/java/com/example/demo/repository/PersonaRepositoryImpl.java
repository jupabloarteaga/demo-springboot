package com.example.demo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.example.demo.DemoApplication;

@Component
public class PersonaRepositoryImpl implements IPersonaRepository {
	Logger log = LoggerFactory.getLogger(DemoApplication.class);
	@Override
	public void registrar(String nombre) {
		log.info("Se registro a : " +nombre);
		
	}

}
