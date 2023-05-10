package com.isabel.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class NinjaController {

	ArrayList<String> actividades = new ArrayList<String>();
	SimpleDateFormat formatoFecha = new SimpleDateFormat("MMMM d yyyy h:mm a");

	@RequestMapping("/gold")
	public String gold(HttpSession session, Model model) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("actividades", actividades);
		}
		
		if((int)session.getAttribute("gold") < 0) {
			return "redirect:/prision";
		}

		model.addAttribute("gold", session.getAttribute("gold"));
		return "gold.jsp";
	}

	@RequestMapping("/prision")
	public String prision() {
		return "prision.jsp";
	}

	@RequestMapping(value = "/process_money", method = RequestMethod.POST)
	public String gold(@RequestParam(value = "location") String location, HttpSession session) {
		int cantidad = 0;
		int goldObtenido = 0;

		// se valida gold para ver si puede seguir jugando o lo redirreciona a la ruta
		// prision

		if (location.equals("farm")) {
			goldObtenido = new Random().nextInt(10, 21);
			cantidad = (int) session.getAttribute("gold") + goldObtenido;

		} else if (location.equals("cave")) {
			goldObtenido = new Random().nextInt(5, 11);
			cantidad = (int) session.getAttribute("gold") + goldObtenido;
		} else if (location.equals("house")) {
			goldObtenido = new Random().nextInt(2, 6);
			cantidad = (int) session.getAttribute("gold") + goldObtenido;
		} else if (location.equals("casino")) {
			goldObtenido = new Random().nextInt(-50, 51);
			cantidad = (int) session.getAttribute("gold") + goldObtenido;
		} else if (location.equals("spa")) {
			goldObtenido = -(new Random().nextInt(5, 21));
			cantidad = (int) session.getAttribute("gold") + goldObtenido;
		}

//		se actualiza gold

		if (goldObtenido >= 0) {
			actividades.add(0, "You entered a " + location + " and earned " + goldObtenido + " gold ("
					+ formatoFecha.format(new Date()) + ")");
		} else {
			actividades.add(0, "You entered a " + location + " and lost " + goldObtenido + " gold Ouch ("
					+ formatoFecha.format(new Date()) + ")");
		}

		session.setAttribute("gold", cantidad);
		session.setAttribute("actividades", actividades);

		return "redirect:/gold";
	}

	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		actividades.clear();
		session.setAttribute("gold", null);
		session.setAttribute("actividades", actividades);
		return "redirect:/gold";
	}
}
