package com.example.sping_portfolio.controllers.ArnavMultiplication;

// import java.util.ArrayList;

public class multiplicationFor extends multiplicationClass{
    public multiplicationFor(String inp){
        super(inp);
        this.method = "for";
    }

    public void compute() {
        String inp = Integer.toString(this.nth);
        long startTime = System.currentTimeMillis();
        int values[] = new int[Integer.parseInt(inp)];
        values[0] = 5;
        for (int i = 1; i < values.length; i++){
            values[i] = 10 * values[i-1];
        }
        long endTime = System.currentTimeMillis();
        this.time = Long.toString(endTime-startTime);
        this.value = Integer.toString(values[values.length-1]);
    }
}
