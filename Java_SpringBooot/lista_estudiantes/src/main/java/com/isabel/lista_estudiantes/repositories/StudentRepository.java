package com.isabel.lista_estudiantes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isabel.lista_estudiantes.models.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
	List<Student> findAll();
	
//	traera todos los estudiantes que no tengan direccion
//	@Query(value="SELECT s.* FROM students s LEFT JOIN contacts c ON s.id = c.student_id WHERE c.student_id IS NULL;", nativeQuery=true)
	List<Student> findByContactoIdIsNull();

	
}
