package com.isabel.eventos.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.isabel.eventos.models.User;
import com.isabel.eventos.repositories.UserRespository;

@Service
public class UserServices {
	@Autowired
	private UserRespository userRespository;
// _________________________registrar el usuario y hacer Hash a su password________________________________________
		public User registerUser(User user, BindingResult resultado) {
			User userRegistrado = userRespository.findByEmail(user.getEmail());

			if (userRegistrado != null) {
				resultado.rejectValue("email", "Matches", "Correo electrónico ya existe");
			} else if (!user.getPassword().equals(user.getPasswordConfirmation())) {
				resultado.rejectValue("password", "Matches", "La confirmación de contraseña debe coincidir");
			}

			if (resultado.hasErrors()) {
//				si tiene errores enviara los errores al controlador
				return null;
			} else {
				String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
				user.setPassword(hashed);
				return userRespository.save(user);
			}
		}

//________________________________Logear Usuario_______________________________________________________	
		public boolean authenticateUser(String email, String password, BindingResult resultado) {
//			 primero encontrar el usuario por su email
			User user = userRespository.findByEmail(email);
			// si no lo podemos encontrar por su email, retornamos false
			if (user == null) {
				resultado.rejectValue("email", "Matches", "Email no válido");
				return false;
			} else {
				// si el password coincide devolvemos true, sino, devolvemos false
				if (BCrypt.checkpw(password, user.getPassword())) {
					return true;
				} else {
					resultado.rejectValue("password", "Matches", "Password no es válido");
					return false;
				}
			}
		}
		
//		encontrar usuario por su email
		// encontrar un usuario por su email
		public User findByEmail(String email) {
			return userRespository.findByEmail(email);
		}
		
		// encontrar un usuario por su id
		public User findUserById(Long id) {
			   return userRespository.findById(id).orElse(null);
			}
}
