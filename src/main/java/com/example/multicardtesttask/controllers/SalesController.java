package com.example.multicardtesttask.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SalesController {

    @GetMapping("/sales")
    public String hello() {

        return "sales";
    }
}
