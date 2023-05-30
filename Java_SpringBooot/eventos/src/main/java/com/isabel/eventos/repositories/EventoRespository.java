package com.isabel.eventos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isabel.eventos.models.Evento;

@Repository
public interface EventoRespository extends CrudRepository<Evento, Long>{
	List<Evento>findByEstado(String estado);
	List<Evento> findByEstadoIsNot(String estado);
}
