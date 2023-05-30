package com.isabel.eventos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.isabel.eventos.models.Mensaje;
import com.isabel.eventos.repositories.MensajeRespository;

@Service
public class MensajeServices {
 @Autowired
 private MensajeRespository mensajeRespository;
 
	public Mensaje guardarMensaje(Mensaje mensaje) {
		return mensajeRespository.save(mensaje);
	}
}
