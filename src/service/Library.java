package service;

public class Library {
    // Returns floor(sqrt(x)), for x >= 0.
    public static long sqrt(long x) {
        if (x < 0)
            throw new IllegalArgumentException("Square root of negative number");
        long y = 0;
        for (long i = 1L << 31; i != 0; i >>>= 1) {
            y |= i;
            if (y > 3037000499L || y * y > x)
                y ^= i;
        }
        return y;
    }
}
