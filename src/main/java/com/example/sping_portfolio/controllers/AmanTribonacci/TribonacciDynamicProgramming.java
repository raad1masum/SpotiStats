package com.example.sping_portfolio.controllers.AmanTribonacci;

public class TribonacciDynamicProgramming extends TribonacciAbstract {
    public TribonacciDynamicProgramming(String nth){
        super(nth);
        this.method = "dynamic programming";
    }

    private static long dynamicTribonacciNth(int n) {
        if (n == 0 || n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            long tribs[] = new long[n + 2];
            tribs[0] = 0;
            tribs[1] = 0;
            tribs[2] = 1;
            for (int i = 3; i<n+1; i++) {
                tribs[i] = tribs[i - 1] + tribs[i - 2] + tribs[i - 3];
            }
            return tribs[n];
        }

    }

    public void compute(){
        long startTime = System.nanoTime();
        this.value = Long.toString(dynamicTribonacciNth(nth));
        System.out.println("The answer is " + this.value);
        long endTime = System.nanoTime();
        this.time = Double.toString((endTime-startTime)/1e6);
    }
}
