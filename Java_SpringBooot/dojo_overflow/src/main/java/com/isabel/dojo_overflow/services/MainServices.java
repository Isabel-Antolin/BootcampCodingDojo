package com.isabel.dojo_overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isabel.dojo_overflow.models.Question;
import com.isabel.dojo_overflow.models.Tag;
//import com.isabel.dojo_overflow.repositories.AnswerRepository;
import com.isabel.dojo_overflow.repositories.QuestionRepository;
import com.isabel.dojo_overflow.repositories.TagRepository;

@Service
public class MainServices {
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private TagRepository tagRepository;
	
//	@Autowired
//	private AnswerRepository answerRepository;
	
	
	//verificar si el tag esta en la base de datos
    public Tag existeTag(String subject) {
        return tagRepository.findBySubject(subject);
    }
    
    public Tag guardarTag(Tag tag) {
    	return tagRepository.save(tag);
    }
    
    public Question guardarQuestion(Question question) {
    	return questionRepository.save(question);
    }
    
    public List<Question>obtenerPreguntas(){
    	return questionRepository.findAll();
    }
    
    
}
