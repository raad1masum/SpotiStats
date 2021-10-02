package com.nighthawk.csa.algorithm.eulersTotientModel;

import com.nighthawk.csa.consoleUI.ConsoleMethods;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;

import lombok.Getter;

@Getter  // this will enable standard Getters on attributes in Class in form "getName" where "name" 
public abstract class _EulersTotient {
    int size;
    String name;
    int hashID;
    Duration timeElapsed;
    ArrayList<Long> list;
    HashMap<Integer, Object> hash;

    /*
     Zero parameter constructor uses Telescoping technique to allow setting of the required value nth
     @param: none
     */
    public _EulersTotient() {
        this( 20);
    }

    /*
     Construct the nth euler's number
     @param: nth number, the value is constrained to 92 because of overflow in a long
     */
    public _EulersTotient(int nth) {
        this.size = nth;
        this.list = new ArrayList<>();
        this.hashID = 0;
        this.hash = new HashMap<>();
        //initialize euler's and time algorithm
        Instant start = Instant.now();  // time capture -- start
        this.init();
        Instant end = Instant.now();    // time capture -- end
        this.timeElapsed = Duration.between(start, end);
    }

    /*
     Method is abstract as init() requires extender to define their own Euler's Totient algorithm
     Method is protected as it is only authorized to someone who extends the class
     */
    protected abstract void init();

    /*
     Number is added to Euler's sequence, current state of "list" is added to hash for hashID "num"
     */
    public void setData(long num) {
        list.add(num);
        hash.put(this.hashID++, list.clone());
    }

    /*
     Custom Getter for timeElapsed in init process, timeElapsed.getNano() is part of Duration class
     */
    public int getTimeElapsed() {
        return timeElapsed.getNano();
    }

    /*
     Custom Getter to return last element in Euler's sequence
     */
    public long getNth() {
        return list.get(size - 1);
    }

    /*
     Custom Getter to return last Euler's sequence in HashMap
     */
    public Object getNthSeq(int i) {
        return hash.get(i);
    }

    public Object getList() {
        return this.list;
    }

    public Object getHash() {
        return this.hash;
    }

    /*
     Console/Terminal supported print method
     */
    public void print() {
        ConsoleMethods.println("Init method = " + this.name);
        ConsoleMethods.println("Init time = " + this.getTimeElapsed());
        ConsoleMethods.println("Euler's Number " + this.size + " = " + this.getNth());
        ConsoleMethods.println("Euler's List = " + this.getList());
        ConsoleMethods.println("Euler's Hashmap = " + this.getHash());
        for (int i=0 ; i<this.size; i++ ) {
            ConsoleMethods.println("Euler's Sequence " + (i+1) + " = " + this.getNthSeq(i));
        }
    }

    /*
    Tester class method.  This calls "main" class of each of the extended classes in the package
     */
    public static void main(String[] args) {
        EulersTotientFor.main(null);
        EulersTotientRecurse.main(null);
        EulersTotientStream.main(null);
        EulersTotientWhile.main(null);
    }
}