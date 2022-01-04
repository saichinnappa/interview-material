package com.practice.designgurus.arrays.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * <p>
 * You can assume that K is less than or equal to the length of the given string.
 * <p>
 * Example 1:
 * <p>
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * Example 2:
 * <p>
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 * Example 3:
 * <p>
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 */
public class LongestSubStringWithKDistinctChars {
    public static void main(String[] args) {
        int ans = helper("cbbebi", 3);
        System.out.println(ans);
    }

    private static int helper(String input, int k) {
        Set<Character> set = new HashSet<>();
        char[] arr = input.toCharArray();
        int result = Integer.MIN_VALUE;
        int startWindow = 0;
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            if (set.size() == k) {
                result = Math.max(result, i - startWindow + 1);
            } else if (set.size() > k) {
                set.remove(arr[startWindow]);
                startWindow = i;
            }

        }
        return result;
    }
}
