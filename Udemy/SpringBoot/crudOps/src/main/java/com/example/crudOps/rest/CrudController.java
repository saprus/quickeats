package com.example.crudOps.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class CrudController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello world";
    }
}
