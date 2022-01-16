package com.practice.geeksforgeeks.arrays;

/**
 * Given an integer N, find its factorial.
 * <p>
 * Example 1:
 * <p>
 * Input: N = 5
 * Output: 120
 * Explanation : 5! = 1*2*3*4*5 = 120
 */
public class Factorial {
    public static void main(String[] args) {
        int input = 1000;
        int result = factorial(input, 1);
        System.out.println("Result: " + result);
    }

    private static int factorial(int i, int curr) {
        if (i == 0)
            return curr;
        return factorial(i - 1, i * curr);
    }


}
