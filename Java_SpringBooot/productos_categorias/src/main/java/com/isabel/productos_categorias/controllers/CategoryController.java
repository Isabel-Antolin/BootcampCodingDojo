package com.isabel.productos_categorias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.isabel.productos_categorias.models.Category;
import com.isabel.productos_categorias.models.ProductCategory;
import com.isabel.productos_categorias.services.MainServices;

import jakarta.validation.Valid;

@Controller
public class CategoryController {
	@Autowired
	private MainServices mainService;
	
	@GetMapping("/categories/new")
	public String formularioCategoria(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	

	@PostMapping("/categories/new")
	public String nuevoProducto(@Valid @ModelAttribute("category") Category category, BindingResult resultado) {
		if (resultado.hasErrors()) {
			return "newCategory.jsp";
		}
		mainService.crearCategory(category);
		return "redirect:/categories/new";
	}
	
	@GetMapping("/categories/{id}")
	public String mostrarProducto(@PathVariable("id") Long id,
			                      @ModelAttribute("productcategory") ProductCategory productcategory,
			                      Model model) {
		Category category = mainService.getCategory(id);
		model.addAttribute("categoria", category);
		
    	model.addAttribute("productos", mainService.CategoriasSinProducto(category));

		return "showCategory.jsp";

	}
}
