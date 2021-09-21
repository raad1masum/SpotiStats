package com.example.sping_portfolio.controllers;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Palindrome {
    static boolean isPalindrome(String str)
    {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    @GetMapping("/palindrome")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String greeting(@RequestParam(required=false, defaultValue=" ") String word, Model model) {
        if (word.equals(" "))
            model.addAttribute("check", " "); // MODEL is passed to html
        else if (isPalindrome(word))
            model.addAttribute("check", "Word is a palindrome!"); // MODEL is passed to html
        else
            model.addAttribute("check", "Word is not a palindrome!"); // MODEL is passed to html


        return "palindrome"; // returns HTML VIEW (greeting)
    }

}