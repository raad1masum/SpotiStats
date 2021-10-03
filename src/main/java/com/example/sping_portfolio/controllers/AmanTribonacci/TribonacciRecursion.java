package com.example.sping_portfolio.controllers.AmanTribonacci;

public class TribonacciRecursion extends TribonacciAbstract {
    public TribonacciRecursion(String nth){
        super(nth);
        this.method = "recursion";
    }

    private static int tribonacciNth(int n) {
        if (n == 0 || n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return tribonacciNth(n - 1) + tribonacciNth(n - 2) + tribonacciNth(n - 3);
        }
    }

    public void compute(){
        long startTime = System.currentTimeMillis();
        this.value = Integer.toString(tribonacciNth(nth));
        long endTime = System.currentTimeMillis();
        this.time = Long.toString(endTime-startTime);
    }
}
