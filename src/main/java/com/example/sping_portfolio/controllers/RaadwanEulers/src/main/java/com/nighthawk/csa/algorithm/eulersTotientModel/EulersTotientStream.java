package com.example.sping_portfolio.controllers.RaadwanEulers.src.main.java.com.nighthawk.csa.algorithm.eulersTotientModel;

// import java.util.stream.Stream;
import java.util.ArrayList;

public class EulersTotientStream extends _EulersTotient {
    public EulersTotientStream() {
        super();
    }
    public EulersTotientStream(int nth) {
        super(nth);
    }

    public long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b , a % b);
    }

    /*
    Abstract Polymorphic "init()" method using Stream and Lambda expressions
    */
    @Override
    protected void init() {
        super.name = "Stream";
        ArrayList<Integer> enums = new ArrayList<>();

        // place all candidates into enums array
        for (int i = 0; i < super.size; ++i) enums.add(i);

        // stream to calculate phi
        enums.stream()
            .limit(super.size)
            .forEach(i -> {
                if (gcd(i, super.size) == 1) super.setData(i);
            });
    }

    /*
    Class method "main" with purpose of testing EulersTotientStream
     */
    public static void main(String[] args) {
        _EulersTotient eulers = new EulersTotientStream();
        eulers.print();
    }
}
