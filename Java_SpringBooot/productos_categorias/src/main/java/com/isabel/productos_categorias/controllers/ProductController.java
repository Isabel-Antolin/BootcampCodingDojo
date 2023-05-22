package com.isabel.productos_categorias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.isabel.productos_categorias.models.Product;
import com.isabel.productos_categorias.models.ProductCategory;
import com.isabel.productos_categorias.services.MainServices;

import jakarta.validation.Valid;

@Controller
public class ProductController {
	@Autowired
	private MainServices mainService;
	
	@GetMapping("products/new")
	public String formularioProducto(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	

	@PostMapping("/products/new")
	public String nuevoProducto(@Valid @ModelAttribute("product") Product product, BindingResult resultado) {
		if (resultado.hasErrors()) {
			return "newProduct.jsp";
		}
		mainService.crearProduct(product);
		return "redirect:/products/new";
	}
	
	@GetMapping("/products/{id}")
	public String mostrarProducto(@PathVariable("id") Long id,
			                      @ModelAttribute("productcategory") ProductCategory productcategory,
			                      Model model) {
		Product producto = mainService.getProduct(id);
		model.addAttribute("producto", producto);
		model.addAttribute("categorias", mainService.ProductSinCategory(producto));

		return "showProduct.jsp";

	}
}
