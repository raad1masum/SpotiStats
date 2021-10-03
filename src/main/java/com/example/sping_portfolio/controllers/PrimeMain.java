package com.example.sping_portfolio.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.sping_portfolio.controllers.PrimeRishi.PrimeFor;
import com.example.sping_portfolio.controllers.PrimeRishi.PrimeSieve;
import com.example.sping_portfolio.controllers.PrimeRishi.PrimeWhile;
import com.example.sping_portfolio.controllers.PrimeRishi.PrimeAbstract;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class PrimeMain {

    public List<PrimeAbstract> PrimeInit(String nth){
        List<PrimeAbstract> ret = new ArrayList<>();
        ret.add(new PrimeFor(nth));
        ret.add(new PrimeWhile(nth));
        ret.add(new PrimeSieve(nth));
        return ret;
    }

    @GetMapping("/primeMain")
    public String primeMain(@RequestParam(required=false,
    defaultValue="3") String nth, Model model) {

        List<PrimeAbstract> primesList = PrimeInit(nth);
        for(PrimeAbstract PL : primesList)PL.compute();

        model.addAttribute("primesList", primesList);

        return "PrimeRishi/primeMain";
    }
}

