package com.example.sping_portfolio.controllers.PrimeRishi;

import java.util.ArrayList;

public class PrimeSieve extends PrimeAbstract {
    public PrimeSieve(String inp){
        super(inp);
        this.method = "sieve";
        SieveOfEratosthenes();
    } 
     
    static int MAX_SIZE = 1000005;
    ArrayList<Integer> primes = new ArrayList<Integer>();
     
    private void SieveOfEratosthenes(){
        boolean [] IsPrime = new boolean[MAX_SIZE];
        for(int i=0; i<MAX_SIZE; i++)IsPrime[i] = true;
         
        for(int p=2; p*p<MAX_SIZE; p++){
            if(IsPrime[p] == true){
                for(int i=p*p; i<MAX_SIZE; i+=p)IsPrime[i] = false;
            }
        }
     
        for(int p=2; p<MAX_SIZE; p++)
        if (IsPrime[p] == true)primes.add(p);

    }

    public void compute(){
        this.value = primes.get(this.nth-1).toString();
    }
}
