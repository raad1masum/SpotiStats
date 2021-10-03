package com.example.sping_portfolio.controllers.AmanTribonacci;

public class TribonacciFor extends TribonacciAbstract {

    public TribonacciFor(String nth) {
        super(nth);
        this.method = "for";
    }

    private static long forTribNth(int n) {
        if (n == 0) {
            return 0;
        } else {
            long a = 0;
            long b = 0;
            long c = 1;
            for (int i = 0; i < n; i++) {
                long placeholder = 0;
                placeholder = a + b + c;
                a = b;
                b = c;
                c = placeholder;
            }
            return a;
        }


    }

    public void compute(){
        long startTime = System.nanoTime();
        this.value = Long.toString(forTribNth(nth));
        System.out.println("The answer is " + this.value);
        long endTime = System.nanoTime();
        this.time = Double.toString((endTime-startTime)/1e6);
    }
}