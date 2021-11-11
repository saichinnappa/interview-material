package com.practice.leetcode.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. Jewels and Stones
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * <p>
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 */
public class JewelsAndStones {

    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, stones));
    }

    public static int numJewelsInStones(String J, String S) {
        Set<Character> jewelsSet = new HashSet<>();
        int totalJwelesIOwn = 0;
        for (char jewel : J.toCharArray())
            jewelsSet.add(jewel);
        for (char stone : S.toCharArray()) {
            if (jewelsSet.contains(stone)) {
                totalJwelesIOwn++;
            }
        }
        return totalJwelesIOwn;
    }
}
