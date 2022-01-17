package com.practice.geeksforgeeks.arrays;

public class MinValueInRotatedSubArray {
    public static void main(String[] args) {
        int[] input = {4, 5, 0, 1, 2, 3};
        int rIdx = findRotatedIndex(input, 0, input.length - 1);
        System.out.println("Min Element: " + input[rIdx]);
    }

    private static int findRotatedIndex(int[] input, int start, int end) {
        if (input[start] < input[end])
            return 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (input[mid] > input[mid + 1])
                return mid + 1;
            else if (input[mid] < input[start])
                end = mid - 1;
            else if (input[mid] >= input[start])
                start = mid + 1;
        }
        return -1;
    }
}
