package com.practice.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class CountNegatives {

    public static void main(String[] args) {
//        int[][] input = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
//        System.out.println(countNegatives(input));
//        System.out.println(freqAlphabets("10#11#12"));
//        System.out.println((int) 'a' - 97);
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] ints : grid) {
            for (int j = ints.length - 1; j > -1; j--) {
                if (ints[j] < 0)
                    count++;
                else
                    break;
            }
        }
        return count;
    }

    public static String freqAlphabets(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 <= s.length() - 1 && s.charAt(i + 2) == '#') {
                stringBuilder.append((char) (Integer.parseInt(s.substring(i, i + 2)) + 96));
                i += 2;
            } else {
                stringBuilder.append((char) (Integer.parseInt(s.substring(i, i + 1)) + 96));
            }
        }
        return stringBuilder.toString();
    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> morseSet = new HashSet<>();
        for (String w : words) {
            StringBuilder result = new StringBuilder();
            for (char c : w.toCharArray()) {
                result.append(morseCodes[(int) c - 97]);
            }
            morseSet.add(result.toString());
        }
        return morseSet.size();
    }

}
