package com.practice.leetcode.misc;

public class ArmstrongNumber {
    public static void main(String[] args) {
        System.out.println(maximum69Number(9669));
    }

    public static boolean isArmstrong(int N) {
        char[] array = String.valueOf(N).toCharArray();
        int result = 0;
        for (char c : array) {
            result += Math.pow(Integer.parseInt(String.valueOf(c)), String.valueOf(N).length());
        }
        return result == N;
    }

    public static int maximum69Number(int n) {
        char[] array = String.valueOf(n).toCharArray();
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (count != 1 && Integer.parseInt(String.valueOf(array[i])) != 9) {
                result.append(9);
                count++;
            } else
                result.append(array[i]);

        }
        return Integer.parseInt(result.toString());
    }
}
