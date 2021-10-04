package com.example.sping_portfolio.controllers.ArnavMultiplication;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        ArrayList<Integer>values2 = new ArrayList<>();
        values[0] = 5;
        values2.add(5);

//        values2.stream()
//                .limit(Integer.parseInt(inp))
//                .forEach(i -> {
//                    values2.add(values2.get(i-1) * 10);
//                });

        for (int i = 1; i < values.length; i++){
            values[i] = 10 * values[i-1];
        }

        long endTime = System.currentTimeMillis();
        this.time = Long.toString(endTime-startTime);
        this.value = Integer.toString(values[values.length-1]);

    }
}
