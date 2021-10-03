package com.example.sping_portfolio.controllers.AmanTribonacci;

public class TribonacciFor extends TribonacciAbstract {

    public TribonacciFor(String nth) {
        super(nth);
        this.method = "for";
    }

    private static int forTribNth(int n) {
        if (n == 0) {
            return 0;
        } else {
            int a = 0;
            int b = 0;
            int c = 1;
            for (int i = 0; i < n; i++) {
                int placeholder = 0;
                placeholder = a + b + c;
                a = b;
                b = c;
                c = placeholder;
            }
            return a;
        }


    }

    public void compute(){
        long startTime = System.currentTimeMillis();
        this.value = Integer.toString(forTribNth(nth));
        System.out.println("The answer is " + this.value);
        long endTime = System.currentTimeMillis();
        this.time = Long.toString(endTime-startTime);
    }
//    public void compute() {
//        long startTime = System.currentTimeMillis();
//        int a = 0;
//        int b = 0;
//        int c = 0;
//        int d = 0;
//        for (int i = 0; i < this.nth; i++) {
//            d = a + b + c;
//            c = d;
//            b = c;
//            a = b;
//        }
//        System.out.println("The answer is " + a);
//        this.value = Integer.toString(a);
//        long endTime = System.currentTimeMillis();
//        this.time = Long.toString(endTime-startTime);
//    }
}