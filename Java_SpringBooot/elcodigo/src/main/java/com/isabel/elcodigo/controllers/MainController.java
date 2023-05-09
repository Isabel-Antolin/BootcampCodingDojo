package com.isabel.elcodigo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String index(@RequestParam(value = "cajaTexto") String cajaTexto,RedirectAttributes redirectAttributes) {
		if(!cajaTexto.equals("bushido")) {
			redirectAttributes.addFlashAttribute("error", "You must train harder!");
			return "redirect:/";
		}
		return "redirect:/code";
	}
	
	@RequestMapping("/code")
	public String code(Model model) {
		ArrayList<String> secret = new ArrayList<>();
		secret.addAll(Arrays.asList("Loyalty","Courage","Veracity","Compassion","Honor"));
		model.addAttribute("lista",secret);
		return "code.jsp";
	}
}
