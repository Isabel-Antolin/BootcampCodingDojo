package com.isabel.lista_estudiantes.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="contacts")
public class Contact {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "El Campo Direccion no puede estar vacío")
	private String direccion;
	
	@NotBlank(message = "El Campo Ciudad no puede estar vacío")
	private String ciudad;
	@NotBlank(message = "El Campo Estado no puede estar vacío")
	private String estado;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_id")
	private Student student;	
    
    public Contact() {}

	public Contact(@NotBlank(message = "El Campo Direccion no puede estar vacío") String direccion,
			@NotBlank(message = "El Campo Ciudad no puede estar vacío") String ciudad,
			@NotBlank(message = "El Campo Estado no puede estar vacío") String estado, Date createdAt, Date updatedAt,
			Student student) {
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.estado = estado;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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
