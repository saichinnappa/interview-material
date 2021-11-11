package com.practice.leetcode.misc;

public class SortArray {

    public static void main(String[] args) {
        int[] num = {6, 5, 4, 8};
        sortArray(num);
    }

    private static void sortArray(int[] num) {

        for (int i = 0; i < num.length - 1; i++) {
            int temp = num[i];
            if (num[i] >= num[i + 1]) {
                num[i] = num[i + 1];
                num[i + 1] = temp;
            }
        }
        for (int n : num) {
            System.out.println(n);
        }

    }


}
