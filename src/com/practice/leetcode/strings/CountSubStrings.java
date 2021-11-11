package com.practice.leetcode.strings;

public class CountSubStrings {

    public static void main(String[] args) {
        System.out.println(countLetters("aaaaaaaaaa"));
    }

    public static int countLetters(String S) {
        int count = 1;
        int count1 = 0;
        if (unique(S))
            count1++;
        while (count != S.length()) {
            for (int i = 0; i < S.length(); i++) {
                if (i + count <= S.length()) {
                    String temp = S.substring(i, i + count);
                    if (unique(temp)) {
                        count1++;
                    }
                }
            }
            count++;
        }
        return count1;
    }

    private static boolean unique(String substring) {
        char[] arr = substring.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
