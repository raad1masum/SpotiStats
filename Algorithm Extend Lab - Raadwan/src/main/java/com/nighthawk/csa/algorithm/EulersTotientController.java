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

    public List<_EulersTotient> eulersInit(int nth) {
        //Eulers objects created with different initializers
        List<_EulersTotient> eulersList = new ArrayList<>();
        eulersList.add(new EulersTotientFor(nth));
        eulersList.add(new EulersTotientWhile(nth));
        eulersList.add(new EulersTotientRecurse(nth));
        eulersList.add(new EulersTotientStream(nth));

        return eulersList;
    }

    // GET request,, parameters are passed within the URI
    @GetMapping("/eulers")
    public String eulers(@RequestParam(name="eulerseq", required=false,  defaultValue="2") String eulerseq, Model model) {
        //nth is eulers request
        int nth = Integer.parseInt(eulerseq);

        System.out.println("Sequence: " + eulerseq);
        eulersInit(nth).get(0).print();
        eulersInit(nth).get(1).print();
        eulersInit(nth).get(2).print();
        eulersInit(nth).get(3).print();

        model.addAttribute("eulersList", eulersInit(nth));

        return "algorithm/eulers"; //HTML render eulers results

    }

    // Console UI is run out of the same Controller
    public static void main(String[] args) {
        int nth = 20; //!!!make dynamic using consoleUI inputInt!!! 92 is max for long

        List<_EulersTotient> eulersList = new EulersTotientController().eulersInit(nth);
        for (_EulersTotient eulers : eulersList)
            eulers.print();  //Console output eulers results
    }
}