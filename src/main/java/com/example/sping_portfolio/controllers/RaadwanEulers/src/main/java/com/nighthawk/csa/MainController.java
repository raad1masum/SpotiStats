package com.example.sping_portfolio.controllers.RaadwanEulers.src.main.java.com.nighthawk.csa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class MainController {

    @GetMapping("/greet")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
        model.addAttribute("name", name);   // MODEL is passed to html
        return "starters/greet";                     // returns HTML VIEW (greeting)
    }


    @GetMapping("/binary")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String binary() {
        return "starters/binary";
    }

    @GetMapping("/snake")   // GET request
    public String snake() {
        return "starters/snake";
    }

    @GetMapping("/course/repos")
    public String courseRepos(Model model) {
        return "course/repos";
    }

    @GetMapping("/course/deploy")
    public String courseDeploy(Model model) {
        return "course/deploy";
    }

    @GetMapping("/course/prep")
    public String coursePrep(Model model) {
        model.addAttribute("url", "https://padlet.com/jmortensen7/csatime");
        return "course/timelines";
    }

    @GetMapping("/course/tri1")
    public String courseTri1(Model model) {
        model.addAttribute("url", "https://padlet.com/jmortensen7/csa2022tri1");
        return "course/timelines";
    }

}