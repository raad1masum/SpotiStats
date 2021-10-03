package com.example.sping_portfolio.controllers.AmanTribonacci;

import java.util.ArrayList;

public class TribonacciFor extends TribonacciAbstract {

    public TribonacciFor(String nth) {
        super(nth);
        this.method = "for";
    }

    public void compute() {
        long startTime = System.currentTimeMillis();
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for (int i = 0; i < this.nth; i++) {
            d = a + b + c;
            c = d;
            b = c;
            a = b;
        }
        System.out.println("The answer is " + a);
        this.value = Integer.toString(a);
        long endTime = System.currentTimeMillis();
        this.time = Long.toString(endTime-startTime);
    }
}