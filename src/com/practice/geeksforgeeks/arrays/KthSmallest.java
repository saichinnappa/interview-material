package com.practice.geeksforgeeks.arrays;

import java.util.PriorityQueue;

/**
 * Given an array arr[] and an integer K where K is smaller than size of array,
 * the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * N = 6
 * arr[] = 7 10 4 3 20 15
 * K = 3
 * Output : 7
 * Explanation :
 * 3rd smallest element in the given
 * array is 7.
 */
public class KthSmallest {
    public static void main(String[] args) {
        int[] input = {7, 10, 4, 3, 20, 15};
        int k = 3;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : input)
            queue.offer(i);

        int result = -1;
        while (k != 0) {
            result = queue.poll();
            k--;
        }
        System.out.println("kth smallest is: " + result);
    }
}
