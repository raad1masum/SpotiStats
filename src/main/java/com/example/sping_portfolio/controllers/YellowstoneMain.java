package com.example.sping_portfolio.controllers;

import com.example.sping_portfolio.controllers.YellowstoneFiles.YellowstoneFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class YellowstoneMain {
    @GetMapping("/yellowstoneMain")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String yellowstoneMain() {
        YellowstoneFor YF = new YellowstoneFor();
        YF.compute();
        return "yellowstoneMain"; // returns HTML VIEW (greeting)
    }
}

