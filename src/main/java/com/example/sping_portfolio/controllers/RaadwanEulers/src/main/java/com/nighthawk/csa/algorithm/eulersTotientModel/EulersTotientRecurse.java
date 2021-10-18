public class EulersTotientRecurse extends _EulersTotient {
    public EulersTotientRecurse() {
        super();
    }
    public EulersTotientRecurse(int nth) {
        super(nth);
    }

    public long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b , a % b);
    }

    /*
    Abstract Polymorphic "init()" method using Recursion
    */
    @Override
    protected void init() {
        //setup for recursion
        super.name = "Recursion";
        long limit = super.size;
        long i = 1;
        // long[] f = new long[]{0, 1};
        initRecurse(i, limit);       // recursion is redirected
    }

    /*
    Recursive methods contains an escape, in this  "base condition" with a limit
    VERY IMPORTANT... recursion requires pre-decrement, post-decrement will not occur until unstacking
     */
    private void initRecurse(long i, long limit) {
        if (i >= limit) return;

        if (gcd(i, limit) == 1) super.setData(i);

        initRecurse(++i, limit);
    }

    /*
    Class method "main" with purpose of testing EulersTotientRecurse
     */
    public static void main(String[] args) {
        _EulersTotient eulers = new EulersTotientRecurse();  // "EulersTotientRecurse" is used as initializer for the "_EulersTotient eulers"  object
        eulers.print();
    }
}
