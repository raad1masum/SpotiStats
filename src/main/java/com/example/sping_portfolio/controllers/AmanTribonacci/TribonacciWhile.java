package com.example.sping_portfolio.controllers.AmanTribonacci;

import java.util.ArrayList;

public class TribonacciWhile extends TribonacciAbstract {

    public TribonacciWhile(String nth) {
        super(nth);
        this.method = "while";
    }

    public void compute() {
        long startTime = System.currentTimeMillis();
        int i = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        while (i < this.nth) {
            d = a + b + c;
            c = d;
            b = c;
            a = b;
            i += 1;
        }
        System.out.println("The answer is " + a);
        this.value = Integer.toString(a);
        long endTime = System.currentTimeMillis();
        this.time = Long.toString(endTime-startTime);

    }
}