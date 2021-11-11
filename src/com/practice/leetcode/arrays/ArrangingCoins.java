package com.practice.leetcode.arrays;

/**
 * 441: Arrangind Coins
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * <p>
 * Given n, find the total number of full staircase rows that can be formed.
 * <p>
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * <p>
 * Example 1:
 * <p>
 * n = 5
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 3rd row is incomplete, we return 2.
 */
public class ArrangingCoins {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(arrangeCoins(n));
    }

    private static int arrangeCoins(int n) {
        int k = 0;
        while (n > 0) {
            if (n > k)
                k++;
            n = n - k;
        }
        return k;
    }
}
