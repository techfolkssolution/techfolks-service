package com.techfolks.controller;

import com.techfolks.model.response.UserResponse;
import com.techfolks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class HelloRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/email")
    public UserResponse getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmailId(email);
    }
}
