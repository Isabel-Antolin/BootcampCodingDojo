package com.isabel.dojo_ninja.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.isabel.dojo_ninja.models.Ninja;

@Repository
public interface NinjaRepository  extends CrudRepository<Ninja, Long>{
	List<Ninja>findAll();
	
//	debo validar si el ninja que ingresare ya existe en la tabla ninja
	 boolean existsByFirstNameAndLastName(String firstName, String lastName);
	 
	//
	 List<Ninja>findByDojoId(Long dojoId);
}
