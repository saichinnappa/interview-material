package com.practice.geeksforgeeks.arrays;

/**
 * You are given a string s. You need to reverse the string.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = Geeks
 * Output: skeeG
 */
public class ReverseArray {
    public static void main(String[] args) {
        String input = "abcde";
        char[] arr = input.toCharArray();
        int length = input.length() - 1;
        int mid = (input.length() % 2 == 0) ? (input.length() / 2) - 1 : input.length() / 2;
        for (int i = 0; i <= mid; i++) {
            char temp = arr[i];
            arr[i] = arr[length - i];
            arr[length - i] = temp;
        }
        System.out.println("Reverse String: " + String.valueOf(arr));
    }
}
