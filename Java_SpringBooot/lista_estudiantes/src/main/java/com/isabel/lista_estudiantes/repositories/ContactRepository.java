package com.isabel.lista_estudiantes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isabel.lista_estudiantes.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{


}
	