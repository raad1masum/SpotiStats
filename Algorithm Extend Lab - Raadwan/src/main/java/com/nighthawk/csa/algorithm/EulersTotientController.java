package com.nighthawk.csa.algorithm;

import com.nighthawk.csa.algorithm.eulersTotientModel.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class EulersTotientController {

    public List<_EulersTotient> fibInit(int nth) {
        //Fibonacci objects created with different initializers
        List<_EulersTotient> fibList = new ArrayList<>();
        fibList.add(new EulersTotientFor(nth));
        fibList.add(new EulersTotientWhile(nth));
        fibList.add(new EulersTotientRecurse(nth));
        fibList.add(new EulersTotientStream(nth));

        return fibList;
    }

    // GET request,, parameters are passed within the URI
    @GetMapping("/eulers")
    public String fib(@RequestParam(name="fibseq", required=false,  defaultValue="2") String fibseq, Model model) {
        //nth is fibonacci request
        int nth = Integer.parseInt(fibseq);

        //MODEL attributes are passed back html
        model.addAttribute("fibList", fibInit(nth));

        return "algorithm/eulers"; //HTML render fibonacci results

    }

    // Console UI is run out of the same Controller
    public static void main(String[] args) {
        int nth = 20; //!!!make dynamic using consoleUI inputInt!!! 92 is max for long

        List<_EulersTotient> fibList = new EulersTotientController().fibInit(nth);
        for (_EulersTotient fibonacci : fibList)
            fibonacci.print();  //Console output fibonacci results
    }
}