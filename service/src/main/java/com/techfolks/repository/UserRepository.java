package com.techfolks.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techfolks.model.dto.User;

@Repository
public interface UserRepository  extends CrudRepository<User, Long> {
	
	@Query(value="select * from user where email= :email", nativeQuery = true)
	public User findUserByEmail(String email);
}
