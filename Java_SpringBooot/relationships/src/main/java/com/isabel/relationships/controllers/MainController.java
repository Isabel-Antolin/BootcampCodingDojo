package com.isabel.relationships.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.isabel.relationships.models.License;
import com.isabel.relationships.models.Person;
import com.isabel.relationships.services.LicenseService;
import com.isabel.relationships.services.PersonService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private PersonService personService;
	@Autowired
	private LicenseService licenseService;

	@GetMapping("/")
	public String rutaPrincipal(Model model) {
		List<Person> personas = personService.showAll();
		model.addAttribute("persona", personas);
		return "index.jsp";
	}

	@GetMapping("/persons/new")
	public String rutaNewPerson(@ModelAttribute("person") Person person) {
		return "newPerson.jsp";
	}

	@GetMapping("/licenses/new")
	public String rutaNewLicenses(@ModelAttribute("license") License license, Model model) {
		List<Person> listaPerson = personService.personasSinLicencia();
		model.addAttribute("persons", listaPerson);
		return "newLicense.jsp";
	}

	@GetMapping("/persons/{id}")
	public String rutaPerson(@PathVariable("id")Long id,Model model) {
		model.addAttribute("persona", personService.showPerson(id));
		return "person.jsp";
	}

	@PostMapping("/person/newPerson")
	public String newPerson(@Valid @ModelAttribute("person") Person person, BindingResult resultado) {
		if (resultado.hasErrors()) {
			return "newPerson.jsp";
		} else {
			personService.createPerson(person);
			return "redirect:/";
		}

	}

	@PostMapping("/license/newLicense")
	public String newLicense(@Valid @ModelAttribute("license") License license, BindingResult resultado,Model model) {
//		Long personId = license.getPerson().getId();
		List<Person> listaPerson = personService.personasSinLicencia();
		model.addAttribute("persons", listaPerson);
		if (resultado.hasErrors()) {
			return "newLicense.jsp";
		} else {
			License lastLicense = licenseService.findTopByOrderByNumeroDesc();
			String newLicenseNumber;

			if (lastLicense == null) {
				newLicenseNumber = "000001";
			} else {
				int lastNumber = Integer.parseInt(lastLicense.getNumero());
				int newNumber = lastNumber + 1;
				newLicenseNumber = String.format("%06d", newNumber); // Formato "000001"
			}
			license.setNumero(newLicenseNumber);
			licenseService.createLicense(license);
			return "redirect:/";
		}

	}

}
