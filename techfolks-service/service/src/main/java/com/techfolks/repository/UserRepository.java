package com.techfolks.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.techfolks.model.dto.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "select * from user where email= :email", nativeQuery = true)
    public User findUserByEmail(String email);
//	public User findUserByEmail(String email){
//        User user = new User(email,"123456");
//        user.setFirstName("FirstName");
//        user.setLastName("LastName");
//        return user;
//    }

    @Query(value = "SELECT * FROM user WHERE email = :email", nativeQuery = true)
    Optional<User> findUserByEmailId(@Param("email") String email);
}
