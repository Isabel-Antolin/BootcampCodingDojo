package com.isabel.lista_estudiantes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isabel.lista_estudiantes.models.Student;
import com.isabel.lista_estudiantes.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> mostrarEstudiantes(){
		return studentRepository.findAll();
	}
	
	public List<Student> mostrarEstudiantesSinDireccion(){
		return studentRepository.findByContactoIdIsNull();
	}
	
}
