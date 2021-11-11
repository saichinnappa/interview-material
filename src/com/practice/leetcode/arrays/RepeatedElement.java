package com.practice.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * LC: 961: N-Repeated Element in Size 2N Array
 * <p>
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
 * <p>
 * Return the element repeated N times.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,3]
 * Output: 3
 */
public class RepeatedElement {
    public static void main(String[] args) {
        int[] input = {1, 2};
        System.out.println(repeatedNTimes(input));
    }

    private static int repeatedNTimes(int[] A) {
        int count = A.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : A) {
            int val = map.get(n) == null ? 1 : map.get(n) + 1;
            map.put(n, val);
            if (val == count) {
                return n;
            }
        }
        return -1;
    }

}
