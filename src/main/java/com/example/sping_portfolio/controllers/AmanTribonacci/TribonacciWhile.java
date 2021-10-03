package com.example.sping_portfolio.controllers.AmanTribonacci;

public class TribonacciWhile extends TribonacciAbstract {

    public TribonacciWhile(String nth) {
        super(nth);
        this.method = "for";
    }

    private static int whileTribNth(int n) {
        if (n == 0) {
            return 0;
        } else {
            int i = 0;
            int a = 0;
            int b = 0;
            int c = 1;
            while (i < n) {
                int placeholder = 0;
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
        long startTime = System.currentTimeMillis();
        this.value = Integer.toString(whileTribNth(nth));
        System.out.println("The answer is " + this.value);
        long endTime = System.currentTimeMillis();
        this.time = Long.toString(endTime-startTime);
    }

}