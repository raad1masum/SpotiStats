package com.example.sping_portfolio.controllers.AsciiLab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AsciiController {
    @GetMapping("/asciiLab")

    public String asciiLab(@RequestParam(required=false, defaultValue="10") String rowFactor, @RequestParam(required=false,
    defaultValue="5") String colFactor, Model model) {

        char AsciiArray[][] = ASCIIArt.create(Integer.parseInt(rowFactor), Integer.parseInt(colFactor));
        model.addAttribute("imageArr", AsciiArray);
        
        return "asciiLab";
    }
}

