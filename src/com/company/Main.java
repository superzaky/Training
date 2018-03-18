package com.company;

public class Main {

    public static void main(String[] args) {
        /*
        Multiples of 3 and 5
        Problem 1
        If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

        Find the sum of all the multiples of 3 or 5 below 1000.
         */

//        int sum = 0;
//        for (int i = 3; i < 1000; i++) {
//            if (i % 3 == 0 || i % 5 == 0) {
//                sum += i;
//            }
//        }
//        System.out.println(sum);

        //Betere oplossing zonder loop
        int nr = 1000;
        nr--;
        int x3 = nr/3;
        int x5 = nr/5;
        int x15 = nr/15;

        long sum1 = 3*x3*(x3+1);
        long sum2 = 5*x5*(x5+1);
        long sum3 = 15*x15*(x15+1);

        long sum = (sum1+sum2-sum3)/2;
        System.out.println(sum);
    }
}
