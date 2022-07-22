package com.example.multicardtesttask.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello");

        return "hello";
    }
}
