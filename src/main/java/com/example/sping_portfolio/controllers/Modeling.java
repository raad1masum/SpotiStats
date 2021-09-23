package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class Modeling {
    @GetMapping("/modeling")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String modeling() {
        return "modeling"; // returns HTML VIEW (greeting)
    }
}
