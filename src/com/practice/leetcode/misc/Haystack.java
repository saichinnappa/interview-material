package com.practice.leetcode.misc;

public class Haystack {
    public static void main(String[] args) {
        System.out.println(strStr("aaa", "a"));
    }

    private static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int needleLength = needle.length();
        char firstChar = needle.charAt(0);
        int count = -1;
        for (int i = 0; i < haystack.length(); i++) {
            int val = i + needleLength;
            if (val <= haystack.length()) {
                if (haystack.charAt(i) == firstChar && haystack.substring(i, i + needleLength).equals(needle)) {
                    count = i;
                    break;
                }
            }
        }
        return count;
    }
}
