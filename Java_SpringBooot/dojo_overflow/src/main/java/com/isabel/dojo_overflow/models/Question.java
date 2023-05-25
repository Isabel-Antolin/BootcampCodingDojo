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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 65535, columnDefinition = "text")
	@NotBlank(message = "Por favor ingrese la pregunta")
	private String text_question;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

//___________________________________________________________________	
//	union con la tabla answers 1:n
	@OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
	private List<Answer> answers;

//	union con la tabla tag n:n se creara la table intermedia sola 
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tags_questions", joinColumns = @JoinColumn(name = "question_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tag> tags;
	// _________________________________________________________________

	public Question() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText_question() {
		return text_question;
	}

	public void setText_question(String text_question) {
		this.text_question = text_question;
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

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	// __________________________________________________________________
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
