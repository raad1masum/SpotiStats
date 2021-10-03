package com.example.sping_portfolio.controllers.AmanTribonacci;


public abstract class TribonacciAbstract {

    int nth;
    String method;
    String value;
    String time;

    public TribonacciAbstract(String nth){
        this.nth = validate(nth);
    }

    public int validate(String inp){
        try {
            return Integer.parseInt(inp);
        }
        catch(Exception e) {
            return 1;
        }
    }

    public void compute() {

    }

    public String getMethod(){
        return this.method;
    }

    public String getIndex(){
        return Integer.toString(this.nth);
    }

    public String getTime(){
        return this.time;
    }

    public String getValue(){
        return this.value;
    }

}


