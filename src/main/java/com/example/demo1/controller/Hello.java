package com.example.demo1.controller;

import com.example.demo1.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @Autowired
    private HelloService service;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World! ";
    }

    @GetMapping("/greeting")
    public String greeting(){
        return service.greeting();
    }

}
