package com.practice.ctci.strings;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.isUnique("abcde"));
//        System.out.println(solution.inplaceReverse("hello"));
//        System.out.println(solution.replaceSpaces("Mr John Smith    ", 13));
//        System.out.println(solution.isCombinationUsingCharacterCount("abc", "cba"));
//        System.out.println(solution.compress("aabcccccaaa"));
        System.out.println(solution.isSubstringIntelligentWay("waterbottle", "erbottlewat"));
    }

    public boolean isUnique(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray.length; j++) {
                if (i != j && charArray[i] == charArray[j])
                    return false;
            }
        }
        return true;
    }

    String reverse(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i > -1; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    String inplaceReverse(String s) {
        int mid = s.length() / 2;
        int startIdx = 0;
        char[] charArray = s.toCharArray();
        for (int i = charArray.length - 1; i >= mid; i--) {
            char temp = charArray[i];
            charArray[i] = charArray[startIdx];
            charArray[startIdx] = temp;
            startIdx++;
        }
        return String.valueOf(charArray);
    }

    String replaceSpaces(String s, int length) {
        System.out.println(s.length());
        char[] charArray = s.toCharArray();
        for (int i = 0; i < length - 3; i++) {
            if (charArray[i] == ' ') {
                rotate(charArray, i);
                charArray[i] = '%';
                charArray[i + 1] = '2';
                charArray[i + 2] = '0';
                i = i + 3;
            }
        }
        return String.valueOf(charArray);
    }

    void rotate(char[] charArray, int index) {
        int count = 2;
        char temp = 0;
        while (count != 0) {
            for (int i = charArray.length - 1; i > index; i--) {
                charArray[i] = charArray[i - 1];
            }
            index += 1;
            System.out.println(String.valueOf(charArray));
            count--;
        }
    }

    boolean isCombinationUsingSort(String a, String b) {
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        Arrays.sort(aArray);
        Arrays.sort(bArray);
        return String.valueOf(aArray).equals(String.valueOf(bArray));
    }

    boolean isCombinationUsingCharacterCount(String a, String b) {
        char[] aArray = a.toCharArray();
        int[] characterCountTracker = new int[128];
        for (char c : aArray) {
            characterCountTracker[(int) (c - 97)]++;
        }
        char[] bArray = b.toCharArray();
        for (char c : bArray) {
            if (--characterCountTracker[c - 97] < 0)
                return false;
        }
        return true;
    }

    String compress(String word) {
        StringBuilder string = new StringBuilder();
        char[] charArray = word.toCharArray();
        int count = 1;
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] != charArray[i + 1]) {
                string.append(charArray[i]);
                string.append(count);
                count = 0;
            }
            count++;
        }
        string.append(charArray[charArray.length - 1]);
        string.append(count);
        return string.toString().length() > word.length() ? word : string.toString();
    }

    boolean isSubstring(String s1, String s2) {
        char firstChar = s1.charAt(0);
        StringBuilder result = new StringBuilder();
        int firstCharIndexRotatedString = -1;
        for (int i = 0; i < s2.toCharArray().length; i++) {
            if (s2.charAt(i) == firstChar) {
                firstCharIndexRotatedString = i;
            }
        }
        if (firstCharIndexRotatedString == -1) {
            return false;
        } else {
            result.append(s2.substring(firstCharIndexRotatedString));
            result.append(s2.substring(0, firstCharIndexRotatedString));
        }
        return result.toString().equals(s1);
    }

    boolean isSubstringIntelligentWay(String s1, String s2) {
        String newString = s1 + s1;
        return newString.contains(s2);
    }


}
