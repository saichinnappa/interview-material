package com.practice.leetcode.misc;

/**
 * 1281. Subtract the Product and Sum of Digits of an Integer
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 234
 * Output: 15
 * Explanation:
 * Product of digits = 2 * 3 * 4 = 24
 * Sum of digits = 2 + 3 + 4 = 9
 * Result = 24 - 9 = 15
 */
public class SubtractProductSumOfDigits {

    public static void main(String[] args) {
        int num = 234;
        System.out.println(subtractProductAndSum(num));
    }

    public static int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while (n >= 1) {
            int val = n % 10;
            sum += val;
            product *= val;
            n = n / 10;
        }
        return product - sum;
    }

}
