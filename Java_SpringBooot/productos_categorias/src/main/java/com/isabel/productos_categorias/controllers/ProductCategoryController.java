package com.isabel.productos_categorias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.isabel.productos_categorias.models.ProductCategory;
import com.isabel.productos_categorias.services.MainServices;

@Controller
public class ProductCategoryController {
	@Autowired
	private MainServices mainService;
	
	
	@PostMapping("/aso/{idProduct}")
	public String asociarCategoriaProducto(@PathVariable("idProduct")Long idProduct,
			@ModelAttribute("productcategory") ProductCategory productcategory,
			Model viewModel, BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "showrProduct.jsp";
		}
		mainService.crearVinculo(productcategory);
		return "redirect:/products/"+idProduct;
	}
	
	@GetMapping("/")
	public String rutaPrincipal(Model model) {
		//obtener los productos, ademas un count con la categorias
		 List<Object[]> productTable = mainService.getProductTable();
		 List<Object[]> categoryTable = mainService.getCategoryTable();
	      model.addAttribute("productTable", productTable);
	      model.addAttribute("categoryTable", categoryTable);
		return "index.jsp";
	}

}
