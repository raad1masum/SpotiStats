package com.example.sping_portfolio.controllers.PrimeRishi;

import java.util.ArrayList;

public class PrimeFor extends PrimeAbstract {

    public PrimeFor(String inp){
        super(inp);
        this.method = "for";
    }

    public void compute() {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);

        for(int i=3; primes.size()<this.nth; i++){
            boolean isPrime = true;
            for(int j=2; j<=Math.sqrt(Math.ceil((double)i)); j++){
                if(i%j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)primes.add(i);
        }

        System.out.println("THE ANSWER IS " + primes.get(primes.size()-1));
        this.value = primes.get(primes.size()-1).toString();

        // send to html: applychanges(html tag id)
    }
}
