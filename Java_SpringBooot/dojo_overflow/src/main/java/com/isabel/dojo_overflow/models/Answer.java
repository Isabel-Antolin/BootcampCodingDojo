package com.isabel.dojo_overflow.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "answers")
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 65535, columnDefinition = "text")
	@NotBlank(message = "Por favor escriba la respuesta")
	private String text_answer;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
//__________________________________________________________________
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id")
	private Question question;
//	_________________________________________________________________

	public Answer(){}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getText_answer() {
		return text_answer;
	}


	public void setText_answer(String text_answer) {
		this.text_answer = text_answer;
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


	public Question getQuestion() {
		return question;
	}


	public void setQuestion(Question question) {
		this.question = question;
	}
//	_________________________________________________________________


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
