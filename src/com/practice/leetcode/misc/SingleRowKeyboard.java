package com.practice.leetcode.misc;

import java.util.HashMap;
import java.util.Map;

public class SingleRowKeyboard {
    public static void main(String[] args) {
//        System.out.println(calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode"));
        System.out.println(calculateTime1("pqrstuvwxyzabcdefghijklmno", "leetcode"));
    }

    static int calculateTime(String keyboard, String word) {
        Map<Character, Integer> keyboardMap = new HashMap<>();
        int i = 0;
        for (Character c : keyboard.toCharArray()) {
            keyboardMap.put(c, i);
            i++;
        }
        int time = 0;
        char[] wordArray = word.trim().toCharArray();
        int currentIndex = 0;
        for (int j = 0; j < wordArray.length; j++) {
            System.out.println("C: " + wordArray[j] + "\t" + "I: " + keyboardMap.get(wordArray[j]) + "\t" + "CI: " + currentIndex + "\t" + "T: " + time);
            if (j == 0) {
                currentIndex = keyboardMap.get(wordArray[j]);
                time += currentIndex;
            } else {
                if (currentIndex == keyboardMap.get(wordArray[j])) {
                    time += 0;
                } else {
//                if(currentIndex > keyboardMap.get(wordArray[j])) {
                    time += Math.abs(currentIndex - keyboardMap.get(wordArray[j]));
                    currentIndex = keyboardMap.get(wordArray[j]);

                }

            }
        }
        return time;
    }

    public static int calculateTime1(String keyboard, String word) {
        int time = 0;
        int prevIndex = 0;
        for (int i = 0; i < word.length(); i++) {
            int currIndex = keyboard.indexOf(word.charAt(i));
            time += Math.abs(currIndex - prevIndex);
            prevIndex = currIndex;
        }
        return time;
    }

}
