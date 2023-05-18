package com.isabel.lista_estudiantes.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="students")
public class Student {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "El Nombre no puede estar vacío")
	private String nombre;
	
	@NotBlank(message = "El Apellido no puede estar vacío")
	private String apellido;
	
	@NotNull(message = "El campo Edad no puede estar vacío")
    @Min(value = 1, message = "El campo Edad debe ser mayor que cero")
	private int edad;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @OneToOne(mappedBy="student", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Contact contacto;
    
    public Student() {}

	public Student(@NotBlank(message = "El Nombre no puede estar vacío") String nombre,
			@NotBlank(message = "El Apellido no puede estar vacío") String apellido,
			@NotNull(message = "El campo Edad no puede estar vacío") @Min(value = 1, message = "El campo Edad debe ser mayor que cero") int edad,
			Date createdAt, Date updatedAt, Contact contacto) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
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

	public Contact getContacto() {
		return contacto;
	}

	public void setContacto(Contact contacto) {
		this.contacto = contacto;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
}
