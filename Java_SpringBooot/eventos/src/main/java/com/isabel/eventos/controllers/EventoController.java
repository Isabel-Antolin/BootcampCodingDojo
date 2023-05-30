package com.isabel.eventos.controllers;

import java.util.List;

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

import com.isabel.eventos.models.Estado;
import com.isabel.eventos.models.Evento;
import com.isabel.eventos.models.Mensaje;
import com.isabel.eventos.models.User;
import com.isabel.eventos.services.EventoServices;
import com.isabel.eventos.services.MensajeServices;
import com.isabel.eventos.services.UserServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class EventoController {

	@Autowired
	private EventoServices eventoServices;
	@Autowired
	private UserServices userServices;
	@Autowired
	private MensajeServices mensajeServices;
	
//	validar sesion
	public Boolean validarSession(HttpSession session) {
		return (session.getAttribute("userID") != null);
	}

//	____________________________________________________________Get____________________________________________________________________
	@GetMapping("/events")
	public String viewEvents(HttpSession session, Model model, @ModelAttribute("evento") Evento evento) {
		// Verificar si la sesión existe
		if(validarSession(session)) {
			User usuario = userServices.findUserById((Long) session.getAttribute("userID")); //obtengo toda la informacion del usuario
			List<Evento> listaEventosPorEstado = eventoServices.obtenerEventosPorEstado(usuario.getEstado()); // obtener lista de eventos segun el estado del usuario
			List<Evento> listaEventoDistintaAlEstadoDelUsuario = eventoServices.obtenerEventosPorEstadoDistintoAlDelUsaurio(usuario.getEstado());// obtener lista de eventos disitnto el estado del usuario
			model.addAttribute("usuario", usuario);
			model.addAttribute("listaEventosPorEstado", listaEventosPorEstado);
			model.addAttribute("listaOtrosEventos", listaEventoDistintaAlEstadoDelUsuario);
			model.addAttribute("estados", Estado.estados);
			return "/Eventos/events.jsp";
		}
		return "redirect:/";
	}

	@GetMapping("/events/{id}/edit")
	public String EditarEvento(@PathVariable("id") Long IdEvento, Model model, HttpSession session,@ModelAttribute("event") Evento evento) {
		// Verificar si la sesión existe
		if(validarSession(session)) {
			Evento unEvento = eventoServices.findById(IdEvento);//obtengo el evento que se esta consultando por url y se desea editar
			if (unEvento == null) {
				return "redirect:/events";
			}
			model.addAttribute("usuario", userServices.findUserById((Long) session.getAttribute("userID")));
			model.addAttribute("evento", unEvento);
			model.addAttribute("estados", Estado.estados);
			return "/Eventos/editarEvento.jsp";
		}
		return "redirect:/";
	}
	
	@GetMapping("/events/{id}")
	public String MostrarEvento(@PathVariable("id") Long IdEvento, HttpSession session, Model model,@ModelAttribute("mensaje") Mensaje mensaje) {
		// Verificar si la sesión existe
		if(validarSession(session)) {
			Evento unEvento = eventoServices.findById(IdEvento);//obtengo el evento que se esta consultando por url y se desea editar
			if (unEvento == null) {
				return "redirect:/events";
			}
			model.addAttribute("usuario", userServices.findUserById((Long) session.getAttribute("userID")));
			model.addAttribute("evento", unEvento);
			return "/Eventos/mostrarEvento.jsp";
		}
			return "redirect:/";	
	}
	
	//_____________________ Controlador para unirse o cancelar de un evento
	@GetMapping("/event/{eventoId}/{opcion}")
	public String UnirseEvento(@PathVariable("eventoId") Long eventoId, @PathVariable("opcion") String opcion,
			HttpSession session) {
		
		// Verificar si la sesión existe
		if(validarSession(session)) {
			Evento unEvento = eventoServices.findById(eventoId);//obtengo el evento que se esta consultando por url y se desea editar
			User usuario = userServices.findUserById((Long)session.getAttribute("userID"));
			boolean unirse = (opcion.equals("unirse"));
			
			if (unEvento == null) {
				return "redirect:/events";
			}
			
			if (unirse) {
				unEvento.getAsistentes().add(usuario);
			} else {
				unEvento.getAsistentes().remove(usuario);
			}
			eventoServices.guardarEvento(unEvento);
			return "redirect:/events";
		}
		return "redirect:/";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userID", null);
		return "redirect:/";
	}
	
//	_________________________________________________________POST________________________________________________________________
	@PostMapping("/newEvento")
	public String nuevoEvento(@Valid @ModelAttribute("evento") Evento evento, BindingResult resultado, Model model,HttpSession sesion) {
		if(validarSession(sesion)) {
			User usuario = userServices.findUserById((Long) sesion.getAttribute("userID"));
			if (resultado.hasErrors()) {
				List<Evento> listaEventosPorEstado = eventoServices.obtenerEventosPorEstado(usuario.getEstado()); // obtener lista de eventos segun el estado del usuario
				List<Evento> listaEventoDistintaAlEstadoDelUsuario = eventoServices.obtenerEventosPorEstadoDistintoAlDelUsaurio(usuario.getEstado());// obtener lista de eventos disitnto el estado del usuario
				model.addAttribute("usuario", usuario);
				model.addAttribute("listaEventosPorEstado", listaEventosPorEstado);
				model.addAttribute("listaOtrosEventos", listaEventoDistintaAlEstadoDelUsuario);
				model.addAttribute("estados", Estado.estados);
				return "/Eventos/events.jsp";
			}
			evento.setUser(usuario);
			eventoServices.guardarEvento(evento);
			return "redirect:/events";
		}
		return "redirect:/";
	}
	
	@PostMapping("/events/agregarMensaje")
	public String agregarMensaje(@Valid @ModelAttribute("mensaje") Mensaje mensaje,BindingResult resultado,HttpSession sesion,Model model) {
		if(validarSession(sesion)) {
			if (resultado.hasErrors()) {
				model.addAttribute("usuario", userServices.findUserById((Long) sesion.getAttribute("userID")));
				model.addAttribute("evento", eventoServices.findById(mensaje.getEvento().getId()));
				return "/Eventos/mostrarEvento.jsp";
			}
			Evento evento = eventoServices.findById(mensaje.getEvento().getId());
			if (evento == null) {
				return "redirect:/events";
			}
			User usuario = userServices.findUserById((Long)sesion.getAttribute("userID"));
			mensaje.setUser(usuario);
			mensajeServices.guardarMensaje(mensaje);
			return "redirect:/events/"+ mensaje.getEvento().getId();		
		}
		return "redirect:/";
	}
	
//	__________________________________________________PUT-DELETE ___________________________________________

	@PutMapping("/{id}")
	public String EditarEvento(@Valid @ModelAttribute("evento") Evento evento, BindingResult resultado,
			@PathVariable("id") Long id, Model model, HttpSession sesion) {

		if(validarSession(sesion)) {
			if(resultado.hasErrors()) {
				Evento unEvento = eventoServices.findById(id);
				if(unEvento == null ) {
					return "redirect:/events";
				}
				model.addAttribute("usuario", userServices.findUserById((Long)sesion.getAttribute("userID")));
				model.addAttribute("evento", unEvento);
				model.addAttribute("estados", Estado.estados);
				return "/Eventos/editarEvento.jsp";
			}
			eventoServices.actualizarEvento(evento);
			return "redirect:/events";
		}
		return "redirect:/";
	}


	@DeleteMapping("/events/{id}")
	public String borrarEvento(@PathVariable("id") Long id) {
		eventoServices.borrarEvento(id);
		return "redirect:/events";
	}
	

	

}
