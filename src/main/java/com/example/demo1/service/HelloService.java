package com.example.demo1.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String greeting() {
        System.out.println("hello");
        return "Greeting From Service!!";
    }
}
