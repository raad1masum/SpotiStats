package com.example.sping_portfolio.controllers.AmanTribonacci;

import java.util.ArrayList;

public class TribonacciRecursion extends TribonacciAbstract {

    public TribonacciRecursion(String nth) {
        super(nth);
        this.method = "recursion";
    }


    this.value = Integer.toString(a);
    long endTime = System.currentTimeMillis();
    this.time = Long.toString(endTime-startTime)

    public int compute(int k) {
        long startTime = System.currentTimeMillis();
        k = nth
        if (k == 0 || k == 1) {
            return 0
        } else if (k == 2) {
            return 1
        } else {
            return compute(k - 1) + compute(k - 2);
        }
        long endTime = System.currentTimeMillis();
        this.time = Long.toString(endTime - startTime);
    }
}