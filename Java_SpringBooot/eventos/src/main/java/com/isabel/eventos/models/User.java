package com.isabel.eventos.models;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Por favor ingresa un nombre de usuario")
	@Size(min = 3, max = 30, message = "Nombre de usuario debe contener entre 3 y 30 caracteres")
	private String nombre;
	
	@NotBlank(message = "Por favor ingresar Apellido")
	@Size(min = 3, max = 30, message = "Apellido de usuario debe contener entre 3 y 30 caracteres")
	private String apellido;

	@Email(message = "El correo ingresado no es valido")
	@NotBlank(message = "Por favor, no olivdes ingresar un correo electronico")
	private String email;
	
	@NotBlank(message = "Por favor ingresa la ciudad")
	private String ciudad;
	
	@NotBlank(message = "Por favor ingresa un nombre de usuario")
	private String estado;

	@NotBlank(message = "Por favor, ingresa el password")
	@Size(min = 4, max = 64, message = "Password debe contener entre 4 a 20 caracteres ")
//	@Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
//    message = "La contraseña debe contener al menos una mayúscula, un número y un carácter especial")
	private String password;

	@Transient
	@NotBlank(message = "Confirma la contraseña por favor")
	@Size(min = 4, max = 64, message = "Password debe contener entre 4 a 20 caracteres ")
	private String passwordConfirmation;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	public User() {}
//	____________________________________________________________________	
//	relacion 1 a muchos con evento
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY)
	private List<Evento>eventos;
	
//	relacion 1 a muchos con mensajes
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY)
	private List<Mensaje>mensajes;	
	
//	relacion con lista asistentecia que es la relacion de muchos a muchos con evento
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "asistencia", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "evento_id")
    )
	 private List<Evento> eventosAsistidos;
	
//	____________________________________________________________________
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public List<Evento> getEventosAsistidos() {
		return eventosAsistidos;
	}

	public void setEventosAsistidos(List<Evento> eventosAsistidos) {
		this.eventosAsistidos = eventosAsistidos;
	}
	
	
	
}
