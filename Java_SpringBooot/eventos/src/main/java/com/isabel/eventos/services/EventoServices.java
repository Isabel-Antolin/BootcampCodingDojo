package com.isabel.eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isabel.eventos.models.Evento;
import com.isabel.eventos.models.User;
import com.isabel.eventos.repositories.EventoRespository;

@Service
public class EventoServices {
	@Autowired

	private EventoRespository eventoRespository;
	
	public Evento guardarEvento(Evento evento) {
		return eventoRespository.save(evento);
	}
	public List<Evento>obtenerEventosPorEstado(String estado){
		return  eventoRespository.findByEstado(estado);
	}
	public List<Evento>obtenerEventosPorEstadoDistintoAlDelUsaurio(String estado){
		return  eventoRespository.findByEstadoIsNot(estado);
	}
	
	public Evento findById(Long id) {
		return eventoRespository.findById(id).orElse(null);
	}
	
	//ACTUALIZAR EVENTO
	public Evento actualizarEvento(Evento evento) {
		return eventoRespository.save(evento);
	}
	
	//BORRAR EVENTO
	public void borrarEvento(Long id) {
		eventoRespository.deleteById(id);
	}
	

}
