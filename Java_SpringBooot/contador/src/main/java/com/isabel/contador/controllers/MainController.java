package com.isabel.contador.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/your_server")
public class MainController {

	public Integer obtenerCount(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
//		si es la primera vez el contador no tendra valor y le agregara un 0 al count
		if (count == null) {
			count = 0;
		}

		return count;
	}

	public void reiniciarContador(HttpSession session) {
		session.setAttribute("count", 0);
	}

	@RequestMapping("")
	public String index(HttpSession session) {
		Integer count = obtenerCount(session);
		count++;
		session.setAttribute("count", count);
		return "index.jsp";
	}

	@RequestMapping("/counter")
	public String counter(HttpSession session, Model modelo) {
		Integer count = obtenerCount(session);
		modelo.addAttribute("count", count);
		return "counter.jsp";
	}

	@RequestMapping("/counterDos")
	public String counter2(HttpSession session, Model modelo) {
		Integer count = obtenerCount(session);
		count += 2;
		session.setAttribute("count", count);
		modelo.addAttribute("count", count);
		return "counter2.jsp";
	}
	
	@RequestMapping(value="/reset", method=RequestMethod.POST)
	public String resetearContador(HttpSession session) {
	    reiniciarContador(session);
	    return "redirect:/your_server/counter";
	}
	
}
