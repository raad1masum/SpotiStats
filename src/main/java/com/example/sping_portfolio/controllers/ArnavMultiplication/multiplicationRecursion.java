package com.example.sping_portfolio.controllers.ArnavMultiplication;

public class multiplicationRecursion extends multiplicationClass{
    public multiplicationRecursion(String nth) {
        super(nth);
        this.method = "recursion";

    }

    public int[] recursion(int[] values){
        int newArr[] = new int[values.length];
        int x = 0;
        if (x < values.length){
            newArr[x] = values[x] * 10;
            x++;
            recursion(values);
        }
        return newArr;
    }

    public void compute(){
        String inp = Integer.toString(this.nth);

        long startTime = System.currentTimeMillis();
        int values[] = new int[Integer.parseInt(inp)];
        values[0] = 5;

//       values = recursion(values);

        for (int i = 1; i < values.length; i++){
            values[i] = 10 * values[i-1];
        }

        long endTime = System.currentTimeMillis();
        this.time = Long.toString(endTime-startTime);
        this.value = Integer.toString(values[values.length-1]);

    }
}
