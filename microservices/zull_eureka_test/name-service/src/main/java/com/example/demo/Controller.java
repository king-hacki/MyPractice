package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/name/{message}")
    public String displayMessage (@PathVariable String message) {
        return message;
    }

    @GetMapping("/")
    public String defaultMessage () {
        return "default";
    }
}
