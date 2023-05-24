package com.isabel.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.isabel.authentication.models.LoginUser;
import com.isabel.authentication.models.User;
import com.isabel.authentication.services.UserServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private UserServices userServices;

	@GetMapping("/login")
	public String rutaLogin(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "login_registro.jsp";
	}

	@PostMapping("/registration")
	public String guardarUsuario(@Valid @ModelAttribute("user") User user, BindingResult resultado, Model model,HttpSession sesion) {
		if (resultado.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "login_registro.jsp";
		}else {
		     User registeredUser = userServices.registerUser(user, resultado);
		        if (registeredUser == null) {
		            model.addAttribute("loginUser", new LoginUser());
		            return "login_registro.jsp";
		        } else {
		        	User usuarioLog = userServices.findByEmail(user.getEmail());
		        	sesion.setAttribute("userID",  usuarioLog.getId());
		            return "redirect:/dashboard";
		        }
			
		}
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginuser, 
			BindingResult resultado, Model viewModel, HttpSession sesion) {
		if(resultado.hasErrors()) {
			viewModel.addAttribute("user", new User());
			return "login_registro.jsp";
		}
		
		if(userServices.authenticateUser(loginuser.getEmail(), loginuser.getPassword(), resultado)) {
			User usuarioLog = userServices.findByEmail(loginuser.getEmail());
			sesion.setAttribute("userID",  usuarioLog.getId());
			return "redirect:/dashboard";
			
		}else {
			viewModel.addAttribute("user", new User());
			return "login_registro.jsp";
		}
	}

	@GetMapping("/dashboard")
	public String rutaBienvenida(HttpSession sesion, Model viewModel) {
		Long userId = (Long) sesion.getAttribute("userID");
		if(userId == null) {
			return "redirect:/login"; 
		}
		User usuario = userServices.findUserById(userId);
		viewModel.addAttribute("usuario", usuario);
		return "dashboard.jsp";
	}
	

	
	@GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.invalidate();
		 return "redirect:/login";
	 }

}



