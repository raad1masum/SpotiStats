package com.example.sping_portfolio.controllers.AmanTribonacci;

public class TribonacciRecursion extends TribonacciAbstract {
    public TribonacciRecursion(String nth){
        super(nth);
        this.method = "recursion";
    }

    private static long tribonacciNth(int n) {
        if (n == 0 || n == 1) {
            return 0L;
        } else if (n == 2) {
            return 1L;
        } else {
            return tribonacciNth(n - 1) + tribonacciNth(n - 2) + tribonacciNth(n - 3);
        }
    }

    public void compute(){
        long startTime = System.nanoTime();
        this.value = Long.toString(tribonacciNth(nth));
        System.out.println("The answer is " + this.value);
        long endTime = System.nanoTime();
        this.time = Double.toString((endTime-startTime)/1e6);
    }
}
