package com.practice.leetcode.misc;

import java.util.HashMap;
import java.util.Map;

public class FindWords {
    public static void main(String[] args) {
        String[] words = {"hello", "world", "leetcode"};
        System.out.println(countCharacters(words, "welldonehoneyr"));
    }

    private static int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charMap = new HashMap<>();
        char[] charArray = chars.toCharArray();
        for (char c : charArray) {
            if (!charMap.containsKey(c))
                charMap.put(c, 1);
            else {
                int val = charMap.get(c) + 1;
                charMap.replace(c, val);
            }
        }
        int length = 0;
        for (String s : words) {
            System.out.println("processing:: " + s);
            boolean found = false;
            char[] wordArray = s.toCharArray();
            Map<Character, Integer> countCharMap = new HashMap<>();
            for (char c : wordArray) {
                if (!countCharMap.containsKey(c))
                    countCharMap.put(c, 1);
                else {
                    int val = countCharMap.get(c) + 1;
                    countCharMap.replace(c, val);
                }
            }
            for (Map.Entry<Character, Integer> entry : countCharMap.entrySet()) {
                Character k = entry.getKey();
                System.out.println(k);
                if (charMap.containsKey(k) && charMap.get(k) >= countCharMap.get(k)) {
                    found = true;
                } else {
                    found = false;
                    break;
                }
            }
//            countCharMap.forEach((k,v) -> {
//                if(charMap.containsKey(k) && charMap.get(k) >= countCharMap.get(k)){
//                    return 5;
//                }
//            });
            if (found) {
                System.out.println(s);
                length += s.length();
            }
        }

        return length;
    }
}
