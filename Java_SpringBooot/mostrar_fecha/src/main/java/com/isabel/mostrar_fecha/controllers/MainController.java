package com.isabel.mostrar_fecha.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String rutaIndex() {
		return "index.jsp";
	}

	@RequestMapping("/date")
	public String rutaDate(Model modelo) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, 'del' d 'de' MMMM, yyyy");
		String fechaActual = dateFormat.format(new Date());
		
		modelo.addAttribute("fechaActual", fechaActual);
		return "date.jsp";
	}

	@RequestMapping("/time")
	public String rutaTime(Model modelo) {
		SimpleDateFormat hora = new SimpleDateFormat("HH:mm a");
		String horaActual = hora.format(new Date());
		
		modelo.addAttribute("horaActual",horaActual);
		return "time.jsp";
	}

}
