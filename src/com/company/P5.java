package com.company;

import service.Solution;

/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class P5 implements Solution {
    static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    public static void main(String[] args) {
//        brute force solution to get to 2520
//        int i = 10;

//        int[] numbers = {1, 2, 3, 4 , 5, 6, 7, 8, 9, 10};
//        int[] numbers = {210, 45};

//        while (i %  2 != 0 || i %  3 != 0 || i %  4 != 0 || i %  5 != 0 ||
//                i %  6 != 0 || i %  7 != 0 || i %  8 != 0 || i %  9 != 0 ||
//                i % 10 != 0){
//            i+=10;
//        }

//        System.out.println(i); //i = 2520

//        int i = 20;
//
//        while (i %  2 != 0 || i %  3 != 0 || i %  4 != 0 || i %  5 != 0 ||
//                i %  6 != 0 || i %  7 != 0 || i %  8 != 0 || i %  9 != 0 ||
//                i % 10 != 0 || i % 11 != 0 || i % 12 != 0 || i % 13 != 0 ||
//                i % 14 != 0 || i % 15 != 0 || i % 16 != 0 || i % 17 != 0 ||
//                i % 18 != 0 || i % 19 != 0 || i % 20 != 0 ){
//            i+=20;
//        }



        System.out.println(getLcmOfMultiple(numbers));
//        System.out.println(getLcmMultiple2(numbers));
//        int lcmAnswer = Arrays.stream(numbers).reduce(1, (a, b) -> {
//                  int total =  getLcmMultiple(a, b);
//                  return total;
//            }
//        );
//        System.out.println(lcmAnswer);
    }

    /**
     Suppose we have four numbers a,b,c,d. To calculate LCM of a,b,c,d, we need to follow these steps:
     Let the final LCM be equals to RES.

     Calculate LCM of first two numbers a and b. Assign the value to RES. So, RES = LCM(a,b).
     Calculate LCM of RES and c. Update the value of RES. So, RES = LCM(RES,c).
     Calculate LCM of RES and d. Update the value of RES. So, RES = LCM(RES,d).

     The final value of RES will contain the LCM of a,b,c,d.

     We can follow this algorithm to calculate LCM of multiple numbers.
     */
    private static long getLcmOfMultiple(int... numbers) {
        long lcm = 1;
        for (int i = 0; i<numbers.length -1; i++) {
            int curr = numbers[i];
            int next = numbers [i+1];
            lcm = getLcmOfFirst2NumbersOrUpdateLcm(lcm, curr, next);
        }
        return lcm;
    }

//    private static long getLcmMultiple2(int... numbers) {
//        long lcm = 1;
//        for (int i = 0; i<numbers.length; i++) {
//            lcm = getLcm(lcm, numbers[i]);
//        }
//        return lcm;
//    }

    private static long getLcmOfFirst2NumbersOrUpdateLcm(long lcm, int curr, int next) {
        if(lcm != 1){
            lcm = getLcm(lcm, getLcm(curr, next));
        }
        else{
            lcm = getLcm(curr, next);
        }
        return lcm;
    }

    private static long getLcm(long p, long q) {
        // Return lowest common multiple.
        long lcm = p * q / getGcd(p, q);
        return lcm;
    }

    private static long getGcd(long p, long q) {
        //Return greatest common divisor using Euclid's Algorithm.
        long temp;
        while (q != 0) {
            temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

    @Override
    public String run() {
        return String.valueOf(getLcmOfMultiple(numbers));
    }
}
