package com.practice.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 * <p>
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 */
public class StringToInteger {

    public static void main(String[] args) {
        String[] input = {"42", "   -42", "4193 with words", "words and 987", "-91283472332"};
        System.out.println(Integer.MIN_VALUE);
        for (String s : input)
            System.out.println(myAtoi("-2147483647"));
    }

    public static int myAtoi(String s) {
        int result = 0;
        boolean isNegative = false;
        s = s.trim();
        if (s.length() == 0)
            return 0;

        char[] inputArray = s.toCharArray();

        List<Integer> list = new ArrayList<>();

        //check if its starting with a word , ex: "word 123"
        if (Character.isLetter(inputArray[0])) return 0;

        //look for '-' or '+' sign
        if (inputArray[0] == '-') {
            isNegative = true;
        }
        for (int i = 0; i < inputArray.length; i++) {

            if (i == 0 && (inputArray[i] == '+' || inputArray[i] == '-'))
                continue;
            if (!Character.isDigit(inputArray[i]))
                break;
//            System.out.println(inputArray[i]);
            list.add(inputArray[i] - '0');
        }

        int listLength = list.size();

        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
            result += list.get(i) * Math.pow(10, listLength - 1);
            listLength--;


        }


        if (result > Integer.MAX_VALUE && isNegative) {
            return Integer.MIN_VALUE;
        }
        if (result < Integer.MIN_VALUE && isNegative) {
            return Integer.MIN_VALUE;
        }

        if (isNegative)
            result *= -1;

        return result;
    }
}
