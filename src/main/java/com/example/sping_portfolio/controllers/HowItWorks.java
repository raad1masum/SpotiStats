package com.example.sping_portfolio.controllers;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class HowItWorks {
    @GetMapping("/howitworks")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String greeting(@RequestParam(required=false, defaultValue="World") String name, @RequestParam(required=false,
            defaultValue="1") String number, Model model) {
        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
        double outNumber = Double.parseDouble(number);
        System.out.println("number 1: " + outNumber + "name: " + name);
        outNumber = Math.pow(outNumber, 2);
        System.out.println("number 2: " + outNumber);
        model.addAttribute("name", name); // MODEL is passed to html
        model.addAttribute("number", outNumber); // MODEL is passed to html
        return "howitworks"; // returns HTML VIEW (greeting)
    }
}