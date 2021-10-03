package com.example.sping_portfolio.controllers.PrimeRishi;

public class PrimeRecursion extends PrimeAbstract {
    public PrimeRecursion(String nth){
        super(nth);
        this.method = "recursion";
    }

    private static boolean isPrime(int n, int i){
        if(n<=2)return (n==2) ? true : false;
        if(n%i==0)return false;
        if(i*i>n)return true;

        return isPrime(n, i+1);
    }

    public void compute(){
        long startTime = System.currentTimeMillis();
        int count=0, current=1;
        while(count < nth){
            current++;
            if(isPrime(current, 2))count++;
        }         
        this.value = Integer.toString(current);
        long endTime = System.currentTimeMillis();
        this.time = Long.toString(endTime-startTime);
    }
}
