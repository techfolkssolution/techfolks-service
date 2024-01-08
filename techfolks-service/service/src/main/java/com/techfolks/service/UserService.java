package com.techfolks.service;

import com.techfolks.globalException.UserResponseException;
import com.techfolks.model.dto.User;
import com.techfolks.model.response.UserResponse;
import com.techfolks.repository.UserRepository;
import com.techfolks.utility.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Convertor convertor;


    public UserResponse getUserByEmailId(String email) {
        Optional<User> optionalUser = userRepository.findUserByEmailId(email);
        if (optionalUser.isPresent()) {
            User savedUser = optionalUser.get();
            savedUser.setPassword(null);
            return convertor.entityToResponse(savedUser);
        }
        throw new UserResponseException("User Not Found For EmailId : " + email);
    }
}

