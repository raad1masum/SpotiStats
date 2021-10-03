package com.example.sping_portfolio.controllers.PrimeRishi;

public abstract class PrimeAbstract {
    
    int nth;
    String method;
    String value;
    String time;

    public PrimeAbstract(String nth){
        this.nth = validate(nth);
    }

    public int validate(String inp){
        try {
            return Math.min(Integer.parseInt(inp), 70000);
        }
        catch(Exception e) {
            // System.out.println(e.getMessage());
            return 50;
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
