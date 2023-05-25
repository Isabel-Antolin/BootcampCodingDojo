package com.isabel.dojo_overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isabel.dojo_overflow.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
	List<Question> findAll();
}
