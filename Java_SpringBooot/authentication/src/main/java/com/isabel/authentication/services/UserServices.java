package com.isabel.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.isabel.authentication.models.User;
import com.isabel.authentication.reposities.UserRepository;

@Service
public class UserServices {
	@Autowired
	private UserRepository userRepository;

	// registrar el usuario y hacer Hash a su password
	public User registerUser(User user, BindingResult resultado) {
		User userRegistrado = userRepository.findByEmail(user.getEmail());

		if (userRegistrado != null) {
			resultado.rejectValue("email", "Matches", "Correo electrónico ya existe");
		} else if (!user.getPassword().equals(user.getPasswordConfirmation())) {
			resultado.rejectValue("password", "Matches", "La confirmación de contraseña debe coincidir");
		}

		if (resultado.hasErrors()) {
			return null;
		} else {
			String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			user.setPassword(hashed);
			return userRepository.save(user);
		}
	}

	// encontrar un usuario por su email
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	// encontrar un usuario por su id
	public User findUserById(Long id) {
		Optional<User> u = userRepository.findById(id);

		if (u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}

	// autenticar usuario (LOGIN)

	public boolean authenticateUser(String email, String password, BindingResult resultado) {
		// primero encontrar el usuario por su email
		User user = userRepository.findByEmail(email);
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

}
