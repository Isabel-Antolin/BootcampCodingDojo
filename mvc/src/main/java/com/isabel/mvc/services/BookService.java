package com.isabel.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isabel.mvc.models.Book;
import com.isabel.mvc.repositories.BookRepository;

@Service
public class BookService {
	// Agregando el book al repositorio como una dependencia
	@Autowired
	private BookRepository bookRepository;

	// Devolviendo todos los libros.
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// Creando un libro.
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	// Obteniendo la información de un libro
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);

		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}


	public Book updateBook(Long id, 
			               String title, 
			               String desc, 
			               String lang, 
			               Integer numOfPages) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			Book bookToUpdate = optionalBook.get();
			bookToUpdate.setTitle(title);
			bookToUpdate.setDescription(desc);
			bookToUpdate.setLanguage(lang);
			bookToUpdate.setNumberOfPages(numOfPages);
			
			bookRepository.save(bookToUpdate);
			return bookToUpdate;
		} else {
			return null;
		}
	}
	
//	public Book updateBook2(Long id, String title, String desc, String lang, int pages) {
//		Book optionalBook = bookRepository.findById(id).orElse(null);
//		if (optionalBook != null) {
//			optionalBook.setTitle(title);
//			optionalBook.setDescription(desc);
//			optionalBook.setLanguage(lang);
//			optionalBook.setNumberOfPages(pages);
//			
//			bookRepository.save(optionalBook);
//			return optionalBook;
//		} else {
//			return optionalBook;
//		}
//	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
