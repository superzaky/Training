package com.company;

import service.Solution;

/*
Problem 4 Largest palindrome product
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class P4 implements Solution {
    public static void main(String[] args) {
        /**
         * First observation is that the number must be between 9^2 and 99^2 or in the range of [81,9801].
         * As the majority of numbers has 4 digits and we're looking for the
         * largest, we ignore 2 digits numbers. Based on this, we can construct a palindromic number as:
         *  ′abba′​=1000a+100b+10b+a
         *           =1001a+110b
         *           =11(91a + 10b)
         *
         * This means that each palindrome will be a multiple of 11.
         *
         * As such, we're looking for two largest numbers p,q
         *       p*q =11(91a + 10b)
         */
        System.out.println(checkPalindromes(99, 9, 99));

        /**
         * First observation is that the number must be between 100^2 and 999^2 or in the range of [10000,998001].
         * As the majority of numbers has 6 digits and we're looking for the
         * largest, we ignore 5 digits numbers. Based on this, we can construct a palindromic number as:
         *  ′abccba′​=100000a+10000b+1000c+100c+10b+a
         *
         * Adding similar variables (in algebraic notation):
         *           =100001a+10010b+1100c
         *
         *           The common denominator is 11:
         *           =11(9091a + 910b + 100c)
         *
         * This means that each palindrome will be a multiple of 11.
         *
         * As such, we're looking for two largest numbers p,q
         *       p*q =11(9091a+910b+100c)
         */
        System.out.println(checkPalindromes(990, 99, 999));
    }

    private static int checkPalindromes(int h, int i, int j) {
        int maxPalin = 0;
        for (int p = h; p > i; p -= 11) {
            for (int q = j; q > i; q--) {
                int product = p * q;
                MaxPalindrome maxPalindrome = new MaxPalindrome(maxPalin, product);
                maxPalindrome.setMaxPalinIfNecessary();
                maxPalin = maxPalindrome.getMaxPalinValue();
            }
        }
        return maxPalin;
    }

    /*
        Voorbeeld met product = 909
        1ste iteratie
        n = 9 = 0 * 10 + 9 ( = 909 % 10 )
        product = 90 = 909 / 10 | 0
        2e iteratie
        n = 90 = 9 * 10 + 0 ( = 90 % 10 )
        product = 9 = 90 / 10 | 0
        3e iteratie
        n = 909 = 90 * 10 + 9 ( = 9 % 10 )
        product = 0 = 9 / 10 | 0

        n (909) == product (909)
     */
    private static boolean isPalindrome(int product) {
        int n = 0;
        int currentProduct = product;

        while (product > 0) {
            n = n * 10 + product % 10;
            product = product / 10 | 0;
        }
        return n == currentProduct;
    }

    @Override
    public String run() {
        return String.valueOf(checkPalindromes(990, 99, 999));
    }

    private static class MaxPalindrome {
        private int maxPalin;
        private int product;

        public MaxPalindrome(int maxPalin, int product) {
            this.maxPalin = maxPalin;
            this.product = product;
        }

        public int getMaxPalinValue() {
            return maxPalin;
        }

        public void setMaxPalinIfNecessary() {
            if (maxPalin < product && isPalindrome(product)) {
                maxPalin = product;
            } else if (product < maxPalin) {
            }
        }
    }
}
