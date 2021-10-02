package com.nighthawk.csa.algorithm.eulersTotientModel;

public class EulersTotientWhile extends _EulersTotient {
    public EulersTotientWhile() {
        super();
    }
    public EulersTotientWhile(int nth) {
        super(nth);
    }

    public long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b , a % b);
    }

    /*
    Abstract Polymorphic "init()" method using While
    */
    @Override
    protected void init() {
        super.name = "While";
        // longer and more error prone "while" syntax is often best performer in this small scale test
        long limit = super.size;

        int i = 1;
        while (i < limit) {
            if (gcd(i, limit) == 1)
                super.setData(i);
            ++i;
        }
    }

    /*
    Class method "main" with purpose of testing EulersTotientWhile
     */
    public static void main(String[] args) {
        _EulersTotient eulers = new EulersTotientWhile();
        eulers.print();
    }
}
