package com.practice.geeksforgeeks.arrays;

/**
 * Find Kth Smallest or Largest using QuickSelect Algorithm
 */
public class QuickSelect {
    public static void main(String[] args) {
        int[] input = {7, 1, 3, 4, 9};
        int largest = findKthLargest(input, 2, 0, input.length - 1);
        int smallest = findKthSmallest(input, 2, 0, input.length - 1);
        System.out.println("Kth Largest: " + largest);
        System.out.println("Kth Smallest: " + smallest);
    }

    private static int findKthLargest(int[] input, int k, int start, int end) {
        int pivot = input[end];
        int index = start - 1;
        for (int i = start; i <= end; i++) {
            if (input[i] <= pivot) {
                ++index;
                int temp = input[i];
                input[i] = input[index];
                input[index] = temp;
            }
        }
        if (index == (input.length - k))
            return input[index];
        else if (index > (input.length - k)) {
            return findKthLargest(input, k, start, index - 1);
        } else {
            return findKthLargest(input, k, index + 1, end);
        }
    }

    private static int findKthSmallest(int[] input, int k, int start, int end) {
        int pivot = input[end];
        int idx = start - 1;
        for (int i = start; i <= end; i++) {
            if (input[i] <= pivot) {
                ++idx;
                int temp = input[i];
                input[i] = input[idx];
                input[idx] = temp;
            }
        }
        if (idx == k - 1)
            return input[idx];
        else if (idx > k - 1) {
            return findKthSmallest(input, k, 0, idx - 1);
        } else {
            return findKthSmallest(input, k, idx + 1, end);
        }
    }
}
