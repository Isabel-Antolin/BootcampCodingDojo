package com.isabel.mvcpaginaweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isabel.mvcpaginaweb.models.Book;
import com.isabel.mvcpaginaweb.repositories.BookRepository;

@Service
public class BookService {

	// llamar al repositorio
	@Autowired
	private BookRepository bookrepo;

//	realizo los metodos que se necesitan

	public List<Book> allBooks() {
		return bookrepo.findAll();
	}

	public Book getOneBook(Long id) {
		Optional<Book> book = bookrepo.findById(id);
		if (book.isPresent()) {
			return book.get();
		} else {
			return null;
		}
	}

	public Book createBook(Book book) {
		return bookrepo.save(book);
	}

	public Book updateBook(Long id, Book updatedBook) {
		// Verificar si el libro existe en la base de datos
		Optional<Book> optionalBook = bookrepo.findById(id);

		if (optionalBook.isPresent()) {
			Book book = optionalBook.get();
			book.setTitle(updatedBook.getTitle());
			book.setDescription(updatedBook.getDescription());
			book.setLanguage(updatedBook.getLanguage());
			book.setNumberOfPages(updatedBook.getNumberOfPages());

//			bookRepository.save(bookToUpdate);
//			return bookToUpdate;
			return bookrepo.save(book);

		} else {
			return null;
		}
	}

	public void deleteBook(Long id) {
		bookrepo.deleteById(id);
	}

//	public void deleteBook(Long id) {
//	    // Verificar si el libro existe en la base de datos
//	    Optional<Book> optionalBook = bookRepository.findById(id);
//	    
//	    if (optionalBook.isPresent()) {
//	        Book book = optionalBook.get();
//	        
//	        bookRepository.delete(book);
//	    } else {
//	        // Manejar el caso en el que no se encuentra el libro a eliminar
//	        throw new BookNotFoundException("El libro con ID " + id + " no existe");
//	    }
//	}
}
