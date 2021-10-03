package com.example.sping_portfolio.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.sping_portfolio.controllers.AmanTribonacci.*;
import com.example.sping_portfolio.controllers.PrimeRishi.PrimeFor;
import com.example.sping_portfolio.controllers.PrimeRishi.PrimeRecursion;
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
public class TribonacciMain {

    public List<TribonacciAbstract> TribonacciInit(String nth){
        List<TribonacciAbstract> out = new ArrayList<>();
        out.add(new TribonacciWhile(nth));
        out.add(new TribonacciFor(nth));
        out.add(new TribonacciRecursion(nth));
        out.add(new TribonacciDynamicProgramming(nth));
        return out;
    }

    @GetMapping("/tribonaccimain")
    public String tribonacciMain(@RequestParam(required=false,
            defaultValue="20") String nth, Model model) {

        List<TribonacciAbstract> TribonacciList = TribonacciInit(nth);
        for(TribonacciAbstract PL : TribonacciList)PL.compute();

        model.addAttribute("tribonaccilist", TribonacciList);

        return "AmanTribonacci/TribonacciMain";
    }
}

