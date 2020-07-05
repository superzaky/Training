package com.company;

import service.Solution;

public class P1 implements Solution {

    public static void main(String[] args) {
        /*
        Multiples of 3 and 5
        Problem 1
        If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

        Find the sum of all the multiples of 3 or 5 below 1000.
         */

        System.out.println( new P1().run() );
    }

    @Override
    public String run() {

//        int sum = 0;
//        for (int i = 3; i < 1000; i++) {
//            if (i % 3 == 0 || i % 5 == 0) {
//                sum += i;
//            }
//        }
//        System.out.println(sum);

        //Betere oplossing zonder loop
        //This solution is based on the following observation:
        //1 + 2 + ... + n = n*(n+1)/2
//        int nr = 1000;
//        nr--;
//        int x3 = nr/3;
//        int x5 = nr/5;
//        int x15 = nr/15;
//
//        long sum1 = 3*x3*(x3+1);
//        long sum2 = 5*x5*(x5+1);
//        // There is a caveat! Both of these count multiples of both 15. It counts/adds them twice one for each.
//        //So in order to balance that out, we subtract once in the following line:
//        //long sum = (sum1+sum2-sum3)/2;
//        long sum3 = 15*x15*(x15+1);
//
//        long sum = (sum1+sum2-sum3)/2;

        // My own solution
        float sum1 = calculateSumOfMultiplier(3);
        float sum2 = calculateSumOfMultiplier(5);
        float sum3 = calculateSumOfMultiplier(15);

        long sum = (long) (sum1+sum2-sum3);

        return String.valueOf(sum);
    }

    public float calculateSumOfMultiplier(int multiplier){
        /*
         *  Formula to calculate sum of n multiples
         *           S = n/2 * (a + l)
         *  where S is the sum of n elements (multiples)
         *        n is the number of elements (multiples)
         *        a is the first element (multiplier) in the series
         *        l is a * n
         */
        long n = 999 / multiplier;
        float q = n/ 2.0f;
        return  q* ( multiplier + multiply( n, multiplier));
    }

    private long multiply(long n, int multiplier) {
        return n * multiplier;
    }
}
