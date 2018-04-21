package com.company;

import service.Library;
import service.Solution;

public class P3 implements Solution {
    /*
    Largest prime factor
    Problem 3
    The prime factors of 13195 are 5, 7, 13 and 29.

    What is the largest prime factor of the number 600851475143 ?
    */
    public static void main(String[] args) {
        //Onderstaande werkt ook, maar is lastiger te begrijpen
//        System.out.println(new P3().run());
        System.out.println(maxPrimeFactor(600851475143L));
//        System.out.println(maxPrimeFactor(21));
    }

    public static long maxPrimeFactor(long n) {
        long factor = -1;
        for (int i = 2; i * i <= n; i++) {
            System.out.println("i= "+i);
            if (n == 1) { break; }
            if (n % i != 0) { continue; }
            factor = i;
            while (n % i == 0) {
                n /= i;
                System.out.println(" in while i= "+i);
                System.out.println("n= "+n);
            }
        }
        return n == 1 ? factor : n;
    }

    /*
     * By the fundamental theorem of arithmetic, every integer n > 1 has a unique factorization as a product of prime numbers.
     * In other words, the theorem says that n = p_0 * p_1 * ... * p_{m-1}, where each p_i > 1 is prime but not necessarily unique.
     * Now if we take the number n and repeatedly divide out its smallest factor (which must also be prime), then the last
     * factor that we divide out must be the largest prime factor of n. For reference, 600851475143 = 71 * 839 * 1471 * 6857.
     */
    @Override
    public String run() {
//        long n = 21;
        long n = 600851475143L;
        while (true) {
            long p = smallestFactor(n);
            System.out.println("p= "+p);
            if (p < n)
                n /= p;
            else
                return Long.toString(n);
        }
    }

    // Returns the smallest factor of n, which is in the range [2, n]. The result is always prime.
    private static long smallestFactor(long n) {
        if (n <= 1)
            throw new IllegalArgumentException();
        for (long i = 2, end = Library.sqrt(n); i <= end; i++) {
            if (n % i == 0)
                return i;
        }
        return n;  // n itself is prime
    }
}
