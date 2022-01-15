package com.practice.geeksforgeeks.arrays;

/**
 * Given a vector of N positive integers and an integer X. The task is to find the frequency of X in vector.
 * Example 1:
 * <p>
 * Input:
 * N = 5
 * vector = {1, 1, 1, 1, 1}
 * X = 1
 * Output:
 * 5
 * Explanation: Frequency of 1 is 5.
 */
public class ElementFrequency {
    public static void main(String[] args) {
        int[] input = {1, 1, 1, 1, 2};
        int n = 1;
        int result = 0;
        for (int i : input) {
            if (i == n)
                result++;
        }
        System.out.println("Frequency is: " + result);
    }
}
