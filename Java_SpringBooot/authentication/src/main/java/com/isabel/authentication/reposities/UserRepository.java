package com.isabel.authentication.reposities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isabel.authentication.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	 User findByEmail(String email);
}
