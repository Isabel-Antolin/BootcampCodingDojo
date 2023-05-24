package com.isabel.authentication.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginUser {
	@Email(message = "El correo ingresado no es valido")
	@NotBlank(message = "Por favor, ingresa el correo")
	private String email;

	@NotBlank(message = "Por favor, ingresa el password")
	@Size(min = 8, max = 20, message = "Password debe contener entre 8 a 20 caracteres ")
//	@Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
//    message = "La contraseña debe contener al menos una mayúscula, un número y un carácter especial")
	private String password;

	public LoginUser() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
