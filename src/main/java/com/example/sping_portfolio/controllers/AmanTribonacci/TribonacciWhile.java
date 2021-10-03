package com.example.sping_portfolio.controllers.AmanTribonacci;

public class TribonacciWhile extends TribonacciAbstract {

    public TribonacciWhile(String nth) {
        super(nth);
        this.method = "while";
    }

    private static long whileTribNth(int n) {
        if (n == 0) {
            return 0;
        } else {
            int i = 0;
            long a = 0;
            long b = 0;
            long c = 1;
            while (i < n) {
                long placeholder = 0;
                placeholder = a + b + c;
                a = b;
                b = c;
                c = placeholder;
                i++;
            }
            return a;
        }


    }

    public void compute(){
        long startTime = System.nanoTime();
        this.value = Long.toString(whileTribNth(nth));
        System.out.println("The answer is " + this.value);
        long endTime = System.nanoTime();
        this.time = Double.toString((endTime-startTime)/1e6);
    }

}