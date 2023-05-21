package com.isabel.dojo_ninja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.isabel.dojo_ninja.models.Dojo;
import com.isabel.dojo_ninja.models.Ninja;
import com.isabel.dojo_ninja.services.DojoService;
import com.isabel.dojo_ninja.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {

	@Autowired
	private NinjaService ninjaServices;
	@Autowired
	private DojoService dojoService;

	@GetMapping("/ninjas/new")
	public String rutaNewNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.obtenerDojos();
		model.addAttribute("listaDojos", dojos);
		return "newNinja.jsp";
	}

	@PostMapping("/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja,BindingResult resultado, Model model) {
		List<Dojo> dojos = dojoService.obtenerDojos();
		if (resultado.hasErrors()) {
			model.addAttribute("listaDojos", dojos);
			return "newNinja.jsp";
		} else {
//			validar si existe el ninja en la base de datos
			Boolean existe = ninjaServices.existeNinja(ninja.getFirstName(), ninja.getLastName());
			if (!existe) {
				ninjaServices.crearNinja(ninja);
				return "redirect:/dojos";
			} else {
				model.addAttribute("listaDojos", dojos);
				model.addAttribute("existe", existe);
				return "newNinja.jsp";
			}
		}

	}
}
