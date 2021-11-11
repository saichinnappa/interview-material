package com.practice.leetcode.misc;

/**
 * 1360
 * Given a string s. You should re-order the string using the following algorithm:
 * <p>
 * Pick the smallest character from s and append it to the result.
 * Pick the smallest character from s which is greater than the last appended character to the result and append it.
 * Repeat step 2 until you cannot pick more characters.
 * Pick the largest character from s and append it to the result.
 * Pick the largest character from s which is smaller than the last appended character to the result and append it.
 * Repeat step 5 until you cannot pick more characters.
 * Repeat the steps from 1 to 6 until you pick all characters from s.
 * In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.
 * <p>
 * Return the result string after sorting s with this algorithm.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aaaabbbbcccc"
 * Output: "abccbaabccba"
 * Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
 * After steps 4, 5 and 6 of the first iteration, result = "abccba"
 * First iteration is done. Now s = "aabbcc" and we go back to step 1
 * After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
 * After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
 */
public class IncreasingDecreasingString {
    public static void main(String[] args) {
        String s = "aaaabbbbcccc";
        increasingDecreasingString("aaaabbbbcccc");

    }

    private static void increasingDecreasingString(String s) {
        int[] alphabetCount = new int[26];
        for (int index = 0; index < s.length(); index++) {
            alphabetCount[s.charAt(index) - 'a']++;
        }
        StringBuilder result = new StringBuilder();
        int count = 0;
        while (count != s.length()) {
            for (int i = 0; i < 26; i++) {
                if (alphabetCount[i] > 0) {
                    result.append((char) (97 + i));
                    alphabetCount[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (alphabetCount[i] > 0) {
                    result.append((char) (97 + i));
                    alphabetCount[i]--;
                }
            }
            count++;
        }
        System.out.println(result.toString());
    }


}
