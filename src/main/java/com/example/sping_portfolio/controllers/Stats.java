package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Stats {
    @GetMapping("/stats")
    public String greeting(@RequestParam(required=false, defaultValue="") String link, Model model) {
        model.addAttribute("link", link);
        return "stats";
    }
}
