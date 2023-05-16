package com.isabel.lookify.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "song")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "El titulo no puede estar vacío")
	@Size(min = 1, max = 250, message = "Minimo de caracteres es de 2 y maximo 20")
	private String titulo;

	@NotBlank(message = "El artista no puede estar vacío")
	@Size(min = 1, max = 250, message = "Minimo de caracteres es de 5 y maximo 200")
	private String artista;

	@NotNull(message = "La clasificacion  no puede estar vacía")
	@Min(value = 1, message = "El valor mínimo permitido es 1")
	@Max(value = 10, message = "El valor maximo permitido es 10")
	private String clasificacion;

	// Esto no permitirá que el campo createdAt sea modificado después de su
	// creación.
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Song() {
	}

	public Song(Long id, String titulo, String artista, String clasificacion) {
		this.id = id;
		this.titulo = titulo;
		this.artista = artista;
		this.clasificacion = clasificacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	
}
