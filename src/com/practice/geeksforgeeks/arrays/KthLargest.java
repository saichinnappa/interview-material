package com.practice.geeksforgeeks.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array arr[] and an integer K where K is larger than size of array,
 * the task is to find the Kth Largest element in the given array. It is given that all array elements are distinct.
 * <p>
 * Example 1:
 * Input:
 * N = 6
 * arr[] = 7 10 4 3 20 15
 * K = 3
 * Output : 10
 */
public class KthLargest {
    public static void main(String[] args) {
        int[] input = {7, 10, 4, 3, 20, 15};
        int k = 3;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new ElementComparator());
        for (int i : input)
            queue.offer(i);
        int result = -1;
        while (k != 0) {
            result = queue.poll();
            k--;
        }
        System.out.println("Kth Largest is: " + result);
    }
}

class ElementComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) return -1;
        if (o1 < o2) return 1;
        return 0;
    }
}
