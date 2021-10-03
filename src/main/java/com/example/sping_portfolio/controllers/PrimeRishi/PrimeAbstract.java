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
            return Integer.parseInt(inp);
        }
        catch(Exception e) {
            return 5;
        }
    }

    public void compute() {

    }

    public String getMethod(){
        return this.method;
    } 

    public String getIndex(){
        return Integer.toString(nth);
    }

    public String getTime(){
        return time.toString();
    }

    public String getValue(){
        return this.value;
    }

}
