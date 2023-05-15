package com.isabel.languajes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.isabel.languajes.models.Languages;
import com.isabel.languajes.services.LanguagesServices;

import jakarta.validation.Valid;



@Controller
public class LanguagesController {
	@Autowired
	private LanguagesServices languagesService;
	private static final String redirectAPrincipal = "redirect:/languages";
	
	@GetMapping("/languages")
	public String showIndex(Model model, @ModelAttribute("language") Languages l) {
		model.addAttribute("languages",languagesService.showLenguages());
		return "index.jsp";
	}
	
	@GetMapping("/languages/{id}")
	public String showIndex(@PathVariable("id") Long id,Model model) {
		Languages languageObtained = languagesService.showLanguagesbyId(id);
		model.addAttribute("lenguage", languageObtained);
		return "show.jsp";
	}
	
	@PostMapping("/languages")
	public String newLanguages(@Valid @ModelAttribute("language") Languages l,BindingResult result,Model model) {
		model.addAttribute("languages",languagesService.showLenguages());
		if(result.hasErrors()) {
			return "/index.jsp";
		}else {
			languagesService.createLanguage(l);
			return redirectAPrincipal;
		}
	}
	
	@GetMapping("/languages/{id}/edit")
	public String showEdit(Model model, @ModelAttribute("language") Languages l,@PathVariable("id") Long id) {
		Languages languageObtained = languagesService.showLanguagesbyId(id);
		model.addAttribute("language", languageObtained);
		return "edit.jsp";
	}
	@PutMapping("/languages/{id}")
	public String updateLanguages(@Valid @ModelAttribute("language") Languages l,
			                      @PathVariable("id") Long id,
			                      BindingResult result) {

		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			languagesService.updateLanguage(id, l);
			return redirectAPrincipal;
		}
	}
	
	@DeleteMapping("/languages/{id}")
	public String deleteLanguages(@PathVariable("id") Long id) {
		languagesService.deleteLanguage(id);
		return "redirect:/languages";
	};
	
}
