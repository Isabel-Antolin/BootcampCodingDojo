package com.isabel.relationships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isabel.relationships.models.Person;
import com.isabel.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;

	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	
	public List<Person> showAll(){
		return personRepository.findAll();
	}
	
	public List<Person> personasSinLicencia(){
//		return personRepository.findByNoLicense();
		return personRepository.findByLicenseIdIsNull();
	}
	
	public Person showPerson(Long id) {
		return personRepository.findById(id).orElse(null);
	}
	
	
}
