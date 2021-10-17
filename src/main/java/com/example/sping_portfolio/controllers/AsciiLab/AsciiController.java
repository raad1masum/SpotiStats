package com.example.sping_portfolio.controllers.AsciiLab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class AsciiController {
    @GetMapping("/asciiLab")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String asciiLab(@RequestParam(required=false, defaultValue="10") String rowFactor, @RequestParam(required=false,
    defaultValue="5") String colFactor, Model model) {

        char AsciiArray[][] = ASCIIArt.create(Integer.parseInt(rowFactor), Integer.parseInt(colFactor));
        model.addAttribute("imageArr", AsciiArray);
        
        return "asciiLab"; // returns HTML VIEW (greeting)
    }
}

