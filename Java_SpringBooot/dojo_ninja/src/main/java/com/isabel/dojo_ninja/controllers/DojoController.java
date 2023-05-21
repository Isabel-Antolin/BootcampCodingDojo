package com.isabel.dojo_ninja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.isabel.dojo_ninja.models.Dojo;
import com.isabel.dojo_ninja.services.DojoService;
import com.isabel.dojo_ninja.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	@Autowired 
	private DojoService dojoService;
	@Autowired 
	private NinjaService ninjaService;
	
	@GetMapping("/dojos")
	public String index(Model model) {
		List<Object[]> dojoNinjaCount = dojoService.getDojoNinjaCount();
		model.addAttribute("dojos", dojoNinjaCount);
		return "dojos.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String rutaNewDojo(@ModelAttribute("dojo")Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@GetMapping("/dojo/{id}")
	public String rutaDojo(@PathVariable("id") Long id,Model model) {
		model.addAttribute("dojosyninjas", ninjaService.mostrarNinjasDecuardoAlDojo(id) );
		model.addAttribute("dojo",dojoService.encontrarDojo(id));
		return "dojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String newDojo(@Valid @ModelAttribute("dojo")Dojo dojo,BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "newDojo.jsp";
		}
		dojoService.crearDojo(dojo);
		return "redirect:/dojos";
	}
	
}
