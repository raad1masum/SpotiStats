package com.example.sping_portfolio.controllers;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class LoopsMinilab {
    public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b, a%b);
    }
    @GetMapping("/loopsminilab")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String factorial(@RequestParam(required=false, defaultValue="World") String name, @RequestParam(required=false,
            defaultValue="0") String factorialInput, @RequestParam(required=false, defaultValue="5") String yellowstoneInput, Model model) {
        
        //factorial
        int factorialAnswer=1;
        int n= Integer.parseInt(factorialInput);
        for(int i=1; i<=n; i++)factorialAnswer*=i;
        System.out.println("The factorial of " + n + " is " + factorialAnswer);
        model.addAttribute("factorial", factorialAnswer);

        //yellowstone permutation
        String yellowstoneAnswer="";
        ArrayList<Integer> yellowstone = new ArrayList<Integer>();
        yellowstone.add(1);
        yellowstone.add(2);
        yellowstone.add(3);
        for (int i = 3; i<Math.min(Integer.parseInt(yellowstoneInput), 20); i++){
            for (int j = 4; j<100; j++) {
                if (!(yellowstone.contains(j))) {
                    if ((gcd(j, yellowstone.get(i-2)) > 1) && (gcd(j, yellowstone.get(i-1)) == 1)) {
                        yellowstone.add(j);
                        break;
                    }
                }
            }
        }
        for(int i=0; i<yellowstone.size(); i++)yellowstoneAnswer = yellowstoneAnswer + yellowstone.get(i) + " ";
        model.addAttribute("yellowstone", yellowstoneAnswer);

        return "loopsminilab";

    }
}