package com.isabel.dojo_ninja.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isabel.dojo_ninja.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{

	List<Dojo>findAll();
	
//    @Query(value="SELECT d.name AS name, COUNT(n.dojo.id) AS count FROM Ninja n RIGHT JOIN n.dojo d GROUP BY d.name",nativeQuery=true)
    @Query(value="SELECT d.name AS name,COUNT(n.dojo_id) AS count FROM Ninjas n RIGHT JOIN Dojos d on d.id =n.dojo_id GROUP BY name",nativeQuery=true)
    List<Object[]> findDojoNinjaCount();

}
