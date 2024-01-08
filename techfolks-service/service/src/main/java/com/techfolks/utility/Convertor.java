package com.techfolks.utility;

import com.techfolks.model.dto.User;
import com.techfolks.model.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class Convertor {

    public UserResponse entityToResponse(User userEntity) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userEntity.getId());
        userResponse.setEmail(userEntity.getEmail());
        userResponse.setFirstName(userEntity.getFirstName());
        userResponse.setLastName(userEntity.getLastName());
        return userResponse;
    }
}
