package com.practice.geeksforgeeks.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array a[] of size N which contains elements from 0 to N-1, you need to find all the elements occurring more than once in the given array.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * N = 4
 * a[] = {0,3,1,2}
 * Output: -1
 * Explanation: N=4 and all elements from 0
 * to (N-1 = 3) are present in the given
 * array. Therefore output is -1.
 */
public class FindDuplicates {
    public static void main(String[] args) {
        int[] input = {2, 3, 1, 2, 3};
        int n = 4;
        int result = -1;
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i : input) {
            if (set.contains(i))
                list.add(i);
            set.add(i);
        }
        if (set.size() == n)
            System.out.println("Result is: " + -1);
        else
            System.out.println(list);
    }
}
