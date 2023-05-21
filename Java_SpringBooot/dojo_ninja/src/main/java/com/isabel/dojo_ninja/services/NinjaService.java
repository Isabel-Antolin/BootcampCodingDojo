package com.isabel.dojo_ninja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isabel.dojo_ninja.models.Ninja;
import com.isabel.dojo_ninja.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepository;

	public Ninja crearNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}

	public List<Ninja> todosNinjas() {
		return ninjaRepository.findAll();
	}

//	debo validar si el ninja que ingresare ya existe en la tabla ninja
	public Boolean existeNinja(String firstName, String lastName) {
		return ninjaRepository.existsByFirstNameAndLastName(firstName, lastName);
	}

	public List<Ninja> mostrarNinjasDecuardoAlDojo(Long idDojo) {
		return ninjaRepository.findByDojoId(idDojo);
	}

}
