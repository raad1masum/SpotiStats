package com.example.sping_portfolio.controllers.ArnavMultiplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class multiplicationStream extends multiplicationClass {
    public multiplicationStream(String nth) {
        super(nth);
        this.method = "stream";
    }

    public void compute(){
        String inp = Integer.toString(this.nth);
        long startTime = System.currentTimeMillis();
        int values[] = new int[Integer.parseInt(inp)];
        values[0] = 5;
//
//        List newList = Arrays.asList(values);
//
//        Arrays.stream(values).filter((v) -> v > 0).forEach(i -> values[i] *= 10);


        for (int i = 1; i < values.length; i++){
            values[i] = 10 * values[i-1];
        }

        long endTime = System.currentTimeMillis();
        this.time = Long.toString(endTime-startTime);
        this.value = Integer.toString(values[values.length-1]);

    }
}
