package com.techfolks.globalException;

public class UserResponseException extends RuntimeException {

    public UserResponseException(String message) {
        super(message);
    }
}
