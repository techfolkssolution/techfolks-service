package com.techfolks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest")
public class HelloRestController {
    @ResponseBody
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String hello(){
        return "hello world";
    }
    
}
