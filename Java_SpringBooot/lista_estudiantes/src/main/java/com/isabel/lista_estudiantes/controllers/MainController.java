package com.isabel.lista_estudiantes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.isabel.lista_estudiantes.models.Contact;
import com.isabel.lista_estudiantes.models.Student;
import com.isabel.lista_estudiantes.services.ContactService;
import com.isabel.lista_estudiantes.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private ContactService contactService;
	

	@GetMapping("/students/new")
	public String rutaNewStudent(@ModelAttribute("student") Student student) {
		return "new_students.jsp";
	}
	
	@PostMapping("students/new")
	public String newStudent(@Valid @ModelAttribute("student") Student student,BindingResult result) {
		if (result.hasErrors()) {
			return "new_students.jsp";
		} else {
			studentService.createStudent(student);
			return "redirect:/students/new";
		}
	}
	
//	_______________________________________________________________________________
	
	@GetMapping("contact/new")
	public String rutaNewContact(Model model,@ModelAttribute("contact") Contact contact) {
		List<Student>listStudent =studentService.mostrarEstudiantesSinDireccion();
		model.addAttribute("listStudent",listStudent );
		return "new_contact.jsp";
	}
	
	@PostMapping("contact/new")
	public String newContact(@Valid @ModelAttribute("contact") Contact contact,BindingResult result,Model model) {
		List<Student>listStudent =studentService.mostrarEstudiantesSinDireccion();
		model.addAttribute("listStudent",listStudent );
		if (result.hasErrors()) {
			return "new_contact.jsp";
		} else {
			contactService.createContact(contact);
			return "redirect:/contact/new";
		}
	}
//	_______________________________________________________________________________
	@GetMapping("/students")
	public String rutaStudents(Model model) {
		List<Student> list=studentService.mostrarEstudiantes();
		model.addAttribute("students", list);
		return "students.jsp";
	}

}
