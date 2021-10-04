package com.example.sping_portfolio.controllers.ArnavMultiplication;

public class multiplicationWhile extends multiplicationClass{

    public multiplicationWhile(String inp){
        super(inp);
        this.method = "while";
    }

    public void compute(){
        String inp = Integer.toString(this.nth);
        long startTime = System.currentTimeMillis();
        int values[] = new int[Integer.parseInt(inp)];
        values[0] = 5;
        int x = 1;
        while (x < Integer.parseInt(inp)){
            values[x] = values[x-1] * 10;
            x++;
        }
        long endTime = System.currentTimeMillis();
        this.time = Long.toString(endTime-startTime);
        this.value = Integer.toString(values[values.length-1]);

    }
}
