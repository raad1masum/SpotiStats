public class EulersTotientFor extends _EulersTotient {
    // zero and one argument constructors, both defer to super
    public EulersTotientFor() { super(); }
    public EulersTotientFor(int nth) {
        super(nth);
    }

    public long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b , a % b);
    }

    /*
    Abstract Polymorphic "init()" method using For
     */
    @Override
    protected void init() {
        super.name = "For";
        long limit = super.size;
        // for loops are likely the most common iteration structure, all the looping facts are in one line
        for (long i = 1; i < limit; ++i)
            if (gcd(i, limit) == 1)
                super.setData(i);
    }

    /*
    Class method "main" with purpose of testing EulersTotientFor
     */
    public static void main(String[] args) {
        _EulersTotient eulers = new EulersTotientFor(); // "EulersTotientFor" is used as initializer for the "_EulersTotient eulers"  object
        eulers.print();
    }
}
