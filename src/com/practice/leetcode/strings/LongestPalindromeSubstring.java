package com.practice.leetcode.strings;

/**
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 */
public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        String answer = longestPalindrome("xabbayz");
        System.out.println(answer);
    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;
        int n = s.length();
        //to capture start and end (i and j)
        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int maxLength = 0;
        //STEP 1
        //Fill in diagonal as true. Since every diagonal element starting from (0,0) -> (n-1, n-1) are palindrome by itself (single character)
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            start = i;
            maxLength = 1;
        }


        //STEP 2
        //Fill in diagonal + 1 element
        // ex: ab
        // (0,0) -> a |  (0, 1) -> b which is not palindrom, hence fill with false;
        // ex: aa
        // (0,0) -> a |  (0, 1) -> a which is a palindrome, hence fill with true;
        for (int i = 0; i < s.length() - 1; i++) {
            if (dp[i][i] && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }


        //STEP 3
        //For elements greater than 2, until max length of the string;
        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {

                int j = i + k - 1;
                //compare first and last element in the new length of the substring
                //if they are equal then check if the middle portion is a valid palindrome by looking up in the dp table.
                // ex: aba (i = 0, j = 2) of substring xabay
                // first and last characters are a,
                // check for dp[0][1], which is true in this case from step 1.
                if (s.charAt(i) == s.charAt(j)) {
                    if (dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                        if (k > maxLength) {
                            start = i;
                            maxLength = k;
                            System.out.println("start->" + start + " maxLength ->" + maxLength);
                        }
                    }
                }


            }
        }

        return s.substring(start, start + maxLength);

    }

}
