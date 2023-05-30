package com.isabel.eventos.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.isabel.eventos.models.Estado;
import com.isabel.eventos.models.LoginUser;
import com.isabel.eventos.models.User;
import com.isabel.eventos.services.UserServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class UserController {
	@Autowired
	private UserServices userServices;
	
	@GetMapping("/")
	public String viewLogin(Model model) {
		model.addAttribute("user",new User());
		model.addAttribute("login",new LoginUser());
		model.addAttribute("estados", Estado.estados);
		return "login.jsp";
	}
//	_______________________________________________________
	@PostMapping("/registration")
	public String registrarUsuario(@Valid @ModelAttribute("user") User usuario, 
			BindingResult resultado, Model model) {
		if(resultado.hasErrors()) {
			model.addAttribute("login", new LoginUser());
			model.addAttribute("estados", Estado.estados);
			return "login.jsp";
		}
		//revisar en la base de datos si ya existe el usuario y si no esta se almacena
		User usuarioRegistrado = userServices.registerUser(usuario, resultado);
		 if (usuarioRegistrado == null) {
	            model.addAttribute("login", new LoginUser());
	            return "login.jsp";
	        }
		return "redirect:/";
	}
//	____________________________________________________________________________________________________
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("login") LoginUser loginUser, 
			BindingResult resultado, Model model, HttpSession sesion) {
		if(resultado.hasErrors()) {
			model.addAttribute("user", new User());
			model.addAttribute("estados", Estado.estados);
			return "login.jsp";
		}
		
		if(userServices.authenticateUser(loginUser.getEmail(), loginUser.getPassword(), resultado)) {
			User usuarioLog = (User)userServices.findByEmail(loginUser.getEmail());
			System.out.println(usuarioLog + " antes de setear session");
			sesion.setAttribute("user",  usuarioLog);
			sesion.setAttribute("userID",  usuarioLog.getId());
			System.out.println(sesion.getAttribute("user") + " antes de setear session");
			return "redirect:/events";
			
		}else {
			model.addAttribute("user", new User());
			model.addAttribute("estados", Estado.estados);
			return "login.jsp";
		}
	}
}
