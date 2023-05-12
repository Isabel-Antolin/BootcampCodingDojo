package com.isabel.mvcpaginaweb.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isabel.mvcpaginaweb.models.Book;


@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
	
	List<Book> findAll();// Este método recupera todos los libros de la base de datos
	
//	List<Book> findByDescriptionContaining(String search);// Este método encuentra un libro por su descripción
//   Long countByTitleContaining(String search); // Este método cuenta cuántos libros contiene cierta cadena en el título
//	Long deleteByTitleStartingWith(String search); // Este método borra un libro que empieza con un título específico
	
	
}
