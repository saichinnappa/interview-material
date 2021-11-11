package com.practice.leetcode.strings;

/**
 * 1221:Split a String in Balanced Strings
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 * <p>
 * Given a balanced string s split it in the maximum amount of balanced strings.
 * <p>
 * Return the maximum amount of splitted balanced strings.
 * Example 1:
 * <p>
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 */
public class SplitBalancedStrings {
    public static void main(String[] args) {
        String input = "RLRRRLLRLL";
        System.out.println(balancedStringSplit(input));
    }

    public static int balancedStringSplit(String s) {
        int result = 0;
        int rCount = 0, lCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R')
                rCount++;
            else
                lCount++;
            if (rCount == lCount) {
                result++;
                rCount = 0;
                lCount = 0;
            }
        }
        return result;
    }
}
