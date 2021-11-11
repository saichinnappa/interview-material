package com.practice.leetcode.misc;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }

    private static int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int count = 0;
        int val = 0;
        for (int i = 0; i < s.toCharArray().length - 1; i++) {
            if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
                val += 4;
                count += 2;
                i++;
            } else if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
                val += 9;
                count += 2;
                i++;
            } else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
                val += 40;
                count += 2;
                i++;
            } else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
                val += 90;
                count += 2;
                i++;
            } else if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
                val += 400;
                count += 2;
                i++;
            } else if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
                val += 900;
                count += 2;
                i++;
            } else {
                val += romanMap.get(s.charAt(i));
                count += 1;
            }
        }
        if (s.toCharArray().length - count == 1) {
            val += romanMap.get(s.charAt(s.length() - 1));
        }
        return val;
    }
}
