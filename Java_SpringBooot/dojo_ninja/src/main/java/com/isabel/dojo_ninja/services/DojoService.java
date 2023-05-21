package com.isabel.dojo_ninja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isabel.dojo_ninja.models.Dojo;
import com.isabel.dojo_ninja.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepository;

	public List<Dojo> obtenerDojos() {
		return dojoRepository.findAll();
	}
	
	public Dojo crearDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	public Dojo encontrarDojo(Long id) {
		return dojoRepository.findById(id).orElse(null);
	}
	
	 public List<Object[]> getDojoNinjaCount() {
	        return dojoRepository.findDojoNinjaCount();
	    }
}
