package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * <p>
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 */
public class CombinationSum {
    static List<List<Integer>> result = new ArrayList<>();
    static int[] input = {2, 3, 5};
    static int target = 8;
    int i = 0;

    public static void main(String[] args) {
        Arrays.sort(input);
        List<Integer> list = new ArrayList<>();
        solve(list, target, 0);
        System.out.println(result);
    }

    private static void solve(List<Integer> list, int sum, int start) {
        if (isValid(sum)) {
            result.add(new ArrayList<>(list));
            return;
        } else if (sum < 0) {
            return;
        }
        for (int i = 0; i < input.length; i++) {
            list.add(input[i]);
            solve(list, sum - input[i], i);
            list.remove(list.size() - 1);
        }
    }

    static boolean isValid(int sum) {
        return sum == 0;
    }

}
