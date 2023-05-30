package com.isabel.eventos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isabel.eventos.models.Mensaje;

@Repository
public interface MensajeRespository extends CrudRepository<Mensaje, Long>{

}
