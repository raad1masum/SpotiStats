package com.example.sping_portfolio.controllers.PrimeRishi;

import java.util.ArrayList;

import com.example.sping_portfolio.controllers.PrimeRishi.PrimeAbstract;

import org.springframework.ui.Model;


public class PrimeWhile extends PrimeAbstract {

    public PrimeWhile(String inp){
        super(inp);
        this.method = "while";
    }

    public void compute() {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);

        int i=3;
        while(primes.size()<this.nth){
            boolean isPrime = true;

            int j=2;
            while(j<=Math.sqrt(Math.ceil((double)i))){
                if(i%j == 0){
                    isPrime = false;
                    break;
                }
                j++;
            }
            if(isPrime)primes.add(i);
            i++;
        }

        System.out.println("THE ANSWER IS " + primes.get(primes.size()-1));
        this.value = primes.get(primes.size()-1).toString();
        // apply(, primes.get(primes.size()-1).toString());
    }
}
