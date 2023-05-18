package com.isabel.lista_estudiantes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isabel.lista_estudiantes.models.Contact;
import com.isabel.lista_estudiantes.repositories.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;
	
	public Contact createContact(Contact contact) {
		return contactRepository.save(contact);
	}
}
