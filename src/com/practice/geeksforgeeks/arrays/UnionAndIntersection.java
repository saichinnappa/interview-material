package com.practice.geeksforgeeks.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays a[] and b[] of size n and m respectively. The task is to find union between these two arrays.
 * <p>
 * Union of the two arrays can be defined as the set containing distinct elements from both the arrays. If there are repetitions, then only one occurrence of element should be printed in the union.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 5 3
 * 1 2 3 4 5
 * 1 2 3
 * Output:
 * 5
 * Explanation:
 * 1, 2, 3, 4 and 5 are the
 * elements which comes in the union set
 * of both arrays. So count is 5.
 */
public class UnionAndIntersection {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 2, 3};
        Set<Integer> set = new HashSet<>();
        int intersectionCount = 0;
        for (int i : a)
            set.add(i);
        for (int j : b) {
            if (set.contains(j))
                intersectionCount++;
            set.add(j);
        }
        System.out.println("Union Count: " + set.size() + " | Intersection Count: " + intersectionCount);
    }
}
