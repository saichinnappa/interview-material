package com.practice.leetcode.misc;

/**
 * 7
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int rev = 0;
        int x = 321;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10) break;
            if (rev < Integer.MIN_VALUE / 10) break;
            rev = rev * 10 + pop;
        }
        System.out.println(rev);
    }
}
