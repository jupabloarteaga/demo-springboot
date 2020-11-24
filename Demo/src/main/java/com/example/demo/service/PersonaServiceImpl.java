package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IPersonaRepository;

@Service
public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	private IPersonaRepository repository;
	
	@Override
	public void registrar(String nombre) {
		repository.registrar(nombre);
		
	}

}
