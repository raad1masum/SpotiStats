package com.example.sping_portfolio.controllers.ArnavMultiplication;

public abstract class multiplicationClass {

    int nth;
    String method;
    String value;
    String time;

    public multiplicationClass(String nth){

        this.nth = validate(nth);
    }

    public int validate(String inp){
        try {
            return Math.min(Integer.parseInt(inp), 100000);
        }
        catch(Exception e) {
            return 0;
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

        return "0";
    }

    public String getValue(){

        return "50000";
    }

}
