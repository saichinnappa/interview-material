package com.practice.leetcode.strings;

/**
 * 1119. Remove Vowels from a String
 * Given a string S, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.
 * <p>
 * Example 1:
 * <p>
 * Input: "leetcodeisacommunityforcoders"
 * Output: "ltcdscmmntyfrcdrs"
 */
public class RemoveVowels {

    public static void main(String[] args) {
        removeVowels("leetcodeisacommunityforcoders");
    }

    private static String removeVowels(String input) {
        String vowels = "aeiouAEIOU";
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (vowels.indexOf(ch) == -1)
                stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}
