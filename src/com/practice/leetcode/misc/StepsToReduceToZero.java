package com.practice.leetcode.misc;

/**
 * 1342. Number of Steps to Reduce a Number to Zero
 * <p>
 * Given a non-negative integer num, return the number of steps to reduce it to zero.
 * If the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 * <p>
 * Example 1:
 * <p>
 * Input: num = 14
 * Output: 6
 * Explanation:
 * Step 1) 14 is even; divide by 2 and obtain 7.
 * Step 2) 7 is odd; subtract 1 and obtain 6.
 * Step 3) 6 is even; divide by 2 and obtain 3.
 * Step 4) 3 is odd; subtract 1 and obtain 2.
 * Step 5) 2 is even; divide by 2 and obtain 1.
 * Step 6) 1 is odd; subtract 1 and obtain 0.
 */
public class StepsToReduceToZero {
    public static void main(String[] args) {
        int input = 8;
        System.out.println(numberOfSteps(input));
    }

    public static int numberOfSteps(int num) {
        int steps = 0;
        while (num != 0) {
            steps++;
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num - 1;
            }
        }
        return steps;
    }
}
