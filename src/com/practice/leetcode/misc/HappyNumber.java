package com.practice.leetcode.misc;

/**
 * Write an algorithm to determine if a number n is "happy".
 * <p>
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Return True if n is a happy number, and False if not.
 * <p>
 * Example:
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        int result = 0;
        int modResult = 0;
        while (modResult != 4 && modResult != 1) {
            modResult += Math.pow(n % 10, 2);
            if (modResult == 1)
                return true;
            n = n / 10;
            if (n == 0) {
                n = modResult;
                modResult = 0;
            }
        }
        return false;
    }
}
