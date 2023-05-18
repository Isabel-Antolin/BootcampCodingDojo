package com.isabel.relationships.repositories;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isabel.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	List<Person>findAll();
	
	
//	@Query(value="SELECT p.* FROM persons p LEFT JOIN licenses l ON p.id = l.person_id WHERE l.person_id IS NULL", nativeQuery=true)
//	List<Person>findByNoLicense();
//	
	
//	ES LO MISMO QUE EL DE ARRIBA
	List<Person> findByLicenseIdIsNull();
}
