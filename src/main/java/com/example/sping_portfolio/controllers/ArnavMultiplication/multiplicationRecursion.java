package com.example.sping_portfolio.controllers.ArnavMultiplication;

public class multiplicationRecursion extends multiplicationClass{
    public multiplicationRecursion(String nth) {
        super(nth);
        this.method = "recursion";

    }

    public void recursion(int cur, int iter){
        System.out.println("YOYOYO" + cur + " " + iter);
        if(iter==1)this.value=Integer.toString(cur);
        else recursion(cur*10, iter-1);
    }

    public void compute(){
        String inp = Integer.toString(this.nth);

        long startTime = System.currentTimeMillis();
        int values[] = new int[Integer.parseInt(inp)];
        values[0] = 5;

//       values = recursion(values);
            recursion(5, this.nth);
//        for (int i = 1; i < values.length; i++){
//            values[i] = 10 * values[i-1];
//        }

        long endTime = System.currentTimeMillis();
        this.time = Long.toString(endTime-startTime);
//        this.value = Integer.toString(values[values.length-1]);

    }
}
