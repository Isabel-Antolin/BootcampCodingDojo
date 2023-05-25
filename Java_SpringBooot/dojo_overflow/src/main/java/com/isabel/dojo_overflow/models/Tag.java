package com.isabel.dojo_overflow.models;

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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tags")
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 65535, columnDefinition = "text")
	@NotBlank(message = "Por favor escriba tag")
	@Size(max = 255, message = "Limite maximo es de 255 caracteres")
//	@Pattern(regexp = "^([^,]+(,\\s*)?){1,3}$", message = "Ingrese hasta tres palabras o frases separadas por comas")
	private String subject;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

//	_____________________________________________________
//	union con la tabla question n:n se creara la table intermedia sola 
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tags_questions", joinColumns = @JoinColumn(name = "tag_id"), inverseJoinColumns = @JoinColumn(name = "question_id"))
	private List<Question> questions;
//	_____________________________________________________________

	public Tag() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	// _______________________________________________________________
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

//	@PostPersist
//	protected void onUpdate() {
//		this.updatedAt = new Date();
//	}
}
