package com.isabel.eventos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isabel.eventos.models.User;

@Repository
public interface UserRespository extends CrudRepository<User, Long>{
	 User findByEmail(String email);
}
