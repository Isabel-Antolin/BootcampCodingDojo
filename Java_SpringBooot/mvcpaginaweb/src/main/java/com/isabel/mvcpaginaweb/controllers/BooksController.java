package com.isabel.mvcpaginaweb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.isabel.mvcpaginaweb.models.Book;
import com.isabel.mvcpaginaweb.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BooksController {
	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public String viewBooks(Model model) {
		List<Book> books = bookService.allBooks();
		

		if (books.isEmpty()) {
			model.addAttribute("error", "No se encontraron libros");
		} else {
			model.addAttribute("libros", books);
		}
		
		return "index.jsp";
	}
	
	@GetMapping("/books/newBook")
	public String viewNewBook(@ModelAttribute("book") Book book) {
		return "newBook.jsp";
	}

	@PostMapping("/books/newBook")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		 if (result.hasErrors()) {
	            return "newBook.jsp";
	        } else {
	            bookService.createBook(book);
	            return "redirect:/books";
	        }
	}
	
	@GetMapping("/books/{bookId}")
	public String showOneBook(Model model, @PathVariable("bookId") Long bookId) {
		model.addAttribute("libro",bookService.getOneBook(bookId));
		return "show.jsp";
	}
}
