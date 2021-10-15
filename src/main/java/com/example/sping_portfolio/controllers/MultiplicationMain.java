package com.example.sping_portfolio.controllers;

import com.example.sping_portfolio.controllers.ArnavMultiplication.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MultiplicationMain {
    public List<multiplicationClass> MultiplicationInit(String nth){
       List<multiplicationClass> mc = new ArrayList<>();
        mc.add(new multiplicationFor(nth));
        mc.add(new multiplicationWhile(nth));
        mc.add(new multiplicationRecursion(nth));
        mc.add(new multiplicationStream(nth));
        return mc;
    }

    @GetMapping("/multiplicationMain")
    public String multiplicationMain(@RequestParam(required = false, defaultValue = "20") String nth, Model model){
        List<multiplicationClass> list = MultiplicationInit(nth);
        for (multiplicationClass mC : list) mC.compute();
        model.addAttribute("list", list);

        return "ArnavMultiplication/multiplicationMain";
    }

}
