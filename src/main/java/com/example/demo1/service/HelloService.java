package com.example.demo1.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String greeting() {
        return "Greeting From Service!!";
    }
}
